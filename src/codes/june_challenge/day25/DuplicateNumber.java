package codes.june_challenge.day25;

import codes.fastio_java.InputReader;
import codes.fastio_java.OutputWriter;

public class DuplicateNumber {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
    }

    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
