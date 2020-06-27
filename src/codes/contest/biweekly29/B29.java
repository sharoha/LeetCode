package codes.contest.biweekly29;

import codes.fastio_java.InputReader;
import codes.fastio_java.OutputWriter;

public class B29 {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
    }

    public int kthFactor(int n, int k) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                count++;
                if (count == k) return i;
            }
        }
        return  -1;
    }
}
