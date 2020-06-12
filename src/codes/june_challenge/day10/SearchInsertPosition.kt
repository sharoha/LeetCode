package codes.june_challenge.day10

class Solution {
    fun searchInsert(nums: IntArray, target: Int): Int {
        var l = 0
        var h = nums.count() - 1
        while (l <= h) {
            val m = (l + h) / 2;
            if (nums[m] >= target) {
                h = m - 1;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
}