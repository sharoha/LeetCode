package codes.contest.Weekly192;

import codes.fastio_java.InputReader;
import codes.fastio_java.OutputWriter;
import library.util.MathUtil.ArrayUtil;
import library.util.PairUtil.IntIntPair;

import java.util.*;

public class C {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.i();
        int[] a = in.ia(n);
        int m = in.i();
        int k = in.i();
        out.printLine(minDays(a, m, k));
    }

    public int minDays(int[] bloomDay, int m, int k) {
        HashMap<Integer, Integer> freq = ArrayUtil.countFrequencyOfEveryElement(bloomDay);
        List<Integer> distinct = new ArrayList<>(freq.keySet());
        Collections.sort(distinct);
        int l = 0;
        int h = distinct.size() - 1;
        int an =-1;
        while (l <= h) {
            int mid = (l + h) >> 1;
            int midElement = distinct.get(mid);
            if (check(bloomDay, k, midElement, m)) {
                an = midElement;
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return an;
    }

    private boolean check(int[] b, int k, int mid, int m) {
        int count = 0;
        int curK = 0;
        for (int i = 0; i < b.length; i++) {
            if (b[i] <= mid) {
                count++;
            } else {
                curK += (count / k);
                count = 0;
            }
        }
        if (count > 0) curK += (count / k);
        return curK >= m;
    }

}
