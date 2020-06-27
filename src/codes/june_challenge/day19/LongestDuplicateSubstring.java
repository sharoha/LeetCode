package codes.june_challenge.day19;

import codes.fastio_java.InputReader;
import codes.fastio_java.OutputWriter;
import library.util.MathUtil.ModUtil;
import library.util.PairUtil.IntIntPair;

import java.util.HashMap;
import java.util.Map;

public class LongestDuplicateSubstring {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
    }

    public String longestDupSubstring(String S) {
        IntIntPair beginIndexOfDup = getDuplicateIndex(S);
        if (beginIndexOfDup.first == -1) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = beginIndexOfDup.first; i < beginIndexOfDup.first + beginIndexOfDup.second; i++) {
            sb.append(S.charAt(i));
        }
        return sb.toString();
    }

    long[] power;
    private IntIntPair getDuplicateIndex(String s) {
        power = new long[s.length()];
        ModUtil mod = new ModUtil();
        for (int i = 0; i < s.length(); i++) {
            power[i] = mod.modPow(31, i);
        }
        int l = 0;
        int h = s.length() - 1;
        int in = -1, size = -1;
        while (l <= h) {
            int m = (l + h) >> 1;
            int ind = check(s, m);
            if (ind != -1) {
                in = ind;
                size = m;
                l = m + 1;
            } else {
                h = m - 1;
            }
        }
        return IntIntPair.of(in, size);
    }

    private int check(String s, int m) {
        if (m == 0) return -1;
        ModUtil mod = new ModUtil();
        long hash = 0;
        Map<Long, Integer> hIndex = new HashMap<>();
        for (int i = 0; i < m; i++) {
            hash = mod.add(hash, ((s.charAt(i) - 'a' + 1) * power[i]));
        }
        hIndex.put(hash, 0);
        for (int i = m; i < s.length(); i++) {
            hash = mod.sub(hash, ((s.charAt(i - m) - 'a' + 1)));
            hash = mod.mul(hash, mod.inv(31));
            hash = mod.add(hash, ((s.charAt(i) - 'a' + 1) * power[m - 1]));
            if (hIndex.containsKey(hash)) {
                int prevInd = hIndex.get(hash);
                boolean found = compare(s, prevInd, i - m + 1, m);
                if (found) {
                    return prevInd;
                } else {
                    hIndex.put(hash, i - m + 1);
                }
            } else {
                hIndex.put(hash, i - m + 1);
            }
        }
        return -1;
    }
    private boolean compare(String S, int i, int j, int m) {
        for (int l = 0; l < m; l++) {
            if (S.charAt(i++) != S.charAt(j++)) {
                return false;
            }
        }
        return true;
    }
}
