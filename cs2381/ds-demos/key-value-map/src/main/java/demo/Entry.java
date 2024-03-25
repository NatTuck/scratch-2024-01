package demo;

public record Entry<K extends Comparable<K>, V> (K key, V val) {

}
