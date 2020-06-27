package codes.contest.Weekly192;

import codes.fastio_java.InputReader;
import codes.fastio_java.OutputWriter;
import library.util.MathUtil.ArrayUtil;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class B {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.i();
        int[] a = in.ia(n);
        int k = in.i();
        out.printLine(findLeastNumOfUniqueInts(a, k));
    }

    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer, Integer> freq = ArrayUtil.countFrequencyOfEveryElement(arr);
        PriorityQueue<Integer> pq = new PriorityQueue<>(freq.values());
        while (k > 0 && !pq.isEmpty()) {
            k--;
            int p = pq.remove();
            p--;
            if (p != 0) pq.add(p);
        }
        return pq.size();
    }
}
