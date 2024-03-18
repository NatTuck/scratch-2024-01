package demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArraySetShould {

    @Test
    void add_two_numbers() {
        var aa = Set.of(2, 4, 6, 8);
        var bb = Set.of(4, 4, 6, 2, 8);
        assertEquals(aa, bb);

        var cc = Set.of(1, 2, 3, 4);
        assertEquals(Set.of(1, 2, 3, 4, 6, 8), cc.union(aa));
        assertEquals(Set.of(2, 4), cc.intersection(aa));

        assertTrue(!aa.isSubset(cc));
    }
}
