package library.util.AlgoUtil;


import library.util.MathUtil.Cons;

/**
 * A one index based implementation of fenwick tree
 * If any position of the bit array is modified, pass a 0 based index
 * Since an array is generally 0 based, So, if want to modify position 1 of bit table
 * then pass 0 in add function
 */
public class Fenwick {
    public final long[] bit;
    public final int size;

    public Fenwick(int[] a) {
        this(a.length);
        for (int i = 0; i < a.length; i++) {
            this.add(i, a[i]);
        }
    }

    public Fenwick(long[] a) {
        this(a.length);
        for (int i = 0; i < a.length; i++)
            this.add(i, a[i]);
    }

    public Fenwick(int size) {
        bit = new long[size + 1];
        this.size = size + 1;
    }

    // update pos i by delta, it substitutes with given delta
    // so if you want to increment the initial value by delta then change this
    public void add(int i, long delta) {
        for (++i; i < size; i += (i & -i)) {
            bit[i] += delta;
        }
    }
    // Compute the prefix sum value[1, i]
    public long sum(int i) {
        long sum = 0;
        for (++i; i > 0; i -= (i & -i)) {
            sum += bit[i];
        }
        return sum;
    }
    // Compute sum value[i, j]
    public long sum(int i, int j) {
        if (j < i) return Cons.INF;
        return sum(j) - sum(i - 1);
    }

    public int indexWithGivenCumFreq(long v) {
        int i = 0, n = size;
        for (int b = Integer.highestOneBit(n); b != 0; b >>= 1) {
            if ((i | b) < n && bit[i | b] <= v) {
                i |= b;
                v -= bit[i];
            }
        }
        return i;
    }

    public long freqAtGivenIndex(int i) {
        i++;
        long sum = bit[i];
        if (i > 0) {
            int z = i - Integer.lowestOneBit(i);
            i--;
            while (i != z) {
                sum -= bit[i];
                i -= Integer.lowestOneBit(i);
            }
        }
        return sum;
    }
}
