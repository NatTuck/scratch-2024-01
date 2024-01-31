package demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppShould {

    @Test
    void add_two_numbers() {
        assertEquals(1 + 1, 2);
    }

    @Test
    void figure_out_rectangle_area() {
        var r1 = new Rectangle(10.0, 20.0);
        assertEquals(10.0, r1.width, 0.001);
        assertEquals(20.0, r1.height, 0.001);
        assertEquals(200.0, r1.area, 0.001);

        assertEquals(200.0, r1.area(), 0.001);
    }
}   
