package lab14;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppShould {
    @Test
    void have_correct_url() {
        final var correct = "https://words.homework.quest/socket/websocket";
        assertEquals(correct, App.URL);
    }
}
