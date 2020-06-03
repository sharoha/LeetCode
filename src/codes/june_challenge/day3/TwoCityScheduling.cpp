#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    static bool sortByDiff(pair<pair<int, int>, int> &a, pair<pair<int, int>, int> &b) {
        return a.second < b.second;
    }
    
    int twoCitySchedCost(vector<vector<int>>& costs) {
        int n = costs.size();
        vector<pair<pair<int, int>, int>> vect;
        for (int i = 0; i < n; i++) {
            int diff = costs[i][0] - costs[i][1];
            vect.push_back({{costs[i][0], costs[i][1]}, diff});
        }
        sort(vect.begin(), vect.end(), sortByDiff);
        int cost = 0;
        for (int i = 0; i < n; i++) {
            // cout << vect[i].first.first << " " << vect[i].first.second << " " << vect[i].second << "\n";
            if (i < n / 2) cost += vect[i].first.first;
            else {
                cost += vect[i].first.second;
            }
        }
        return cost;
    }
};