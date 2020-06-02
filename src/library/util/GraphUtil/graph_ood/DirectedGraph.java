package library.util.GraphUtil.graph_ood;

import java.util.Objects;

/**
 * @param <V> Vertex
 * @param <E> Edge
 * todo : Figure out how to add n vertices in a single loop
 */
public class DirectedGraph<V, E> extends GraphList<V, E> {

    public DirectedGraph() {
        super(true);
    }

    public DirectedGraph(int n) {
        super(true);
    }
    /**
     * @param source Source of the Edge
     * @param destination Destination of the Edge
     * @param edge Edge to be added between Source and Destination
     * Add source and destination first as a vertex into the graph, then call this method
     */
    @Override
    public void addEdge(V source, V destination, E edge) {
        GraphVertexList<V, E> v1 = vertexEdgeMap.get(source);
        GraphVertexList<V, E> v2 = vertexEdgeMap.get(destination);
        Objects.requireNonNull(v1, "source is not present in the graph");
        Objects.requireNonNull(v2, "destination is not present in the graph");
        Edge<V, E> e = new Edge<>(v1.getLabel(), v2.getLabel(), edge, true);
        v1.addEdge(e);
    }

    @Override
    public void addEdge(V source, V destination) {
        addEdge(source, destination, null);
    }

    @Override
    public int getDegree(V source) {
        return 0;
    }

    @Override
    public boolean isDirected() {
        return true;
    }

}
