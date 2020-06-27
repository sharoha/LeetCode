package codes.contest.Weekly192;

import codes.fastio_java.InputReader;
import codes.fastio_java.OutputWriter;

import java.util.Arrays;

public class D {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.i();
        int[] a = in.ia(n);
        int q = in.i();
        TreeAncestor r = new TreeAncestor(n, a);
        while (q-- > 0) {
            int[] qe = in.ia(2);
            out.printLine(r.getKthAncestor(qe[0], qe[1]));
        }
    }

    static class TreeAncestor {
        private final int[][] par;
        private final int D;
        public TreeAncestor(int n, int[] parent) {
            D = Integer.numberOfTrailingZeros(Integer.highestOneBit(n));
            par = new int[D + 1][n];
            for (int[] u : par) Arrays.fill(u, -1);
            for (int i = 0; i < parent.length; i++) {
                par[0][i] = parent[i];
            }
            build(n);
        }

        public void build(int n) {
            for (int d = 1; d <= this.D; d++) {
                for (int i =0; i < n; i++) {
                    int mid = par[d - 1][i];
                    if (mid != -1) {
                        par[d][i] = par[d - 1][mid];
                    }
                }
            }
        }

        public int getKthAncestor(int node, int k) {
            for (int d = 0; d <= D && node != -1; d++) {
                if (((1 << d) & k) > 0) {
                    node = par[d][node];
                }
            }
            return node;
        }
    }
}
