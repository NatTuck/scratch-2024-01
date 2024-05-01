package demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static demo.App.triple;

public class AppShould {

    @Test
    void triple_numbers_correctly() {
        assertEquals(0, triple(0));
        assertEquals(30, triple(10));
        assertEquals(-111, triple(-37));
        //assertEquals(-111, triple(801001001));
    }
}
