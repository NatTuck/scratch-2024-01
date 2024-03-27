package demo;

public interface BinTree<K extends Comparable<K>, V> {
    boolean isLeaf();
    boolean containsKey(K key);
    BinTree<K, V> add(K key, V val);
    V get(K key);
    BinTree<K, V> remove(K key);
    int size();
}

record BinBranch<K extends Comparable<K>, V>(
        Entry<K, V> data, BinTree<K, V> left, BinTree<K, V> right) 
        implements BinTree<K, V> {

    @Override
    public boolean isLeaf() {
        return false;
    }

    @Override
    public boolean containsKey(K key) {
        int cmp = key.compareTo(data.key());
        
        if (cmp == 0) {
            return true;
        }
        
        if (cmp < 0) {
            return left().containsKey(key); 
        }
        else {
            return right().containsKey(key); 
        }
    }

    @Override
    public BinTree<K, V> add(K key, V val) {
        int cmp = key.compareTo(data.key());
        
        if (cmp == 0) {
            return new BinBranch<>(
                new Entry<>(key, val),
                left(),
                right()
            );
        }
        
        if (cmp < 0) {
            return new BinBranch<>(
                data(),
                left().add(key, val),
                right()
            );
        }
        else {
            return new BinBranch<>(
                data(),
                left(),
                right().add(key, val)
            );
        }
 
    }

    @Override
    public V get(K key) {
        // Assume tree hight O(log n)
        // O(log n)

        int cmp = key.compareTo(data.key());
        
        if (cmp == 0) {
            // we found it
            return data().val();
        }

        if (cmp < 0) {
            return left().get(key);
        }
        else {
            return right().get(key);
        }
    }

    @Override
    public BinTree<K, V> remove(K key) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public int size() {
        // O(n)
        return 1 + left().size() + right().size();
    }
    
}

record BinLeaf<K extends Comparable<K>, V>() implements BinTree<K, V> {

    @Override
    public boolean isLeaf() {
        return true;
    }

    @Override
    public boolean containsKey(K key) {
        return false;
    }

    @Override
    public BinTree<K, V> add(K key, V val) {
        return new BinBranch<>(
            new Entry<>(key, val), 
            this, this);
    }

    @Override
    public V get(K key) {
        throw new RuntimeException("no such key");
    }

    @Override
    public BinTree<K, V> remove(K key) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public int size() {
        return 0;
    }

}

