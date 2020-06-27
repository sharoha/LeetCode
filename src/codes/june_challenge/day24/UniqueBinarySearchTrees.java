package codes.june_challenge.day24;

import codes.fastio_java.InputReader;
import codes.fastio_java.OutputWriter;
import library.util.MathUtil.IntegerUtil;

public class UniqueBinarySearchTrees {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
    }

    public int numTrees(int n) {
        long[][] ncr = IntegerUtil.getNcr(2 * n + 1);
        return (int) ((ncr[2 * n][n]) / (n + 1));
    }
}
