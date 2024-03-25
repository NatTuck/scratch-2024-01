package demo;

import java.util.ArrayList;
import java.util.List;

public class ListMap<K extends Comparable<K>, V> 
        implements Map<K, V> {

    ArrayList<Entry<K, V>> data;

    ListMap() {
        data = new ArrayList<Entry<K, V>>();
    }

    @Override
    public boolean containsKey(K key) {
        // O(n)
        for (var ent: data) {
            if (ent.key().equals(key)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<K> keys() {
        // O(n)
        var ys = new ArrayList<K>();
        for (var ent: data) {
            ys.add(ent.key());
        }
        return ys;
    }

    @Override
    public void add(K key, V val) {
        // O(1)
        var ent = new Entry<>(key, val);
        data.add(ent);
    }

    @Override
    public void remove(K key) {
        // O(n)
        data.removeIf((ent) -> ent.key().equals(key));

        /*
        var newData = new ArrayList<Entry<K, V>>();
        for (var ent : data) {
            if (!ent.key().equals(key)) {
                newData.add(ent);
            }
        }
        this.data = newData;
        */
    }

    @Override
    public int size() {
        return data.size();        
    }

    @Override
    public V get(K key) {
        for (int ii = data.size() - 1; ii >= 0; --ii) {
            var ent = data.get(ii);
            if (ent.key().equals(key)) {
                return ent.val();
            }
        }
        throw new RuntimeException("no such key");
    }
}
