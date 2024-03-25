package demo;

import java.util.List;

/*
 animal_noises = {
    "cow": "moo",
    "sheep": "baa",
    "horse": "neigh",
}
 */

public interface Map<K extends Comparable<K>, V> {
    boolean containsKey(K key);
    List<K> keys();
    void add(K key, V val);
    V get(K key);
    void remove(K key);
    int size();
}
