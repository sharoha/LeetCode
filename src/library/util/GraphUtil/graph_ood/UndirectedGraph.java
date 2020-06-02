package library.util.GraphUtil.graph_ood;

public class UndirectedGraph<V, E> extends GraphList<V, E> {

    public UndirectedGraph() {
        super(false);
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
        Edge<V, E> e = new Edge<>(v1.getLabel(), v2.getLabel(), edge, false);
        v1.addEdge(e);
        v2.addEdge(e);
    }

    @Override
    public void addEdge(V source, V destination) {
        addEdge(source, destination, null);
    }

    @Override
    public boolean isDirected() {
        return false;
    }
}
