package codes.june_challenge.day13;

import codes.fastio_java.InputReader;
import codes.fastio_java.OutputWriter;
import library.util.MathUtil.ArrayUtil;
import library.util.PairUtil.IntIntPair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LargestDivisibleSubset {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.i();
        int[] a = in.ia(n);
        out.printLine(largestDivisibleSubset(a));
    }

    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        IntIntPair[] dp = new IntIntPair[n];// dp[i] stores the maximum length subset with given constraint -- IntIntPair(subsetSize, indexOfPrevElement)
        for (int i = 0; i < n; i++) {
            dp[i] = IntIntPair.of(1, -1);
        }
        // initially everything has a single length subset, since nums[i] divides nums[i]
        for (int i = 1; i < nums.length; i++) {
            int greatestDivisor = -1;
            int prevMaxIndex = -1;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    if (dp[j].first > greatestDivisor) {
                        greatestDivisor = dp[j].first;
                        prevMaxIndex = j;
                    }
                }
            }
            if (greatestDivisor != -1) {
                dp[i] = IntIntPair.of(dp[i].first + greatestDivisor, prevMaxIndex);
            }
        }
        // build the actual subset solution
        int maxIndex = 0;
        int maxValue = dp[0].first;
        for (int i = 0; i < dp.length; i++) {
            if (maxValue < dp[i].first) {
                maxIndex = i;
                maxValue = dp[i].first;
            }
        }
        List<Integer> answer = new ArrayList<>();
        while (maxIndex != -1) {
            answer.add(nums[maxIndex]);
            maxIndex = dp[maxIndex].second;
        }
        return answer;
    }
}
