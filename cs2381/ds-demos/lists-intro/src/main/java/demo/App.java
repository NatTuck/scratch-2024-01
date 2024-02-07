package demo;

import java.util.List;
import java.util.ArrayList;

// Python:
//  - Default sequence type is list
//  - You generally make a list with the [] literal syntax.

// Java
//  - The default sequence type is List
//  - List in Java is an interface

public class App {
    public static void main(String[] args) {
        var xs = List.of(1,2,3,4);

        // Read-only methods of List
        xs.isEmpty();   // false
        xs.get(1);      // 2   (indexes start from 0)
        xs.size();      // 4   (gives # of items in list)       

        for (var xx : xs) {
            // do something with xx
        }

        // "Standard" List implementatin is ArrayList
        List<Integer> ys = new ArrayList<Integer>();

        // If we're sure it's an ArrayList
        ArrayList<Integer> zs = (ArrayList<Integer>) ys;

        // int is a 32-bit signed integer
        // it takes up 4 bytes in memory

        // Integer is an Object, with one int field.
        // it takes 4 bytes + object overhead (at least 8 bytes)

        // Standard methods to modify a List
        ys.add(1);   // result: [1]
        ys.add(2);   // result: [1, 2]
        ys.add(3);
        ys.add(4);

        // Set an element to a new value
        ys.set(2, 6);  // result: [1, 2, 6, 4]

        var item = new OneThing<Integer>();
        item.xx = 5;

        var item2 = new OneThing<String>();
        item2.xx = "Hello";
    }

    // Design a method that takes a list of
    // integers and returns a new list with 1
    // added to each element of the input.

    /**
     * Add one to each item, creating new list.
     * 
     * @param  xs  Input list
     * @return     Output list
     */
    static List<Integer> add1ToAll(List<Integer> xs) {
        var ys = new ArrayList<Integer>();  // 1
        for (var xx : xs) {          // 1
            ys.add(xx + 1);          // 2
        }
        return ys; // 1
    }
    // For an input of size 1, 5 ops
    // For an input of size n, 2 + 3*n ops.
    // So that's O(n)

    // Design a method that takes a list of
    // integers and adds 1 to each in place.

    /**
     * Add 1 to each item in list in place.
     *
     * @param  xs   Input list
     */
    static void add1ToEach(List<Integer> xs) {
        for (int jj = 0; jj < xs.size(); ++jj) {
            xs.set(jj, xs.get(jj) + 1);
        }

        int ii = 0;
        while (ii < xs.size()) {
            xs.set(ii, xs.get(ii) + 1);
            ++ii; // ii += 1;  // ii = ii + 1;
        }

        //System.out.println("" + ii);
        //System.out.println("" + jj);
    }

    // For an input of size n, this takes 1 operation.
    //    ops(n) = 1
    //    method1 is O(1)
    static int method1(List<Integer> xs) {
        return xs.get(0);  // One operation
    }
}

class OneThing<T> {
    T xx;
}

class Pair<T, U> {
    T first;
    U second;
}


// Idea: Asymptotic Complexity
//  - Which piece of code (method) is faster?
//  - How does the amount of time this code takes to
//    run vary as the size of the input changes? 

// O (Big-O) notation:
//  - Provides an upper bound on the complexity (number of
//    operations) of a method based on the size of the input.
//  - Ignore constant factors.
//    (1 operation = 100 operations) is O(1).
