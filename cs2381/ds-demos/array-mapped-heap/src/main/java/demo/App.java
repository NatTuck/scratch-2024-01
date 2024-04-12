package demo;

import java.util.List;

public class App {

    public static void main(String[] args) {
        var xs = List.of(10, 20, 30, 24, 5, 15, 25);
        var ys = List.of("a", "b", "c", "d", "e", "f", "j");

        var qq = new Heap<Integer, String>();
        for (int ii = 0; ii < 7; ++ii) {
            qq.push(xs.get(ii), ys.get(ii));
        }

        while (true) {
            var yy = qq.next();
            if (yy == null) {
                break;
            }
            System.out.println(yy);
        }
    }
}
