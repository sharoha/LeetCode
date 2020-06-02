package library.util.GraphUtil.graph_integer;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class LCABinaryLift extends Graph {
    private int D;
    public int[][] parent;
    public int[] depth;

    public LCABinaryLift(Graph g) {
        super(g);
        initialize(g.size);
    }

    public LCABinaryLift(int size) {
        super(size);
        initialize(size);
    }

    private void initialize(int size) {
        D = Integer.numberOfTrailingZeros(Integer.highestOneBit(size));
        parent = new int[D + 1][size];
        for (int[] u : parent) Arrays.fill(u, -1);
        depth = new int[size];
    }

    public void computeParentInformation(int s) {
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] seen = new boolean[size];
        q.add(s);
        seen[s] = true;
        while (!q.isEmpty()) {
            int i = q.poll();
            for (int j : graph.get(i)) {
                if (!seen[j]) {
                    seen[j] = true;
                    q.add(j);
                    parent[0][j] = i;
                    depth[j] = depth[i] + 1;
                }
            }
        }
        for (int d = 1; d <= D; d++) {
            for (int i = 0; i < size; i++) {
                int mid = parent[d - 1][i]; // parent of i in 2^(d - 1) level
                if (mid != -1) {
                    parent[d][i] = parent[d - 1][mid];
                }
            }
        }
    }

    // walk the tree exactly j steps
    private int walk(int i, int j) {
        for (int d = 0; d <= D && i != -1; d++) {
            if (((1 << d) & j) > 0) {
                i = parent[d][i];
            }
        }
        return i;
    }

    // compute lca
    public int lca(int i, int j) {
        if (depth[i] > depth[j]) {
            i = walk(i, depth[i] - depth[j]);
        }
        if (depth[j] > depth[i]) {
            j = walk(j, depth[j] - depth[i]);
        }
        if (i == j) return i;
        for (int d = D; d >= 0; d--) {
            if (parent[d][i] != parent[d][j]) {
                i = parent[d][i];
                j = parent[d][j];
            }
        }
        return parent[0][i];
    }

}
