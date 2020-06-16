#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int findCheapestPrice(int n, vector<vector<int>>& flights, int src, int dst, int K) {
       unordered_map<int,vector<pair<int, int>>> adj;
        for(vector<int>& f : flights )
            adj[f[0]].push_back( { f[1], f[2] } );
        
        priority_queue<vector<int>, vector<vector<int>>, greater<vector<int>> > pq;
        //pushing distance source and k + 1 layover
        pq.push({0, src, K + 1});
        while (!pq.empty()) {
            auto temp = pq.top();
            pq.pop();
            int d = temp[0];
            int s = temp[1];
            int lo = temp[2];
            if (s == dst) return d;
            if (lo > 0) {
                for (auto p : adj[s]) {
                    pq.push({d + p.second, p.first, lo - 1});
                }
            }
        }
        return -1;
    }
};