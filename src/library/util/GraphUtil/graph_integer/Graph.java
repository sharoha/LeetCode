package library.util.GraphUtil.graph_integer;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    public List<List<Integer>> graph;
    public int size;

    public Graph(int size) {
        this.size = size;
        this.graph = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            this.graph.add(new ArrayList<>());
        }
    }

    public Graph(Graph g) {
        this.graph = g.graph;
        this.size = g.size;
    }

    public void addEdgeUndirected(int from, int to) {
        this.graph.get(from).add(to);
        this.graph.get(to).add(from);
    }

    public void addEdgeDirected(int from, int to) {
        this.graph.get(from).add(to);
    }

    public List<Integer> getNeighbor(int source) {
        return graph.get(source);
    }
}
