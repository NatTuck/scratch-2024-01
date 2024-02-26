package hw05;

import java.util.Stack;

public class App {
    public static void main(String[] args) {
        String input = "3 29 14 - *";
        int yy = evalPostfix(input);
        System.out.println(input + " => " + yy);
    }

    static int evalPostfix(String expr) {
        String[] toks = expr.split("\\s");

        var st = new Stack<String>();

        for (var tt : toks) {
            if (isOperator(tt)) {
                var a1 = Integer.parseInt(st.pop());
                var a2 = Integer.parseInt(st.pop());
                st.push("" + applyOp(tt, a1, a2));
            }
            else {
                st.push(tt);
            }
        }

        return Integer.parseInt(st.pop());
    }

    static boolean isOperator(String tt) {
        return tt.equals("-") || tt.equals("*");    
    }

    static int applyOp(String op, int xx, int yy) {
        switch (op) {
            case "-":
                return yy - xx;
            case "*":
                return yy * xx;
        }
        throw new RuntimeException("bokrn");
    }

    public static void main2(String[] args) {
        var xs = ConsList.of(10, 20, 30, 40);

        Stack<Integer> st = new Stack<>();
        for (var xx : xs) {
            st.push(xx);
        }

        while (!st.empty()) {
            System.out.println(st.pop());
        }
    }

    public static void main1(String[] args) {
        var xs = ConsList.of(10, 20, 30, 40, 50, 60, 70, 80);
        for (var xx : xs) {
            System.out.print(" " + xx);
        }
        System.out.println("");

        /*
        var ys = reverse1(xs);
        for (var yy : ys) {
            System.out.print(" " + yy);
        }
        System.out.println("");
        */

        var zs = reverse2(xs);
        for (var yy : zs) {
            System.out.print(" " + yy);
        }
        System.out.println("");
    }
    
    static ConsList<Integer> reverse2(ConsList<Integer> xs) {
        return reverse2(xs, ConsList.empty());
    }

    static ConsList<Integer> reverse2(ConsList<Integer> xs,
            ConsList<Integer> acc) {
        if (xs.isEmpty()) {
            return acc;
        }
        else {
            return reverse2(xs.rest(), ConsList.cons(xs.first(), acc));
        }
    }

    static ConsList<Integer> reverse1(ConsList<Integer> xs) {
        ConsList<Integer> ys = new Empty<Integer>();
        for (var xx : xs) {
            ys = ConsList.cons(xx, ys);
        }
        return ys;
    }

    static ConsList<Integer> addTwoAll(ConsList<Integer> xs) {
        if (xs.isEmpty()) {
            return xs;
        }
        else {
            return ConsList.cons(xs.first() + 2, addTwoAll(xs.rest()));
        }
    }

    static ConsList<Integer> addOneAll(ConsList<Integer> xs) {
        //var ys = ConsList.<Integer>empty();
        ConsList<Integer> ys = new Empty<Integer>();
        for (var xx : xs) {
            ys = ConsList.cons(xx + 1, ys);
        }
        return ys;
    }
}