Java
----
1. The following works:  
    ```
    List<int[]> u = new ArrayList<>();
    int[][] toArray = u.toArray(new int[0][0]);
    ```
    But this does not:
    ```
    List<Integer> u = new ArrayList<>();
    int[] toArray = u.toArray(new int[0]);
    ```
