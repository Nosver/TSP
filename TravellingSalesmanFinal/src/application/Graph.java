package application;



import java.util.ArrayList;
import java.util.Vector;
import java.util.stream.IntStream;


class Node{
    ArrayList< Pair<Node,Integer> > neighbors = new ArrayList<Pair<Node,Integer>>(); // Check indices
    Boolean isVisited = false;
    char name;
    Node(int index){name = (char)(index + 'A');};
    int getIndex(){return name - 'A';};
};



class Graph{

    ArrayList<ArrayList<Integer>> adjancencyMatrix;
    ArrayList<Node> nodes = new ArrayList<Node>();
    ArrayList<Integer> nodeIndices = new ArrayList<Integer>();
    Node startNode;

    Integer INF = 1000000;

    ArrayList<Pair<ArrayList<Node>, Integer>> solutions;

    Graph(ArrayList<ArrayList<Integer>> adjacencyMat ){
        
        if(adjacencyMat.size() < 2){
            System.out.println("Error: The adjacency matrix must be at least 2x2");
            System.exit(1);
        }

        adjancencyMatrix = adjacencyMat;

        for(int i = 0; i < adjacencyMat.size(); i++){
            Node newNode = new Node(i);
            nodes.add(newNode);
        }

        for(int i = 0; i < adjacencyMat.size(); i++){
            for(int j = 0; j < adjacencyMat.get(i).size(); j++){
                if(adjacencyMat.get(i).get(j) != 0){
                    nodes.get(i).neighbors.add(new Pair(nodes.get(j), adjacencyMat.get(i).get(j))); 
                }
            }
        }

        startNode = nodes.get(0);

        for(int i = 0; i < nodes.size(); i++){
            nodeIndices.add(i);
        }

    }

    void printGraph(){

        // Print Adjacency Matrix
        System.out.println("Adjacency Matrix");
        for(int i = 0; i < adjancencyMatrix.size(); i++){
            for(int j = 0; j < adjancencyMatrix.get(i).size(); j++){
                if(adjancencyMatrix.get(i).get(j) == INF){
                    System.out.println("INF\t");
                }else{
                    System.out.println(adjancencyMatrix.get(i).get(j));
                }
            }
            System.out.println("\t");
        }
    }


    
    int getCost(int A, int B){return adjancencyMatrix.get(A).get(B);}

    int getCost(ArrayList<Integer> path) {
        // 0 -> 1 -> 2 -> 0 input
        Integer cost = 0;
        for(Integer i=0; i < path.size()-1; i++){
            cost += getCost(path.get(i), path.get(i+1));
        }
        return cost;
    }
    
    

}