package hw05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ConsListShould {

    @Test
    void implement_take() {
        // comment out this
        assertTrue(false);

        // uncomment this
        /*
        var xs = ConsList.of(1, 2, 3, 4);
        var t3 = xs.take(3);
        assertEquals(ConsList.of(1, 2, 3), t3);
        */
    }

    @Test
    void implement_drop() {
        // comment out this
        assertTrue(false);

        // uncomment this
        /*
        var xs = ConsList.of(1, 2, 3, 4);
        var d3 = xs.drop(3);
        assertEquals(ConsList.of(4), d3);
        */
    }

    @Test
    void implement_append() {
        // comment out this
        assertTrue(false);

        // uncomment this
        /*
        var xs = ConsList.of(1, 2, 3, 4);
        var ys = ConsList.of(5, 6);
        var ap = xs.append(ys);
        assertEquals(ConsList.of(1,2,3,4,5,6), ap);
        */
    }

    @Test
    void implement_rotate() {
        // comment out this
        assertTrue(false);

        // uncomment this
        /*
        var xs = ConsList.of(1, 2, 3, 4);
        assertEquals(ConsList.of(2,3,4,1), xs.rotate(1));
        assertEquals(ConsList.of(3,4,1,2), xs.rotate(2));
        */
    }
}
