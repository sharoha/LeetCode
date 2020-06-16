#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    vector<int> largestDivisibleSubset(vector<int>& nums) {
        int n = nums.size();
        if (n == 0 || n == 1) return nums;
        sort(nums.begin(), nums.end());
        vector<int> dp(n, 1);
        
        int max_ele = INT_MIN;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    dp[i] = max(dp[i], 1 + dp[j]);
                }
            }
            max_ele = max(dp[i], max_ele);
        }
        
        vector<int> res;
        for (int i = n - 1; i >= 0; i--) {
            if (dp[i] == max_ele) {
                res.push_back(nums[i]);
                max_ele--;
            }
        }
        return res;
    }
};