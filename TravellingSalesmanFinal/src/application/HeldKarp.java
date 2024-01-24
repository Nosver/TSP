package application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringJoiner;

public class HeldKarp {

	private static int INF = 100000000;


	public int solveHeldKarp(ArrayList<ArrayList<Integer>> adjacencyMatrix) {
		
		ArrayList<Set<Integer>> all = createComb(adjacencyMatrix.size() - 1);

		Map<TSPSubproblem, Integer> parent = new HashMap<>();
		Map<TSPSubproblem, Integer> ht = new HashMap<>();


		for (Set<Integer> set : all) {
			for (int current = 1; current < adjacencyMatrix.size(); current++) {
				int minprevCost = 0;
				int minCost = INF;
				if (set.contains(current)) {
					continue;
				}
				
				TSPSubproblem index = TSPSubproblem.generateIndex(current, set);
				
				Set<Integer> copySet = new HashSet<>(set);
				for (int prev : set) {
					int cost = adjacencyMatrix.get(prev).get(current) + calcCost(copySet, prev, ht);
					if (cost < minCost) {
						minCost = cost;
						minprevCost = prev;
					}
				}
				if (set.size() == 0) { // empty set
					minCost = adjacencyMatrix.get(0).get(current);
				}
				ht.put(index, minCost);
				parent.put(index, minprevCost);
			}
		}

		Set<Integer> set = new HashSet<>();
		for (int i = 1; i < adjacencyMatrix.size(); i++) {
			set.add(i);
		}
		int min = Integer.MAX_VALUE;
		int prev = -1;
		Set<Integer> copySet = new HashSet<>(set);
		for (int k : set) {
			int cost = adjacencyMatrix.get(k).get(0) + calcCost(copySet, k, ht);
			if (cost < min) {
				min = cost;
				prev = k;
			}
		}

		parent.put(TSPSubproblem.generateIndex(0, set), prev);
		int totalVertices= adjacencyMatrix.size();
		printRoute(parent, totalVertices);
		return min;
	}

	private void printRoute(Map<TSPSubproblem, Integer> parent, int totalVertices) {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < totalVertices; i++) {
			set.add(i);
		}
		Integer start = 0;
		Deque<Integer> deque = new LinkedList<>();
		boolean stop =false;
		while (!stop) {
			deque.push(start);
			set.remove(start);
			start = parent.get(TSPSubproblem.generateIndex(start, set));
			if (start == null) {
				stop=true;
			}
		}
		String result = "";
        for (Integer value : deque) {
            result += value + "-";
        }
        if (!result.isEmpty() && result.endsWith("-")) {
            result = result.substring(0, result.length() - 1);
        }        

        System.out.print("Route : ");
        System.out.println(result);
		
		
	}

	private int calcCost(Set<Integer> set, int prev, Map<TSPSubproblem, Integer> ht) {
		set.remove(prev);
		TSPSubproblem index = TSPSubproblem.generateIndex(prev, set);
		int cost = ht.get(index);
		set.add(prev);
		return cost;
	}
	private static class SizeComparator implements Comparator<Set<Integer>> {
		@Override
		public int compare(Set<Integer> o1, Set<Integer> o2) {
			return o1.size() - o2.size();
		}
	}

	private ArrayList<Set<Integer>> createComb(int n) {
		int input[] = new int[n];
		for (int i = 0; i < input.length; i++) {
			input[i] = i + 1;
		}
		ArrayList<Set<Integer>> all = new ArrayList<>();
		int len=input.length;
		int res[] = new int[len];
		createComb(input, 0, 0, all, res);
		Collections.sort(all, new SizeComparator());
		return all;
	}

	private void createComb(int input[], int start, int curr, ArrayList<Set<Integer>> all, int res[]) {
		if (curr == input.length) {
			return;
		}
		Set<Integer> set = createSet(res, curr);
		all.add(set);
		for (int i = start; i < input.length; i++) {
			res[curr] = input[i];
			createComb(input, i + 1, curr + 1, all, res);
		}
	}

	private static class TSPSubproblem {
		int current;
		Set<Integer> vertices;

		
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null || getClass() != obj.getClass())
				return false;

			TSPSubproblem index = (TSPSubproblem) obj;

			if (current != index.current)
				return false;
			return !(vertices != null ? !vertices.equals(index.vertices) : index.vertices != null);
		}

		
		public int hashCode() {
			int res = current;
			res = 10 * res + (vertices != null ? vertices.hashCode() : 0);
			return res;
		}

		private static TSPSubproblem generateIndex(int vertex, Set<Integer> vertices) {
			TSPSubproblem i = new TSPSubproblem();
			i.current = vertex;
			i.vertices = vertices;
			return i;
		}
	}
	

	private static Set<Integer> createSet(int input[], int curr) {
		Set<Integer> hashSet = new HashSet<>();
		if (curr == 0) {
			return hashSet;
		}
		
		for (int i = 0; i < curr; i++) {
			hashSet.add(input[i]);
		}
		return hashSet;
	}
}
