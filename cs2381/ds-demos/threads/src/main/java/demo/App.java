package demo;

public class App {
    final static long TOP = 1000 * 1000 * 1000;
    static long sum;

    public static void main(String[] args) {
    }
}

// Concurrency: Doing more than one thing at the same time.

/*
 * Web requests:
 * 
 *  - Alice requests the server sends a 1GB movie.
 *  - 1 ms later: Bob requests the server send a 1kB HTML file.
 * 
 * Web server should be concurrent. It should do both
 * things logically at the same time.
 *
 * When things are physically happening at the same time
 * using separate hardware resources (e.g. cpu cores), that's
 * parallel processing. This enables parallel speedup.
 * 
 * Solutions: 
 * 
 *  - Multithreading
 *    - One process (running instance of a program) contains 
 *      multiple "threads" of execution.
 *  - Multiple Processes
 *    - Run the same program multiple times.
 *  - Async or Green Thread runtime
 *    - Have the programming language simulate concurrent
 *      execution with sequential execution 
 */




