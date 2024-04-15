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

