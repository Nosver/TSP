# Travelling Salesman Problem Implementation with Java

The Travelling Salesman Problem (TSP) is a classic optimization problem in which the goal is to find the shortest possible route that visits each city exactly once and returns to the original city. It has applications in various fields such as logistics, transportation, and network design.

## Overview

This Java project provides an implementation of the TSP solution using two different approaches:

1. **Held-Karp Algorithm**: Implemented in the `HeldKarp` class, this algorithm utilizes dynamic programming to find the optimal solution for smaller instances of the TSP. It efficiently calculates the shortest route by considering all possible combinations of cities.

2. **Genetic Algorithm**: Implemented in the `Genetic` class, this approach uses evolutionary principles to iteratively improve solutions. It starts with a population of random routes and evolves them over generations, selecting the best individuals for reproduction and introducing variation through mutation operation.

## Project Structure

The project consists of the following Java files:

- **HeldKarp.java**: Contains the implementation of the Held-Karp algorithm for solving the TSP. It utilizes dynamic programming to compute the optimal solution efficiently.
  
- **Genetic.java**: Provides utility methods for generating random numbers. It is used in the genetic algorithm implementation.

- **Individual.java**: Represents an individual solution in the genetic algorithm. It includes methods for generating random individuals, calculating costs, deviating paths, and generating individuals from the best solution.

- **population.java**: Manages a population of individuals in the genetic algorithm. It generates new generations of individuals and tracks the best solution found so far.

## Usage

To use this project:

1. Ensure you have Java installed on your system.
2. Copy the provided Java files into your Java project directory.
3. Initialize the adjacency matrix representing distances between cities.
4. Create a `Graph` object with the initialized adjacency matrix.
5. Create a `population` object with the initialized graph.
6. Call the appropriate methods to run either the Held-Karp algorithm or the genetic algorithm.
7. Access the best individual's path and cost to obtain the optimal solution to the TSP.
