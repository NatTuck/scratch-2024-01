package demo;

import java.util.function.BiPredicate;

public class App {

    public static void main1(String[] args) {
        var xs = new IntCell(-4, new IntCell(-2, new IntCell(-113, new IntEmpty())));
        System.out.println("size = " + xs.size());

        for (IntList curr = xs; !curr.isEmpty(); curr = curr.rest()) {
            System.out.println(curr.first());
        }
        
        System.out.println("max = " + xs.max());
    }

    public static void main2(String[] args) {
        var p1 = new IntPair(5, 3);
        var p2 = new Pair<Integer, Integer>(5, 3);
        var p3 = new StringPair("hi", "there");
        var p4 = new Pair<>(5, "hi");
        System.out.println("" + p1 + " " + p2 + " " + p3);
    }
    
    public static void main(String[] args) {
        var xs = ConsList.of(2, 4, 6, 8, 10, 12);
        System.out.println(xs.get(0));
        System.out.println(xs.get(4));
        System.out.println(xs.get(10));
    }
}

// ConsList is from LISP terminology.
// Linked lists were built out of pairs,
// pairs were constructed with the CONS function.
// So pairs got called "cons cells".

interface ConsList<T> {
    @SafeVarargs
    public static <T> ConsList<T> of(T... args) {
        ConsList<T> ys = new ConsEmpty<T>();
        for (int ii = args.length - 1; ii >= 0; --ii) {
            ys = new ConsCell<T>(args[ii], ys);
        }
        return ys;
    }

    boolean isEmpty();
    T first();
    ConsList<T> rest();
    int size();

    // Get the iith element, first index is zero.
    T get(int ii);

    // Examples:
    //   xs = List.of(10, 20, 30);
    //   xs.get(0) -> 10
    //   xs.get(2) -> 30

    T maxBy(BiPredicate<T, T> cmp);

    // Examples:
    //   xs = List.of("one", "two", "three", "four");
    //   xs.maxBy((xx) -> xx.length()) -> "three"
    //   xs.maxBy((xx) -> charAt(0)) -> "two" (maybe "three")
}

record ConsCell<T>(T first, ConsList<T> rest) implements ConsList<T> {
    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 1 + rest.size();
    }

    @Override
    public T get(int ii) {
        if (ii == 0) {
            return first;
        }
        else {
            return rest.get(ii - 1);
        }
    }
}

record ConsEmpty<T>() implements ConsList<T> {
    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public T first() {
        throw new RuntimeException("empty list");
    }

    @Override
    public ConsList<T> rest() {
        throw new RuntimeException("empty list");
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public T get(int ii) {
        throw new RuntimeException("index out of bounds");
    }
}

record IntPair(int left, int right) {

}


record StringPair(String left, String right) {

}

record Pair<L, R>(L left, R right) {

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
        /*
        if (rest.isEmpty()) {
            return first();
        }
        */
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
        //throw new RuntimeException("empty list");
        return Integer.MIN_VALUE;
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

