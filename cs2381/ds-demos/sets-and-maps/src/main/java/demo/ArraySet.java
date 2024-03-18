package demo;

import java.util.ArrayList;
import java.util.Iterator;

public class ArraySet<T extends Comparable<T>> 
        implements Set<T> {
    final ArrayList<T> items;

    ArraySet() {
        items = new ArrayList<T>();
    }

    ArraySet(ArrayList<T> items) {
        this.items = items;
    }

    @Override
    public boolean contains(T item) {
        // Optimized: O(log n)
        // Binary search:
        //  - List is sorted
        //  - Start searching in the middle
        //  - At each step, cut search area in half

        // O(n)
        for (var xx : items) {
            if (xx.equals(item)) {
                return true;
            }
        }

        return false; 
    }

    @Override
    public Set<T> union(Set<T> that) {
        // O(n)
        Set<T> yy = new ArraySet<T>();
        for (var xx : this) {
            yy = yy.add(xx);
        }
        for (var xx : that) {
            yy = yy.add(xx);
        }
        return yy;
    }

    @Override
    public Set<T> intersection(Set<T> that) {
        // old: O(n^2)
        // new: O(n * log(n))
        Set<T> cc = new ArraySet<T>();
        for (var xx : this) {
            if (that.contains(xx)) {
                cc = cc.add(xx);
            }
        }
        return cc;
    }

    @Override
    public boolean isSubset(Set<T> that) {
        // O(n * log(n))
        for (var xx : this) {
            if (!that.contains(xx)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isSuperset(Set<T> that) {
        return that.isSubset(this);
    }

    @Override
    public Set<T> add(T item) {
        // O(n)
        if (contains(item)) {
            return this;
        }
        else {
            var xs = new ArrayList<T>();
            int ii = 0;
            for (; ii < size(); ++ii) {
                if (items.get(ii).compareTo(item) < 0) {
                    xs.add(items.get(ii));
                }
                else {
                    break;
                }
            }
            
            xs.add(item);
            
            for (; ii < size(); ++ii) {
                xs.add(items.get(ii));
            }

            return new ArraySet<T>(xs);
        }
    }

    @Override
    public Set<T> remove(T item) {
        // O(n^2)
        // Optimize: Just remove from array directly, O(n)
        Set<T> cc = new ArraySet<>();
        for (var xx : this) {
            if (!xx.equals(item)) {
                cc = cc.add(xx);
            }
        }
        return cc;
    }

    @Override
    public int size() {
        // O(1)
        return this.items.size();
    }

    @Override
    public Iterator<T> iterator() {
        return this.items.iterator();
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Set<?>)) {
            return false;
        }

        @SuppressWarnings("unchecked")
        Set<T> that = (Set<T>) other;

        // O(n * log(n))
        return this.isSubset(that) && that.isSubset(this);
    }
}
