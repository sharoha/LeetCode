package codes.contest.weekly194;

import codes.fastio_java.InputReader;
import codes.fastio_java.OutputWriter;

public class AWeekly194 {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
    }

    public int xorOperation(int n, int start) {
        int xor = 0;
        for (int i = 0; i < n; i++) {
            xor ^= (start + 2 * i);
        }
        return xor;
    }
}
