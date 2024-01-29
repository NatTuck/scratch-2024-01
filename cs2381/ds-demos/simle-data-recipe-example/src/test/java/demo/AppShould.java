package demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static demo.App.*;

public class AppShould {

    @Test
    void test_doesPass() {
        assertTrue(!doesPass(35));
        assertTrue(doesPass(82));
        assertTrue(doesPass(60));
    }

    @Test
    void test_rectangleArea() {
        assertEquals(100.0, rectangleArea(10.0, 10.0), 0.0001);
        assertEquals(223.56, rectangleArea(24.3, 9.2), 0.0001);
        assertEquals(0.0, rectangleArea(24.3, 0), 0.0001);
    }

    @Test
    void test_rectArea() {
        assertEquals(100.0, rectArea(new Rect(10.0, 10.0)), 0.0001);
        assertEquals(223.56, rectArea(new Rect(24.3, 9.2)), 0.0001);
        assertEquals(0.0, rectArea(new Rect(24.3, 0)), 0.0001);
    }

    @Test
    void test_rect2Area() {
        assertEquals(100.0, rect2Area(new Rect2(10.0, 10.0)), 0.0001);
        assertEquals(223.56, rect2Area(new Rect2(24.3, 9.2)), 0.0001);
        assertEquals(0.0, rect2Area(new Rect2(24.3, 0)), 0.0001);
    }


 }
