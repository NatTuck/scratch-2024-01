package demo;

public class App {

    public static void main(String[] args) {
        var aa = BinTree.<Integer>getLeaf();
        aa = aa.insert(5);
        aa = aa.insert(3);
        aa = aa.insert(7);
        aa = aa.insert(10);
        aa = aa.insert(12);

        System.out.println(aa.toString());
    }
}

interface BinTree<T extends Comparable<T>> {
    @SuppressWarnings("unchecked")
    public static <U extends Comparable<U>> BinTree<U> getLeaf() {
        return (BinLeaf<U>) BinLeaf.sharedLeaf;
    }

    boolean isLeaf();
    boolean contains(T item);
    BinTree<T> insert(T item);
}

record BinLeaf<T extends Comparable<T>>() implements BinTree<T> {
    static BinLeaf<Integer> sharedLeaf = new BinLeaf<Integer>();

    @Override
    public boolean isLeaf() {
        return true;        
    }

    @Override
    public boolean contains(T item) {
        return false;
    }

    @Override
    public BinTree<T> insert(T item) {
        var node = new BinNode<T>(item, BinTree.getLeaf(), BinTree.getLeaf());
        return node;
    }

    @Override
    public String toString() {
        return "f";
    }

}

record BinNode<T extends Comparable<T>>(
             T data, BinTree<T> left, BinTree<T> right) 
        implements BinTree<T> {

    @Override
    public boolean isLeaf() {
        return false;
    }

    @Override
    public boolean contains(T item) {
        int cmp = item.compareTo(this.data);
        if (cmp == 0) {
            return true;
        }

        if (cmp < 0) { // item < data
            return this.left.contains(item);
        }
        else { // item > data
            return this.right.contains(item);
        }
    }

    @Override
    public BinTree<T> insert(T item) {
        int cmp = item.compareTo(this.data);
        if (cmp == 0) {
            return this;
        }

        if (cmp < 0) { // item < data
            var left = this.left.insert(item);
            var yy = new BinNode<T>(this.data, left, this.right);
            return yy;
        }
        else { // item > data
            var right = this.right.insert(item);
            var yy = new BinNode<T>(this.data, this.left, right);
            return yy;
        }

    }

    @Override
    public String toString() {
        return "(" + 
          this.left + " " +
          this.data + " " + 
          this.right + 
        ")";
    }
    
}