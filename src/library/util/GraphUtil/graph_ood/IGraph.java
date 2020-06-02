package library.util.GraphUtil.graph_ood;

import java.util.Set;

public interface IGraph<V, E> {

    void addVertex(V label);

    void addEdge(V source, V destination);

    void addEdge(V source, V destination, E edge);

    int getDegree(V source);

    Set<Edge<V, E>> getEdges(V source);

    Set<V> getNeighborVertices(V source);

    GraphVertexList<V, E> getGraphVertexList(V source);

    boolean isDirected();

    Set<V> getVertexList();
}
