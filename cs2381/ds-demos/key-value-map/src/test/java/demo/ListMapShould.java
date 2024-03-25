package demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListMapShould {
    @Test
    void store_some_data() {
        var sounds = new ListMap<String, String>();
        sounds.add("cow", "moo");
        sounds.add("pig", "oink");
        sounds.add("horse", "neigh");
        sounds.add("sheep", "baa");
        sounds.add("pig", "squeal");

        assertEquals(sounds.get("pig"), "squeal");

        String msg = null;
        try {
            sounds.get("squid");
        }
        catch (RuntimeException ee) {
            msg = ee.getMessage();
        }

        assertEquals("no such key", msg);
    }
}
