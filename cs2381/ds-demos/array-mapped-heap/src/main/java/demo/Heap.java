package demo;

import java.util.ArrayList;

public class Heap<P extends Comparable<P>, V> {
    ArrayList<Entry<P, V>> data;

    Heap() {
        data = new ArrayList<>();
    }

    void push(P pri, V val) {
        var ent = new Entry<>(pri, val);
        data.add(ent);

        // Restore heap property
        int ii = data.size() - 1;
        int jj = parent(ii);

        // This does the right thing even if ii = 0 to begin
        // with.
        while (ii != 0 && data.get(ii).pri().compareTo(data.get(jj).pri()) < 0) {
            swap(ii, jj);
            ii = jj;
            jj = parent(ii);
        }
    }

    V next() {
        if (data.size() == 0) {
            return null;
        }

        int last = data.size() - 1;
        swap(last, 0);
        var ent = data.remove(last);

        int ii = 0;
        int jj = smallerChild(ii);

        while (ii < data.size() && jj < data.size()) {
            //System.out.printf("Comparing indexes: %d <> %d\n", ii, jj); 
            if (data.get(jj).pri().compareTo(data.get(ii).pri()) < 0) {
                swap(ii, jj);
                ii = jj;
                jj = smallerChild(ii);
            }
            else {
                break;
            }
        }

        return ent.val();
    }

    int smallerChild(int ii) {
        int lc = leftChild(ii);
        int rc = rightChild(ii);

        if (lc >= data.size() - 1) {
            return lc;
        }

        if (data.get(lc).pri().compareTo(data.get(rc).pri()) < 0) {
            return lc;
        }
        else {
            return rc;
        }
    }

    void swap(int ii, int jj) {
        var aa = data.get(ii);
        data.set(ii, data.get(jj));
        data.set(jj, aa);
    }

    int parent(int ii) {
        return (ii - 1) / 2;
    }

    int leftChild(int ii) {
        return 2 * ii + 1;
    }

    int rightChild(int ii) {
        return 2 * ii + 2;
    }
}

record Entry<P extends Comparable<P>, V>(P pri, V val)  {
    // pass
}
