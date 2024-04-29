package demo;




import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;

public class Exam {
    public static void main(String[] args) {
        var nums = new ArrayList<>(List.of(1,2,2,3,4,5,3));
        System.out.println("\nUnique nums:");
        for (var xx : keepUnique(nums)) {
            System.out.println(xx);
        }
    }

    public static void main2(String[] args) {
        var nums = new ArrayList<>(List.of(1,2,3,4,5));
        var retv = tuna(nums);
        System.out.printf("squid => %d, crab => %d\n", retv.xx(), retv.yy());
    }

    static Pair tuna(ArrayList<Integer> xs) {
        var sq = squid(xs); //   O(n^2)
        var cr = crab(xs);  // + O(n)
                            // = O(n^2)
        return new Pair(sq, cr);
    }

    // n * n = O(n^2)
    static int squid(ArrayList<Integer> xs) {
        if (xs.isEmpty()) {
            return 3;
        }
        var aa = xs.get(0);

        // Remove on ArrayList is O(n), unless
        // we only ever remove the last item.
        xs.remove(0);

        // We call squid n times.
        return aa + squid(xs);
    }

    static int crab(ArrayList<Integer> xs) {
        var yy = 3;
        // O(n)
        // It's just a loop that loops through
        // the n items and does obviously O(1)
        // stuff.
        for (var xx : xs) {
            yy += xx;
        }
        return yy;
    }

    // 12. Write the body of SeaApp#keepUnique. This 
    // should return a new List, not modify the input, 
    // and run in O(n) time in the size of the input.
    static List<Integer> keepUnique(List<Integer> xs) {
        var ys = new HashSet<Integer>();

        for (var xx : xs) {
            ys.add(xx);
        }

        return new ArrayList<>(ys);

        // Build and return a new ArrayList containing
        // each item from xs only once.
        
        // Examples: 
        //  - keepUnique([1,1,1,1,1,2,1,1,2]) -> [1,2]
        //  - keepUnique([1,2,1,5,3,2,3,4,5]) -> [1,2,5,3,4]
     }
}

// xx - 4 bytes
// yy - 4 bytes
//    + 8 bytes
record Pair(int xx, int yy) {

}

// Stack ops:
//  - push (back)
//  - pop (back)
//  - peek (back)
//  - isEmpty (or size)

// Stack vs. Queue
//  - Stack is LIFO vs Queue is FIFO

// Queue
//  - push (back)
//  - pop (front)
//  - peek (front)
//  - isEmpty (or size)



