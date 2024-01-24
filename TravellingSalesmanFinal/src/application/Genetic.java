package application;



import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class Genetic{

    
    static int getRandom(int minBound, int maxBound) {
        if (maxBound < minBound) {
            int temp = minBound;
            minBound = maxBound;
            maxBound = temp;
        }
        int range = maxBound - minBound + 1;
        return minBound + new Random().nextInt(range);
    }

    


}


class Individual{

    Integer INF = 1000000;

	
    ArrayList<Integer> path = new ArrayList<Integer>();
    int cost = INF;
    Graph graph;

    void setGraph(Graph graph){this.graph = graph;};

    Individual(){}; // Default constructor

    int getCost(){
    	return this.cost;
    }
    
    Individual(Individual A){
        this.path = A.path;
        this.cost = A.cost;
        this.graph = A.graph;
    }
    
    void generateRandomIndividual(){
    
        // Add starting node
        path.add(graph.startNode.getIndex());

        // Add random nodes            

        ArrayList<Node> newNodes = new ArrayList<Node>();
        
        for(int i = 1; i < graph.nodes.size(); i++) {
        	newNodes.add(graph.nodes.get(i));
        }
        
        // Shuffle nodes
        Collections.shuffle(newNodes, new Random());    
        
        // Add nodes to path
        for(Node node : newNodes){
            path.add(node.getIndex());
        }

        // Add starting node again
        path.add(graph.startNode.getIndex());

        // Calculate cost
        calculateCost();
    }

    
    void calculateCost(){this.cost = graph.getCost(path);}

    
    void deviatePath(int generationNumber){
        
        // Decrease the deviation swap number as the generation number increases
        int swapNumber = Math.max((int)path.size() / generationNumber, 1);

        for(int i=0; i < swapNumber; i++){
            // Select two random indices to swap, cannot be 0 or last index
            int index1 = Genetic.getRandom(1, path.size()-2);
            int index2 = Genetic.getRandom(1, path.size()-2);

            Collections.swap(path, index1, index2);
        }
    }
    
    void generateIndividualFrom(Individual best, int generationNumber){
        setGraph(best.graph);
        this.path = best.path;
        this.deviatePath(generationNumber);
        this.calculateCost();
    }
    
    void printIndividual(){
        System.out.println("Evolutionary Algorithm Best Individual: ");
        
        for(int i=0; i < path.size(); i++){
            System.out.print(graph.nodes.get(path.get(i)).getIndex());
            if(i != path.size()-1){ System.out.print(" -> ");}
        }
        System.out.println("\nCost:\t\t" + cost); 
    }

    void printPath(){

        for(int i=0; i < path.size(); i++){
            System.out.println(graph.nodes.get(path.get(i)).name);
            if(i != path.size()-1){System.out.print(" ");}
        }
        System.out.println("\tCost: " + cost); 
    }
    
}





class population{

    int generationNumber = 1;
    int sameBestIndividual = 0;
    final int POPULATION_SIZE = 10;
    final int terminationThreshold = 20;
    Graph graph;
    ArrayList<Individual> individuals = new ArrayList<Individual>();
    Individual bestIndividual = new Individual();

    population(Graph graph){
        this.graph = graph;

        for(int i=0; i < POPULATION_SIZE; i++){
            Individual newIndividual = new Individual();
            newIndividual.setGraph(graph);
            newIndividual.generateRandomIndividual();
            individuals.add(newIndividual);
        }

        sortIndividuals();
        bestIndividual = individuals.get(0);
    }

    void sortIndividuals(){
        Collections.sort(individuals, new IndividualComparator());
    }

    
    
    
    
    void nextGeneration(){
        
        // Generate new individual and add to population
        for(int i=0; i < POPULATION_SIZE; i++){
            Individual newInd = new Individual();
            newInd.generateIndividualFrom(individuals.get(0), generationNumber);
            individuals.add(newInd);
        }

        // Sort individuals
        sortIndividuals();

        ArrayList newIndividuals = new ArrayList<Individual>();
        
        for(int i = 0; i < POPULATION_SIZE; i++) {
        	newIndividuals.add(individuals.get(i));
        }
        
        individuals = newIndividuals;
        
        generationNumber++;
    }

    void nextGeneration(int iteration){
        for(int i=0; i < iteration; i++){
            nextGeneration();
            if(bestIndividual != null){
                if(individuals.get(0).cost == bestIndividual.cost){sameBestIndividual++;}
                else{sameBestIndividual = 0;}
            }
            
            if(sameBestIndividual >= terminationThreshold){
                System.out.println("Terminated due to no improvement for" + terminationThreshold + "generations.");
                break;
            }
            bestIndividual = individuals.get(0);
        }   
    }
};


