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
        return binarySearch(ind + 1);
    }
    
    int binarySearch(int val) {
        int low = 0;
        int high = w_sum.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (w_sum[mid] < val){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
};

/**
 * Your Solution object will be instantiated and called as such:
 * Solution* obj = new Solution(w);
 * int param_1 = obj->pickIndex();
 */