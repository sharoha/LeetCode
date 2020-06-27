package codes.june_challenge.day21;

import codes.fastio_java.InputReader;
import codes.fastio_java.OutputWriter;

public class DungeonGame {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
    }

    public int calculateMinimumHP(int[][] d) {
        if (d == null) return 0;
        int m = d.length;
        if (m == 0) return 0;
        int n = d[0].length;
        if (n == 0) return 0;
        int[][] dp = new int[m][n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1) {
                    dp[m - 1][n - 1] = Math.max(1, 1 - d[m - 1][n - 1]);
                } else if (i == m - 1) {
                    dp[m - 1][j] = Math.max(dp[m - 1][j + 1] - d[m - 1][j], 1);
                } else if (j == n - 1) {
                    dp[i][n - 1] = Math.max(dp[i + 1][n - 1] - d[i][n - 1], 1);
                } else {
                    dp[i][j] = Math.min(Math.max(dp[i + 1][j] - d[i][j], 1), Math.max(dp[i][j + 1] - d[i][j], 1));
                }
            }
        }

        return dp[0][0];
    }
}
