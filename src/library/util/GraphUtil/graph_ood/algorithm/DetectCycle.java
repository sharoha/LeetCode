package library.util.GraphUtil.graph_ood.algorithm;

import library.util.GraphUtil.graph_ood.Color;
import library.util.GraphUtil.graph_ood.IGraph;

public class DetectCycle {
    /**
     * @param graph Given graph
     * @return true if cycle exits or false, throws Exception if the graph is Undirected=
     */
    public static <V, E> boolean containsCycle(IGraph<V, E> graph) {
        if (!graph.isDirected()) {
            throw new RuntimeException("Graph should be directed");
        }
        for (V vertices : graph.getVertexList()) {
            if (cycleExists(graph, vertices)) {
                return true;
            }
        }
        return false;
    }

    private static <V, E> boolean cycleExists(IGraph<V,E> graph, V source) {
        if (graph.getGraphVertexList(source).getColor() == Color.WHITE) {
            return false;
        }
        if (graph.getGraphVertexList(source).getColor() == Color.BLACK) {
            return true;
        }
        boolean cycle = false;
        graph.getGraphVertexList(source).setColor(Color.BLACK);
        for (V nei : graph.getNeighborVertices(source)) {
            cycle |= cycleExists(graph, nei);
        }
        graph.getGraphVertexList(source).setColor(Color.WHITE);
        return cycle;
    }
}
