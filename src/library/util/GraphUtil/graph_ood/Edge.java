package library.util.GraphUtil.graph_ood;

public class Edge<V, E> {
    protected V source;
    protected V destination;
    protected E label;
    protected boolean visited;
    protected boolean directed;

    public Edge(V source, V destination, E label, boolean directed) {
        this.source = source;
        this.destination = destination;
        this.label = label;
        this.visited = false;
        this.directed = directed;
    }

    public V getSource() {
        return source;
    }

    public V getDestination() {
        return destination;
    }

    public void setLabel(E label) {
        this.label = label;
    }

    public E getLabel() {
        return label;
    }

    public boolean visit() {
        boolean was = visited;
        visited = true;
        return was;
    }

    public boolean isVisited() {
        return visited;
    }

    public boolean isDirected() {
        return directed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge<?, ?> e = (Edge<?, ?>) o;
        return (getSource().equals(e.getSource()) && getDestination().equals(e.getDestination()))
                ||
                (!directed && getSource().equals(e.getDestination()) &&
                        getDestination().equals(e.getSource()));

    }

    @Override
    public int hashCode() {
       if (directed) {
           return getSource().hashCode() - getDestination().hashCode();
       }
       return getSource().hashCode() ^ getDestination().hashCode();
    }
}
