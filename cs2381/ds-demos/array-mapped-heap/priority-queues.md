
# Priority Queues

 - Sequence structure
 - Each item has a priority
 - Highest priority items come out first
 - Generally, items with tied priorities are FIFO.

## Use Cases

 - Emergency room triage
 - A regular line is a queue, a line at disney world
   is a priority queue
 - Any sort of "scheduling" problem.
   - Scheduling processes in operating systems
   - etc
 - Some algorithms assume a priority queue

## How to build one

 - With discrete priorities:
   - An array of queues
 - With continuous priorities:
   - Keep the queue sorted, insert in sorted order


## Implementions

 - ConsList, insert in sorted order
   - Insert is O(n)
   - Take next is O(1) 
   - Insert + Take is O(n)
 - Binary Tree
   - Insert is O(log n)
   - Take next O(log n)
   - Insert + Take is O(log n)
 - Heap
   - Binary tree
   - Heap property: Parent higher priority than children
   - Insert is O(log n)
   - Take next is O(log n)
 
## Array mapped heap

 - Store the items in an array
 - xs[0] is root
 - For index ii, children are (2*ii+1, 2*ii+2)
   - Parent is floor((ii-1)/2)
 - Tree is guaranteed to be complete (fill each
   layer before starting next)

10, 20, 30, 5, 10, 15

    0   1   2   3   4   5
 [  5,  10, 15, 20, 10, 30 ]
    
    0   1   2   3   4  
 [ 10,  10, 15, 20, 30 ]












