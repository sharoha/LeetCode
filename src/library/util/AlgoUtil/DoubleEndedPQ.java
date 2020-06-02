package library.util.AlgoUtil;

import java.util.TreeSet;

// NOTE: Does not work for duplicate values
public class DoubleEndedPQ {
    private TreeSet<Integer> set;
    public DoubleEndedPQ() {
        this.set = new TreeSet<>();
    }

    public int size() {
        return this.set.size();
    }

    public boolean isEmpty() {
        return this.set.size() == 0;
    }

    public boolean add(int x) {
        return this.set.add(x);
    }

    public int getMin() {
        return this.set.first();
    }

    public int getMax() {
        return this.set.last();
    }

    public boolean deleteMax() {
        if (this.set.size() == 0) return false;
        this.set.remove(this.set.last());
        return true;
    }

    public boolean deleteMin() {
        if (this.set.size() == 0) return false;
        this.set.remove(this.set.first());
        return true;
    }
}
