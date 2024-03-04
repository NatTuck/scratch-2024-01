package demo;

//import java.util.ArrayDeque;

public class App {
    public static void main(String[] args) {
        var queue = new DoubleList<Integer>();
        for (int ii = 0; ii < 5; ++ii) {
            queue.push(ii);
        }
       
        for (int ii = 0; ii < 3; ++ii) {
            System.out.println(queue.shift());
        }

        for (int ii = 0; ii < 5; ++ii) {
            queue.push(ii);
        }

        for (int ii = 0; ii < 7; ++ii) {
            System.out.println(queue.shift());
        }


    }
}

interface Stack<T> {
    /**
     * Add item to top of stack.
     */
    void push(T item);

    /**
     * Remove item from top of stack
     * and return it.
     */
    T pop();

    /**
     * Check if the stack is empty.
     */
    boolean isEmpty();

    // Optional methods start here.

    /**
     * Return top item of stack without removing it.
     */
    T peek();

    /**
     * How many items in stack?
     */
    int size();   
}

interface Queue<T> {
    /**
     * Get first item and remove.
     */
    T shift();

    /**
     * Add item to back ofqueue.
     */
    void push(T item);

    /**
     * Check if the queue is empty.
     */
    boolean isEmpty();

    // optional operations 

    /**
     * Look at next item without removing it.
     */
    T first();

    /**
     * How many items in stack?
     */
    int size(); 
}

interface Deque<T> {
    void push(T item);
    T pop();
    T shift();
    void unshift(T item);

    boolean isEmpty();

    T peek();
    T first();
    int size();   
}