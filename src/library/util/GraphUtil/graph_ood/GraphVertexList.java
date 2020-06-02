package library.util.GraphUtil.graph_ood;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class GraphVertexList<V, E> extends Vertex<V> {
    private final Set<Edge<V, E>> adjacentEdges;

    public GraphVertexList(V label) {
        super(label);
        adjacentEdges = new HashSet<>();
    }

    public void addEdge(Edge<V, E> edge) {
        if (!containsEdge(edge)) {
            adjacentEdges.add(edge);
        }
    }

    public boolean containsEdge(Edge<V, E> edge) {
        return adjacentEdges.contains(edge);
    }

    public Edge<V, E> removeEdge(Edge<V, E> edge) {
        boolean removed =  adjacentEdges.remove(edge);
        return removed ?  edge : null;
    }

    public int degree() {
        return adjacentEdges.size();
    }

    public Set<V> getAdjacentVertices() {
        return adjacentEdges.stream().map(Edge::getDestination).collect(Collectors.toSet());
    }

    public Set<Edge<V, E>> getAdjacentEdges() {
        return adjacentEdges;
    }

    @Override
    public String toString() {
        return "GraphVertexList: " + getLabel();
    }
}
