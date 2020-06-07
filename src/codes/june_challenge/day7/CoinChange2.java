package codes.june_challenge.day7;

import codes.fastio_java.InputReader;
import codes.fastio_java.OutputWriter;

public class CoinChange2 {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int amount = in.i();
        int n = in.i();
        int[] coin = in.ia(n);
        out.printLine(change(amount, coin));
    }

    private Integer[][] dp;
    public int change(int amount, int[] coins) {
        if (amount == 0) return 1; // if amount is zero, we can have 1 way to change and that is a empty solution (Like 0 factorial = 1)
        if (coins.length == 0) return 0;
        dp = new Integer[coins.length + 1][amount + 1];
        dfs(0, coins, 0, amount);
        return dp[0][0];
    }

    public int dfs(int curAmount, int[] coins, int in, int amount) {
        if (in >= coins.length || curAmount > amount) return 0;
        if (curAmount == amount) {
            return 1;
        }
        if (dp[in][curAmount] != null) return dp[in][curAmount];
        int ans = 0;
        ans += dfs(curAmount + coins[in], coins, in, amount); // case 1: include in coin and recur for whole array
        ans += dfs(curAmount, coins, in + 1, amount); // case 2: don't include in coin and recur
        return dp[in][curAmount] = ans;
    }
}
