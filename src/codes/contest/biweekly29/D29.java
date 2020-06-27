package codes.contest.biweekly29;

import codes.fastio_java.InputReader;
import codes.fastio_java.OutputWriter;
import library.util.GraphUtil.graph_ood.DirectedGraph;
import library.util.GraphUtil.graph_ood.IGraph;
import library.util.PairUtil.IntIntPair;

import java.util.*;

public class D29 {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.i();
        int m = in.i();
        int[][] dep = new int[m][2];
        for (int i = 0; i < m; i++) {
            dep[i] = in.ia(2);
        }
        int k = in.i();
        out.printLine(minNumberOfSemesters(n, dep, k));
    }

    public int minNumberOfSemesters(int n, int[][] dep, int k) {
        if (dep == null || dep.length == 0) return (n - 1) / k + 1;
        DirectedGraph<Integer, Integer> graph = new DirectedGraph<>();
        for (int i = 1; i <= n; i++) {
            graph.addVertex(i);
        }
        for (int[] edge : dep) {
            graph.addEdge(edge[0], edge[1]);
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((e, f) -> Integer.compare(graph.getOutDegree(f), graph.getOutDegree(e)));
        for (int i = 1; i <= n; i++) {
            if (graph.getInDegree(i) == 0) {
                maxHeap.add(i);
            }
        }
        int res = 0;
        while (!maxHeap.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < k; i++) {
                if (maxHeap.isEmpty()) break;
                int cur = maxHeap.remove();
                for (int nei : graph.getNeighborVertices(cur)) {
                    if (graph.decInDegree(nei) == 0) {
                        list.add(nei);
                    }
                }
            }
            maxHeap.addAll(list);
            res++;
        }
        return res;
    }
}
