package application;

public class Main {

	public static void main(String[] args) {
				
	Graph graph = new Graph(Instances.adjacencyMatrix5);
	
	// START GENETIC
	long startTime = System.nanoTime();
	population pop = new population(graph);
	pop.nextGeneration(1);
	pop.individuals.get(0).printIndividual();
	long endTime = System.nanoTime();
	long runTimeMicro = (endTime-startTime)/1000;
	System.out.print("Runtime:\t" + runTimeMicro + " MicroSeconds \n \n");
	// END GENETIC
	
	// START HELD-KARPs
	System.out.println("Held Karp Algorithm");
	 startTime = System.nanoTime();
    HeldKarp heldKarp = new HeldKarp();
    int minCost = heldKarp.solveHeldKarp(Instances.adjacencyMatrix5);
    endTime = System.nanoTime();
    System.out.println("Minimum cost of visiting all nodes: " + minCost);
   

    // Calculate the runtime in microseconds
    long runtimeNano = endTime - startTime;
    long runtimeMicro = runtimeNano / 1000; // Convert nanoseconds to microseconds

    System.out.println("Runtime: " + runtimeMicro + " microseconds");
	// END HELD-KARP
	
	}

}
