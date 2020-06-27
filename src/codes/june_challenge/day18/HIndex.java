package codes.june_challenge.day18;

import codes.fastio_java.InputReader;
import codes.fastio_java.OutputWriter;

public class HIndex {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
    }

    public int hIndex(int[] c) {
        int n = c.length;
        int s = 0, e = n - 1;
        while (s < e) {
            int m = (s + e) / 2;
            if (c[m] < n - m) {
                s = m + 1;
            } else {
                e = m;
            }
        }
        if (s < n && c[s] >= n - s) return n - s;
        else return 0;
    }
}
