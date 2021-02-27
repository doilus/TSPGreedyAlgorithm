# TSPGreedyAlgorithm
An example algorithm to determine the shortest path.

## General info

The subject of the project is to implement a heuristic algorithm to calculate the shortest distance conntecting all the cities. 
Project is a *traveling salesman problem*. To solve the trouble I used greedy algorithm. 

It was implemented using **Java**. 

Data is from [Luxembourg](http://www.math.uwaterloo.ca/tsp/world/lutour.html).

[Data Source](http://www.math.uwaterloo.ca/tsp/world/countries.html)

## Method

**Step 1:** Randomly pick one city.  
**Step 2:** Generate all (n-!)! city permutations.  
**Step 3:** Calculate the cost of each permutation and continue the path with the lowest cost. Keep a map with unvisited cities.  
**Step 4:** After reaching the last city, return the lowest cost of all. 
