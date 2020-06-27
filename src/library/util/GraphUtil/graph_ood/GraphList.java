package library.util.GraphUtil.graph_ood;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public abstract class GraphList<V, E> implements IGraph<V, E> {
    protected final Map<V, GraphVertexList<V, E>> vertexEdgeMap;
    protected final boolean directed;

    protected GraphList(boolean directed) {
        this.directed = directed;
        vertexEdgeMap = new HashMap<>();
    }

    @Override
    public void addVertex(V label) {
        if (vertexEdgeMap.containsKey(label)) return;
        GraphVertexList<V, E> v = new GraphVertexList<>(label);
        vertexEdgeMap.put(label, v);
    }

    public abstract void addEdge(V source, V destination, E edge);

    public abstract void addEdge(V source, V destination);

    @Override
    public int getDegree(V source) throws IllegalAccessException {
        if (directed) {
            throw new IllegalAccessException("Directed graph can not call getDegree, use inDegree, outDegree instead");
        }
        return vertexEdgeMap.get(source).degree();
    }

    @Override
    public Set<Edge<V, E>> getEdges(V source) {
        return vertexEdgeMap.get(source).getAdjacentEdges();
    }

    @Override
    public Set<V> getNeighborVertices(V source) {
        return vertexEdgeMap.get(source).getAdjacentVertices();
    }

    @Override
    public GraphVertexList<V, E> getGraphVertexList(V source) {
        return vertexEdgeMap.get(source);
    }

    @Override
    public Set<V> getVertexList() {
        return vertexEdgeMap.keySet();
    }
}
