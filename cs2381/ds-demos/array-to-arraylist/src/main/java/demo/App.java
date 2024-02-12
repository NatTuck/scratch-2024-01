package demo;

import java.util.Iterator;
import java.util.function.Function; 

//import java.util.List;

/*
 * Last time:
 *  - List
 *    - List.of()
 *  - ArrayList
 * 
 * Today:
 *  - arrays
 *  - Data types in Java:
 *    - primitive types: int, boolean
 *      - Each primitive type has an associated class type 
 *    - object, class instance: String, Bird
 *    - arrays 
 * 
 *    Arrays:
 *     - Collection of 0 or more items of a single type.
 *     - Each array has a fixed length, specified when
 *       it's created.
 *     - Arrays have a length field.
 */

public class App {

    public static void main1(String[] args) {
        int[] ys = {2, 4, 6, 8};

        for (int ii = 0; ii < ys.length; ++ii) {
            ys[ii] += 1;
            System.out.println(ys[ii]);
        }

        for (var yy : ys) {
            System.out.println(yy);
        }
    }
    
    public static void main2(String[] args) {
        var xs = new ArrayWrapper<Integer>();
        var ys = new ArrayList<Integer>();

        for (int ii = 0; ii < 1000; ++ii) {
            xs.add(ii);
            ys.add(ii);
        }

        xs.printOps();
        ys.printOps();
       
        /*
        for (int ii = 0; ii < xs.size(); ++ii) {
            System.out.println(xs.get(ii));
        }
        */
    }

    /*
    public static void main3(String[] args) {
        List<Integer> xs = List.of(1, 2, 3, 4);
        int[] ys = {1, 2, 3, 4};

        for (var xx : ys) {
            System.out.println(xx);
        }
    }
    */

    public static void main(String[] args) {
        ArrayList<String> xs = new ArrayList<>();
        xs.add("cow");
        xs.add("bear");

        var ys = map((xx) -> xx + "s", xs);
        for (int ii = 0; ii < ys.size(); ++ii) {
            System.out.println(ys.get(ii));
        }

        ArrayList<Integer> zs = new ArrayList<>();
        zs.add(4);
        zs.add(4);
        zs.add(7);
        zs.add(7);

        for (var zz : map((xx) -> "#" + xx, zs) ) {
            System.out.println(zz);
        }
    }

    // Design a static method that takes a list of strings
    // as its argument and pluralizes each one by sticking
    // "s" on the end, returning a new list.

    // Pluralize each string in list.
    static ArrayList<String> pluralizeAll(ArrayList<String> xs) {
        var ys = new ArrayList<String>();
        for (var xx : xs) {
        //for (int ii = 0; ii < xs.size(); ++ii) {
        //    var xx = xs.get(ii);
            ys.add(xx + "s");
        }
        return ys;
    }

    // Design a method that takes a list of integers
    // and returns a new list with 1 added to each
    // integer in the input list.

    // Example: [1,2,4] -> [2,3,5]

    // Add one to each integer in list.
    static ArrayList<Integer> listPlusPlus(ArrayList<Integer> xs) {
        var ys = new ArrayList<Integer>();
        for (var xx : xs) {
            ys.add(xx + 1);
        }
        return ys;
    }

    static <T, U> ArrayList<U> map(Function<T, U> op, ArrayList<T> xs) {
        var ys = new ArrayList<U>();
        for (var xx : xs) {
            ys.add(op.apply(xx));    
        }
        return ys;
    }
}

class ArrayWrapper<T> {
    private T[] data;
    private int ops;

    @SuppressWarnings("unchecked")
    ArrayWrapper() {
        this.data = (T[]) new Object[0];
        this.ops = 0;
    }

    @SuppressWarnings("unchecked")
    void add(T vv) {
        int ii = this.size();

        if (ii >= this.capacity()) {
            //System.out.println("Index " + ii + "; time to grow.");
            var data1 = (T[]) new Object[this.capacity() + 1];
            for (int jj = 0; jj < this.size(); ++jj) {
                data1[jj] = this.data[jj];
                ops += 1;
            }
            this.data = data1;
        }

        data[ii] = vv;
        ops += 1;
    }

    void set(int ii, T vv) {
        this.data[ii] = vv;
    }

    T get(int ii) {
        return data[ii];
    }

    int size() {
        return this.data.length;
    }

    int capacity() {
        return this.data.length;
    }

    void printOps() {
        System.out.println("ArrayWrapper did " + ops + " array writes.");
    }
}

class ArrayList<T> implements Iterable<T> {
    private T[] data;
    private int size;
    int ops;

    @SuppressWarnings("unchecked")
    ArrayList() {
        this.data = (T[]) new Object[2];
        this.size = 0;
        this.ops = 0;
    }

    // Complexity is O(n)
    void add(T vv) {
        int ii = this.size();
        if (ii >= this.capacity()) {
            //System.out.println("Index " + ii + "; time to grow.");
            grow();
        }

        this.data[ii] = vv;
        ops += 1;
        this.size += 1;
    }


    @SuppressWarnings("unchecked")
    void grow() {
        var data1 = (T[]) new Object[this.capacity() * 2];
        for (int jj = 0; jj < this.size(); ++jj) {
            data1[jj] = this.data[jj];
            ops += 1;
        }
        this.data = data1;
    }

    void set(int ii, T vv) {
        this.data[ii] = vv;
    }

    T get(int ii) {
        return data[ii];
    }

    int size() {
        return size;
    }

    int capacity() {
        return this.data.length;
    }
    
    void printOps() {
        System.out.println("ArrayList did " + ops + " array writes.");
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayListIterator<T>(this); 
    }
}

class ArrayListIterator<T> implements Iterator<T> {
    //for (int ii = 0; ii < xs.size(); ++ii) {

    ArrayList<T> xs;
    int ii; 

    ArrayListIterator(ArrayList<T> xs) {
        this.xs = xs;
        this.ii = 0;
    }

    @Override
    public boolean hasNext() {
        return ii < xs.size();
    }

    @Override
    public T next() {
        return xs.get(ii++);
    }
}

