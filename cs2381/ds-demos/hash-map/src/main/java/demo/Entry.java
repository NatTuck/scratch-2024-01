package demo;

interface Entry<K, V> {
    default boolean isEmpty() { return false; }
    default boolean isTomb() { return false; }
    default boolean isPair() { return false; }
    default K key() { throw new RuntimeException("not pair"); }
    default V val() { throw new RuntimeException("not pair"); }
}

record Pair<K, V>(K key, V val) implements Entry<K, V> {
    @Override
    public boolean isPair() {
        return true;
    }
}

// TODO: rest