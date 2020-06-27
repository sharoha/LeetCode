package codes.contest.biweekly28;

import codes.fastio_java.InputReader;
import codes.fastio_java.OutputWriter;
import library.util.MathUtil.ArrayUtil;
import library.util.PairUtil.IntIntPair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class C {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.i();
        int[] a = in.ia(n);
        int targe = in.i();
        out.printLine(minSumOfLengths(a, targe));
    }

    public int minSumOfLengths(int[] arr, int target) {
        int[] pref = new int[arr.length + 1];
        for (int i = 1; i <= arr.length; i++) {
            pref[i] += (pref[i - 1] + arr[i - 1]);
        }
        List<IntIntPair> list = new ArrayList<>();
        for (int i = 1; i <= arr.length; i++) {
            int toFind = pref[i] - target;
            int ini = Arrays.binarySearch(pref, 0, i, toFind);
            if (ini >= 0) {
                list.add(IntIntPair.of(ini + 1, i));
            }
        }
        list.sort(Comparator.comparing(e -> e.first));
        if (list.size() == 0) return  -1;
        int[] min = new int[list.size()];
        min[list.size() - 1] = getDistance(list.get(list.size() - 1));
        for (int i = list.size() - 2; i >= 0; i--) {
            min[i] = Math.min(getDistance(list.get(i)), min[i + 1]);
        }
        int[] xIndex = new int[list.size() + 1];
        for (int i = 0; i < list.size(); i++) xIndex[i] = list.get(i).first;
        int ans = Integer.MAX_VALUE;
        for (IntIntPair p : list) {
            int upperBound = ArrayUtil.upperBound(xIndex, p.second);
            if (upperBound < list.size()) {
                ans = Math.min(ans, getDistance(p) + min[upperBound]);
            }
        }
        return ans ==  Integer.MAX_VALUE ?  -1 : ans;
    }

    public int getDistance(IntIntPair p) {
        return p.second - p.first + 1;
    }
}

