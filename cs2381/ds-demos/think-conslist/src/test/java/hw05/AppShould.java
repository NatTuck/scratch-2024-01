package hw05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppShould {
    @Test
    void have_list_equality() {
        assertEquals(ConsList.of(1, 2), ConsList.of(1, 2));
    }
}

