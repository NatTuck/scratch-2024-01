# Lab 11: Priority Queue + Graph

In this lab, you will:

 - Complete and use MinHeap-based Priority Queue
 - Complete a graph traversal algorithm
 - Mess with a novel GUI library

For this assignment the App#main method is used to start the GUI, and
should be left intact in your solution. Keep in mind that you can
temporarily rename it to create a test main method as long as you switch
back before packing up your solution.

## Graph UI Usage

 - Start the UI with: ```mvn compile exec:java -q```
 - The console output matters, so make sure you're running it in some
   way that lets you see that output.
 - When you first click a city, that will set the pathfinding source.
 - When you click a second city, that will set the destination and
   run pathfinding.
 - If you click the background, that will clear the source.
 - This is worth playing with a bit while watching the console output.
 

## Problems

**Problem 1. MinHeap**

Complete the code in MinHeap.java to implement a min heap / priority queue.

https://en.wikipedia.org/wiki/Binary_heap


**Problem 2. Euclidian Distance**

Complete the ```dist``` method in RoadMap.java to calculate the
Euclidian distance between two cities on the map given the names of the
cities.

https://en.wikipedia.org/wiki/Euclidean_distance


**Problem 3. Dijkstra's Algorithm**

Complete the code in FindPath.java to find the shortest path
between two cities on the map.

https://en.wikipedia.org/wiki/Dijkstra%27s_algorithm


**Problem 4: Highlight Shortest Path**

Update the application to highlight the most recently found path in
the GUI window, e.g. by making the edge lines along the path red.

There are no tests for this problem - functionality will be graded
manually.

https://jgraph.github.io/mxgraph/docs/manual_javavis.html

https://jgraph.github.io/mxgraph/java/docs/index.html
