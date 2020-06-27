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
        v1.setOutDegree(v1.getOutDegree() + 1);
        GraphVertexList<V, E> v2 = vertexEdgeMap.get(destination);
        v2.setInDegree(v2.getInDegree() + 1);
        Objects.requireNonNull(v1, "source is not present in the graph");
        Objects.requireNonNull(v2, "destination is not present in the graph");
        Edge<V, E> e = new Edge<>(v1.getLabel(), v2.getLabel(), edge, true);
        v1.addEdge(e);
    }

    @Override
    public void addEdge(V source, V destination) {
        addEdge(source, destination, null);
    }

    public int getOutDegree(V v) {
        return getGraphVertexList(v).getOutDegree();
    }

    public int getInDegree(V v) {
        return getGraphVertexList(v).getInDegree();
    }
    // decrement in degree by 1
    public int decInDegree(V v) {
        int deg = getGraphVertexList(v).getInDegree();
        deg = deg > 0 ? deg - 1 : 0;
        getGraphVertexList(v).setInDegree(deg);
        return deg;
    }

    // decrement out degree by 1
    public int decOutDegree(V v) {
        int deg = getGraphVertexList(v).getOutDegree();
        deg = deg > 0 ? deg - 1 : 0;
        getGraphVertexList(v).setOutDegree(deg);
        return deg;
    }
    public void setOutDegree(V v, int degree) {
        getGraphVertexList(v).setOutDegree(degree);
    }

    @Override
    public boolean isDirected() {
        return true;
    }

}
