package library.util.GraphUtil.graph_ood;

import java.util.Objects;

public class Vertex<E> {
    protected E label;
    protected Color color;
    protected boolean visited;
    protected int inDegree;
    protected int outDegree;

    public Vertex(E label) {
        this.label = label;
        this.visited = false;
        this.color = Color.UNKNOWN;
    }

    public E getLabel() {
        return label;
    }

    public boolean visit() {
        boolean was = this.visited;
        this.visited = true;
        return was;
    }

    public boolean isVisited() {
        return visited;
    }

    public void reset() {
        visited = false;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return this.color;
    }

    public int getInDegree() {
        return inDegree;
    }

    public void setInDegree(int inDegree) {
        this.inDegree = inDegree;
    }

    public int getOutDegree() {
        return outDegree;
    }

    public void setOutDegree(int outDegree) {
        this.outDegree = outDegree;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex<?> vertex = (Vertex<?>) o;
        return visited == vertex.visited &&
                Objects.equals(label, vertex.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label, visited);
    }

    @Override
    public String toString() {
        return "<Vertex: " + label + " >";
    }
}
