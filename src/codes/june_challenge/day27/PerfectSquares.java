package codes.june_challenge.day27;

import codes.fastio_java.InputReader;
import codes.fastio_java.OutputWriter;

import java.util.Arrays;

public class PerfectSquares {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
    }

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 10000000);
        dp[1] = 1;
        dp[0] = 0;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}
