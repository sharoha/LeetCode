package codes.june_challenge.day3;

import codes.fastio_java.InputReader;
import codes.fastio_java.OutputWriter;

import java.util.Arrays;
import java.util.Comparator;

public class TwoCityScheduling {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.i();
        int[][] costs = new int[n][2];
        for (int i = 0; i < n; i++) {
            costs[i] = in.ia(2);
        }
        out.printLine(twoCitySchedCostDP(costs));
    }

    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, Comparator.comparing((int[] e) -> e[0] - e[1]));
        int ans = 0;
        for (int i = 0; i < costs.length; i++) {
            if (i >= costs.length / 2) {
                ans += costs[i][1];
            } else {
                ans += costs[i][0];
            }
        }
        return ans;
    }


    // TODO : not complete yet
    private Integer[][] dp;
    /**
     * Dp implementation of the problem
     *
     * @param costs costs of person i to reach city A and city B
     * @return the minimum cost for exactly N people to travel to city A and exactly N people to travel to city B
     */
    public int twoCitySchedCostDP(int[][] costs) {
        dp = new Integer[costs.length / 2 + 1][costs.length / 2 + 1];
        fillDPTable(0, 0, 0, costs);
        return dp[0][0];
    }

    public int fillDPTable(int cityACount, int cityBCount, int person, int[][] costs) {
        if (cityACount == dp.length || cityBCount == dp.length) return Integer.MIN_VALUE;
        if (dp[cityACount][cityBCount] != null) return dp[cityACount][cityBCount];
        int minCost = Integer.MAX_VALUE;

        if (cityACount < dp.length) { // assign person to city A
            minCost = Math.min(minCost, costs[person][0] + fillDPTable(cityACount + 1, cityBCount, person + 1, costs));
        }
        if (cityBCount < dp.length) { // assign person to city B
            minCost = Math.min(minCost, costs[person][1] + fillDPTable(cityACount, cityBCount + 1, person + 1, costs));
        }
        return dp[cityACount][cityBCount] = minCost;
    }
}
