package demo;

public class App {

    public static void main(String[] args) {
        var xs = new IntCell(-4, new IntCell(-2, new IntCell(-113, new IntEmpty())));
        System.out.println("size = " + xs.size());

        for (IntList curr = xs; !curr.isEmpty(); curr = curr.rest()) {
            System.out.println(curr.first());
        }
        
        System.out.println("max = " + xs.max());
    }
}

interface IntList {
    boolean isEmpty();
    int first();
    IntList rest();
    int size();

    int sum();
    int max();
}

record IntCell(int first, IntList rest) implements IntList {

    @Override
    public int size() {
        return 1 + rest.size();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int sum() {
        return first() + rest.sum();
    }

    @Override
    public int max() {
        if (rest.max() > first()) {
            return rest.max();
        }
        else {
            return first();
        }
    }

}

record IntEmpty() implements IntList {

    @Override
    public int size() {
        return 0; 
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public int first() {
        throw new RuntimeException("empty list");
    }

    @Override
    public IntList rest() {
        throw new RuntimeException("empty list");
    }

    @Override
    public int sum() {
        return 0;
    }

    @Override
    public int max() {
        return -1;
    }
}

/*
record IntList(int first, IntList rest) {
    int size() {
        if (rest == null) {
            return 1;
        }
        else {
            return 1 + rest.size();
        }
    }
}
*/

