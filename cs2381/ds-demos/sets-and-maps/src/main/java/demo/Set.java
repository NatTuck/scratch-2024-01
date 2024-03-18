package demo;

public interface Set<T extends Comparable<T>> extends Iterable<T> {
    @SuppressWarnings("unchecked")
    static <U extends Comparable<U>> Set<U> of(U... items) {
        Set<U> yy = new ArraySet<>();
        for (var xx : items) {
            yy = yy.add(xx);
        }
        return yy;
    }

    boolean contains(T item);

    Set<T> union(Set<T> set);

    Set<T> intersection(Set<T> set);

    boolean isSubset(Set<T> setB);

    boolean isSuperset(Set<T> setB);

    Set<T> add(T item);

    Set<T> remove(T item);

    int size();

}
