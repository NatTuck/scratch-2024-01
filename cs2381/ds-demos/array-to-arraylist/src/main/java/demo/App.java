package demo;

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
    
    public static void main(String[] args) {
        var xs = new ArrayWrapper<Integer>();

        // Insert n items into ArrayWrapper
        // complexity of loop is O(n^2)
        for (int ii = 0; ii < 10; ++ii) {
            xs.add(ii);
        }
        
        // Insert n items into ArrayWrapper
        // complexity of loop is O(n^2)
        /*
        for (int ii = 0; ii < 10; ++ii) {
            xs.add_double_capacity(ii);   // Worst case: O(n)
                         // Across many calls, average O(1)
                         // Amortized O(1)
        }
        */
        
        for (int ii = 0; ii < xs.size(); ++ii) {
            System.out.println(xs.get(ii));
        }
    }
}

class ArrayWrapper<T> {
    private T[] data;
    private int size;

    @SuppressWarnings("unchecked")
    ArrayWrapper() {
        this.data = (T[]) new Object[2];
        this.size = 0;
    }

    // Complexity is O(n)
    @SuppressWarnings("unchecked")
    void add(T vv) {
        int ii = this.size();
        // Bug: this should only happen when we
        // run out of capacity.
        var data1 = (T[]) new Object[this.capacity() * 2];
        for (int jj = 0; jj < this.size(); ++jj) {
            data1[jj] = this.data[jj];
        }
        data1[ii] = vv;
        this.size += 1;
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
}


