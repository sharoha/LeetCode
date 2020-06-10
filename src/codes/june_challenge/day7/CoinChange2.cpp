#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int change(int amount, vector<int>& coins) {
        int row = coins.size() + 1;
        int col = amount + 1;
        vector<vector<int>> dp(row, vector<int>(col, 0));
        for (int i = 1; i < col; i++) {
            dp[0][i] = 0;
        }
        for (int i = 0; i < row; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                int temp = j - coins[i - 1];
                if(temp >= 0) {
                    dp[i][j] = dp[i][temp] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[row - 1][col - 1];
    }
};