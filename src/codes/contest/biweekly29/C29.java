package codes.contest.biweekly29;

import codes.fastio_java.InputReader;
import codes.fastio_java.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class C29 {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.i();
        int[] a = in.ia(n);
        out.printLine(longestSubarray(a));
    }

    public int longestSubarray(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length;) {
            if (nums[i] == 0) {
                list.add(0);
                i++;
            } else {
                int j = i;
                while (j < nums.length && nums[j] == 1) j++;
                list.add(j - i);
                i = j;
            }
        }
        if (list.size() == 1) {
            if (list.get(0) == 0) return 0;
            else return list.get(0) - 1;
        }
        if (list.size() == 2) return Math.max(list.get(0), list.get(1));
        int max = list.get(0);
        for (int i = 0; i < list.size() - 2; i++) {
            max = Math.max(max, list.get(i) + list.get(i + 2));
        }
        return max;
    }
}
