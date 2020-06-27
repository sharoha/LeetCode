DP
---
1. LIS  
   ```
   L[i] = MAX(L[j] | j < i, D[j] < D[i]) + "D[i]"
   ```
   ```java
   // D contains the sequence, L stores the longest increasing subsequence
   class Solution {
       public void LIS(int[] D) {
           List<List<Integer>> list = new ArrayList<>(D.length);
           list.get(0).add(D[0]);
           for (int i = 1; i < D.length; i++) 
               for (int j = 0; j < i; j ++)  {
                   if (D[j] < D[i] && (L[i].size() < L[j].size() + 1)) {
                       L[i] = L[j]; // this step can be done using binary search
                       // since L[j] stores sorted elements, and we can easily find the position of
                       // D[i]
                   }
               }
               L[i].add(D[i]);    
       }
   // now return the maximum size L[i]
   }
   
    ```
2. Tiling  
    a. Tiling with `2 * n` grid using `2*1` tile. The tile can be placed both horizontally and vertically  Recursive formula. [Explanation](https://www.iarcs.org.in/inoi/online-study-material/topics/dp-tiling.php): 
   ```
    f(n) = f(n - 1) + f(n - 2), f(0) = 1, f(1) = 1
   ```  
    b. Tiling with `3 * n` grid using `2*1` tile. The tile can be placed both horizontally and vertically  Recursive formula. [Explanation](http://eppsnet.com/2018/05/competitive-programming-poj-2663-tri-tiling/):
    ```
    f(n) = f(n - 2) + 2 * g(n - 1), f(0) = 1, f(1) = 0
    g(n) = f(n - 1) + g(n - 2), g(0)  = 0, g(1) = 1
    
   ```
   c. `4 * n` : [Explanation](https://journeywithdp.blogspot.com/2018/07/way-to-solve-tiling-problems.html)