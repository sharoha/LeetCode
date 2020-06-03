package codes.june_challenge.day3;

import codes.fastio_java.InputReader;
import codes.fastio_java.OutputWriter;

import java.util.Arrays;
import java.util.Comparator;

public class TwoCityScheduling {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
    }

    // TODO : Can we solve this using DP???
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, Comparator.comparing((int[]e) -> e[0] - e[1]));
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
}
