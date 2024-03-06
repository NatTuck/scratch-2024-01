package demo;

public class App {
    static Account alice;
    static Account bob;

    public static void main(String[] args) throws InterruptedException {
        alice = new Account("Alice", 10);
        bob = new Account("Bob", 10);

        var ta = new ThreadA();
        ta.start();

        var tb = new ThreadB();
        tb.start();

        ta.join();
        tb.join();

        System.out.println("All done");
    }
}

class Account {
    String name;
    int balance;

    Account(String name, int b0) {
        this.name = name;
        this.balance = b0;
    }

    synchronized void transferTo(Account that) throws Exception {
        if (balance <= 0) {
            return;
        }

        System.out.println("Transferring $1 from " + name +
                           " to " + that.name);

        this.balance -= 1;

        Thread.sleep(1000);

        synchronized (that) {
            that.balance += 1;
        }
    }
}

class ThreadA extends Thread {
    @Override
    public void run() {
        try {
            App.alice.transferTo(App.bob);
        }
        catch (Exception ee) {
            // pass
        }
    }
}

class ThreadB extends Thread {
    @Override
    public void run() {
        try {
            App.bob.transferTo(App.alice);
        }
        catch (Exception ee) {
            // pass
        }
    }
}

