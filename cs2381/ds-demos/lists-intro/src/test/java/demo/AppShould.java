package demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.ArrayList;

import static demo.App.*;

public class AppShould {

    @Test
    void add_two_numbers() {
        assertEquals(1 + 1, 2);
    }
    
    @Test
    void test_add1ToAll() {
        var xs = List.of(1, 2, 3);
        var ys = List.of(2, 3, 4);
        assertEquals(ys, add1ToAll(xs));
    }
    
    @Test
    void test_add1ToEach() {
        var xs = new ArrayList<>(List.of(1, 2, 3));
        var ys = List.of(2, 3, 4);
        add1ToEach(xs);
        assertEquals(ys, xs);
    }
}   
