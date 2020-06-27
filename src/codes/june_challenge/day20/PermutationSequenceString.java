package codes.june_challenge.day20;

import codes.fastio_java.InputReader;
import codes.fastio_java.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequenceString {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
    }

    public String getPermutation(int n, int k) {
        int[] fact = new int[n + 1];
        fact[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = i * fact[i - 1];
        }
        k--;
        List<Character> list = new ArrayList<>();
        for (char i = '1'; i <= '9'; i++) list.add(i);
        StringBuilder ans = new StringBuilder();
        for (int i = n; i > 0; i--) {
            int cu = k / fact[i - 1];
            k = k % fact[i - 1];
            ans.append(list.get(cu));
            list.remove(cu);
        }
        return ans.toString();
    }
}
