package demo;

public class App {
    final static long TOP = 1000 * 1000 * 1000;
    final static long NPT = 100 * 1000 * 1000;

    static long sum;
    static Object lock = new Object();
    // Lock goes with shared data object, to control
    // concurrent access.

    public static void main(String[] args) throws InterruptedException {
        sum = 0;

        var workers = new Thread[10];

        for (int ww = 0; ww < 10; ++ww) {
            workers[ww] = new Thread(new Worker(ww));
            workers[ww].start();
        }

        for (int ww = 0; ww < 10; ++ww) {
            workers[ww].join();
        }

        System.out.println("Sum = " + sum);

    }

    public static void main1(String[] args) {
        long sum = 0;

        for (long ii = 0; ii < TOP; ++ii) {
            if (ii % 101 == 0) {
                sum += ii;
            }
        }

        System.out.println("sum = " + sum);
    }
}

class Worker implements Runnable {
    int wnum;

    Worker(int wnum) {
        this.wnum = wnum;
    }

    public void run() {
        long i0 = App.NPT * wnum;
        long i1 = i0 + App.NPT;

        long local_sum = 0;

        for (long ii = i0; ii < i1; ++ii) {
            if (ii % 101 == 0) {
                local_sum += ii;
            }
        }

        synchronized (App.lock) {
            App.sum += local_sum;
        }
    }
}

