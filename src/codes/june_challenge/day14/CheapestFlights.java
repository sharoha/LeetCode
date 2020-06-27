package codes.june_challenge.day14;

import codes.fastio_java.InputReader;
import codes.fastio_java.OutputWriter;
import library.util.GraphUtil.graph_ood.DirectedGraph;
import library.util.GraphUtil.graph_ood.Edge;
import library.util.GraphUtil.graph_ood.IGraph;
import library.util.MathUtil.Cons;

public class CheapestFlights {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.i();
        int m = in.i();
        int[][] flights = new int[m][3];
        for (int i = 0; i < m ; i++) {
            flights[i] = in.ia(3);
        }
        int src = in.i();
        int des = in.i();
        int k = in.i();
        out.printLine(findCheapestPrice(n, flights, src, des, k));
    }

    private int answer = Cons.inf;
    private IGraph<Integer, Integer> graph;
    private int k;
    private boolean[] vis;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        graph = new DirectedGraph<>(n);
        this.k = K;
        vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            graph.addVertex(i);
        }
        for (int[] edges : flights) {
            graph.addEdge(edges[0], edges[1], edges[2]);
        }
        dfs(src, dst, 0, 0);
        return answer == Cons.inf ? -1 : answer;
    }

    public void dfs(int src, int dest, int curK, int weightSum) {
        if (curK <= k + 1 && src == dest) {
            answer = Math.min(answer, weightSum);
            return;
        }
        if (vis[src] || curK > k + 1) return;
        vis[src] = true;
        for (Edge<Integer, Integer> edge : graph.getEdges(src)) {
            if (weightSum + edge.getLabel() > answer) continue; // this line was crucial-- cost + currentFlightCost > minPathCost then discard this path
            dfs(edge.getDestination(), dest, curK + 1, weightSum + edge.getLabel());
        }
        vis[src] = false;
    }
}
