package codes.contest.biweekly28;

import codes.fastio_java.InputReader;
import codes.fastio_java.OutputWriter;

import java.util.Arrays;

public class MailBoxIterative {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.i();
        int[] houses = in.ia(n);
        int k = in.i();
        out.printLine(minDistance(houses, k));
    }

    public int minDistance(int[] houses, int K) {
        Arrays.sort(houses);
        int n = houses.length;
        int[][] dp = new int[n][K];
        int[][] cost = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int m = (i + j) >> 1;
                int c = 0;
                for (int l = i; l <= j; l++) {
                    c += Math.abs(houses[m] - houses[l]);
                }
                cost[i][j] = c;
            }
        }
        for (int[] u : dp) Arrays.fill(u, 10000000);
        // putting 1 mailbox from [0..i]
        for (int i = 0; i < n; i++) {
            dp[i][0] = cost[0][i];
        }
        for (int k = 1; k < K; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = i; j >= 0; j--) {
                    dp[i][k] = Math.min(dp[i][k], (j > 0 ? dp[j - 1][k - 1]: 0) + cost[j][i]);
                }
            }
        }
        return dp[n- 1][K -1];
    }
}
