

# Notes

New topic: Sets

Mathematical object:

 - Collection of things
 - Non-ordered
 - Doesn't handle duplicates

# Examples

```
    A = {2, 3, 5}
    B = {3, 6, 9}

    C = A union B = {2, 3, 5, 6, 9}
    D = A intersect B = {3}
```

# Standard set methods

Math:

 - contains?(item) - Does the set contain the item
 - union(set) - All items in either set
 - intersection(set) - All items in both sets
 - setA.subset?(setB) - Does setA contain all items in setB?
 - setA.superset?(setB) - Does setB contain all items in setA?

Nessisary for code:
 
 - add(item) - Add an item to the set
 - remove(item) - Remove
 - size - How many items in set?

Open question: Mutable or immutable

 - Mutable is more natural in Java
 - Immutable makes the math clearer

How to implement?

 - Store items in list
 - e.g. ConsList, ArrayList




