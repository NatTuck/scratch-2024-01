# Notes on graph search

## Depth-first search

 - Try the first neighbor, and it's first neighbor, recursively.
 - Problem: A cycle will cycle forever
 - Breadcrumbs?
 - Need backtracking
 - Doesn't nessisarily find best path


## Iterative Breadth First Search

 - Starting with max-depth 1
 - Find all paths from the starting point to anywhere
   with length no greater than max-depth
 - This avoids infinite loops, but is computationally expensive

## Lists at distance

 - Generate a list of all cities one steps away.
 - If that didn't get us there, generate a list of all cities
   one step away from each of those.
 - This grows really fast.
 - Adding breadcrumbs helps.

## Depth-first search, going in the right direction first (A* Search)

 - If there's nothing tricky, this takes O(n) time in the
   length of the path.


## Complication: Edge Weights

 - Rather than just treating all edges as having a cost of 1,
   we can specify alternate cost (e.g. distance in miles)


## Single Source Shortest Path

Dijkstra's Algorithm:

 - For each vertex (node) in the graph, we want to track
   the following in a map:
   - Estimated distance from starting node.
     - Initially zero for the starting node
     - Initially +inf for other nodes.
   - Best previous node
     - Initially null
   - Done?
     - boolean, initially false
 - Keep a priority queue of nodes to explore
 - For current node
   - Check each neighbor node that isn't done for the following:
     - If path through current node to that neighbor is 
       better, update the map and add that node to the queue
   - Once all neighbors checked, this node is done.

A* Search:

 - Take into account the coordinates of the verticies and
   the distance to the destination in the priority queue.
 - Specifically, rather than using distance from source as 
   the score, we use:
     - Distance from source + estimated distance to goal
 - The estimated distance to goal is called the heuristic.
 - We want the heuristic to underestimate the distance.
 - Euclidian distance is pretty common.
 - Fast, unless you're exploring a maze. Then still as fast
   as you can really hope for.


