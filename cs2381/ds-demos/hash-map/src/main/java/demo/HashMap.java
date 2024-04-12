package demo;

import java.lang.reflect.Array;

public class HashMap<K, V> {
    Entry<K, V>[] data;
    int size;
   
    HashMap() {
        this.data = newArray(4);
    }

    @SuppressWarnings("unchecked")
    Entry<K, V>[] newArray(int size) {
        return (Entry<K, V>[]) Array.newInstance(Entry.class, size);
    }

    void grow() {
        var data0 = this.data;
        this.data = newArray(this.data.length * 2);
        this.size = 0;
        for (int ii = 0; ii < data0.length; ++ii) {
            if (data0[ii] != null) {
                insert(data0[ii].key(), data0[ii].val());
            }
        }
    }

    int slot(K key) {
        return Math.floorMod(key.hashCode(), this.data.length);
    }

    double nextLoadFactor() {
        double cap = this.data.length;
        return (size + 1) / cap;
    }

    void insert(K key, V val) {
        if (nextLoadFactor() > 0.6) {
            grow();
        }

        this.size += 1;

        int s0 = slot(key);
        System.out.println("key '" + key + "' hashes to " + s0);
        for (int ii = 0; ii < data.length; ++ii) {
            int sl = Math.floorMod(s0 + ii, this.data.length);
            if (this.data[sl] == null) {
                System.out.println("insert '" + key + "' into slot " + sl);
                this.data[sl] = new Entry<>(key, val);
                return;
            }
        }
        throw new RuntimeException("table full");
    }

    boolean hasKey(K key) {
        return getOrNull(key) != null;
    }

    V get(K key) {
        V val = getOrNull(key);
        if (val == null) {
            throw new RuntimeException("no such key");
        }
        return val;
    }

    V getOrNull(K key) {
        int s0 = slot(key);
        for (int ii = 0; ii < data.length; ++ii) {
            int sl = Math.floorMod(s0 + ii, this.data.length);
            if (this.data[sl] == null) {
                return null;
            }
            var ent = data[sl];
            if (ent.key().equals(key)) {
                return ent.val();
            }
        }
        return null;
    }

    void delete(K key) {
        int s0 = slot(key);
        for (int ii = 0; ii < data.length; ++ii) {
            int sl = Math.floorMod(s0 + ii, this.data.length);
            var ent = data[sl];
            if (ent == null) {
                break;
            }
            if (ent.key().equals(key)) {
                data[sl] = new Entry(null, null);
                return;
            }
        }
        throw new RuntimeException("no such key");
    }
}
