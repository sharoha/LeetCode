package codes.contest.biweekly28;

import codes.fastio_java.InputReader;
import codes.fastio_java.OutputWriter;
import library.util.MathUtil.Cons;

import java.util.Arrays;

public class D {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.i();
        int[] ar = in.ia(n);
        int k = in.i();
        out.printLine(minDistance(ar, k));
    }

    private Integer[][] dp;
    private int[][] cost; // stores the cost from i to j house
    private int[] h;
    private int k;
    public int minDistance(int[] houses, int K) {
        // stores the min distance using k mailbox till position i
        Arrays.sort(houses);
        dp = new Integer[houses.length][K];
        cost = new int[houses.length][houses.length];
        this.h = houses;
        this.k = K;
        for (int i = 0; i < houses.length; i++) {
            for (int j = i; j < houses.length; j++) {
                int median = houses[(i + j) >> 1]; // best place to store the single mailbox
                int co = 0;
                for (int k = i; k <= j; k++) {
                    co += Math.abs(median - houses[k]);
                }
                cost[i][j] = co;
            }
        }
        return dfs(0, 0);
    }

    private int dfs(int pos, int curK) {
        if (pos == h.length) {
            if (curK == k) {
                return 0; // we have placed all the mailbox in every house, so 0
            }
            return Cons.inf;
        }
        if (curK == k) return Cons.inf;
        if (dp[pos][curK] != null) return dp[pos][curK];
        int ans = Cons.inf;
        for (int i = pos; i < h.length; i++) {
            // best place to put the current house is at the median of [pos, i]
            int median = h[(i + pos) / 2];
            ans = Math.min(ans, dfs(i + 1, curK + 1) + cost[pos][i]);
        }
        return dp[pos][curK] = ans;
    }
}
