package demo;

// - Data Structures 
// - Intermediate Programming in Java
// - Previously: Python

// Java vs Python:
// - Java: Curly braces and semicolons
// - Python: "Incorrect indentation" errors.

// Data in Python vs Java
// - Python: int, float, str, boolean,
//     list, dict, set
// - Java: int, double, String, boolean, 
//     ArrayList, HashMap, HashSet

// Java "List" is an interface.

// Language type sytems are different:
// - Python has "dynamic" types.
// - Java has "static" types.

// In java:
//  - code goes in methods
//  - methods go in classes
//  - classes go in packages

// Design recipie for a static method:
//  - Javadoc
//  - Method stub
//  - Tests
//  - Standard Pattern
//    - Based on our types, we can figure out
//      what the body probably looks like.
//  - Body


// Lists:
//  - ArrayList
//    - arrays - a fixed size collection of
//               objects of some single type
//    - ArrayList needs a way to efficiently grow
//      - Allocate a new backing array
//      - Doubling size of new array allows Amortized O(1)
//        add method
//  - ConsList (or an immutable Singly Linked List)
//    - Recursive data structure

// Stacks and Queues
//  - Traditional topics for a data structures course.
//  - You've heard of them, great.

// Threads
//  - Data races
//  - Locks ("mutexes")
//  - Two locks? Deadlock

// Sets
//  - Mathematical objects with standard operations
//  - HashSet, TreeSet


import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        ConsList1 xs = new ConsList1(1, new ConsList1(2, new ConsList1(3, null)));
        int yy = sum2(xs);
        System.out.println(yy);
    }

    static int sum2(ConsList1 xs) {
        if (xs == null) {
            return 0;
        }
        else {
            return xs.first() + sum2(xs.rest());
        }
    }

    static int sum1(Integer[] xs) {
        int yy = 0;
        for (var x : xs) {
            // the thing specific to sum is this
            // one line:
            yy += x;
        }
        return yy;
    }

    // Write a static method that triples
    // an integer.

    /**
     * Triple an integer.
     * 
     * @param  n
     * @return    The result of tripling. 
     */
    static int triple(int n) {
        return n * 3;
    }

    public static void main2(String[] args) {
        System.out.println("Hello");

        var db = new Doubler(7);
        System.out.println(db.doub());
        
        var db1 = new Doubler(9);
        System.out.println(db1.doub());
        
        System.out.println(db.doub());
    }

    public static void main1(String[] args) {
        List<Object> xs = List.of(1, 2, 3, "squid");
        List<Number> ys = List.of(1, 2, 3.4);
        System.out.println(xs);
    }
}

class Doubler {
    int value;
    

    Doubler(int value) {
        this.value = value;
    }
    
    // Write a static method returns our
    // value mutliplied by some other integer.

    /**
     * Return value multiplied by int.
     * 
     * @param  x  Other integer
     * @return    Result
     */
    int mult(int x) {
        return x * value;
    }

    int doub() {
        return 2 * value;
    }
}

// Empty list is represented by null 
record ConsList1(int first, ConsList1 rest) {

}
