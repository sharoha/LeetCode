#include <bits/stdc++.h>
using namespace std;

class Solution {
    vector<int> w_sum;
    int sum = 0;
public:
    Solution(vector<int>& w) {
        for (int s : w) {
            sum += s;
            w_sum.push_back(sum);
        }
    }
    
    int pickIndex() {
        int ind = rand() % sum;
        auto  itr =  upper_bound(w_sum.begin(), w_sum.end(), ind);
        return distance(w_sum.begin(), itr);
    }
};

/**
 * Your Solution object will be instantiated and called as such:
 * Solution* obj = new Solution(w);
 * int param_1 = obj->pickIndex();
 */