package codes.june_challenge.day22;

import codes.fastio_java.InputReader;
import codes.fastio_java.OutputWriter;

public class SingleNumberII {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
    }

    int BIT = 32;
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < BIT; i++) {
            int c = 0;
            for (int num : nums) {
                if ((num & (1 << i)) == 0) c++;
            }
            if (c % 3 == 0) {
                ans |= (1 << i);
            }
        }
        return ans;
    }
}
