package demo;

import java.util.ArrayList;

public class HashMap<K, V> {
    ArrayList<Entry<K, V>> data;
    int capacity;
   
    HashMap() {
        this.capacity = 4;
        this.data = new ArrayList<Entry<K, V>>(capacity);
    }

    void insert(K key, V val) {
        data.add(Math.floorMod(key.hashCode(), capacity);
    }

    boolean hasKey(K key) {
        Math.floorMod(key.hashCode(), capacity)
        // same key in slot?
    }
}
