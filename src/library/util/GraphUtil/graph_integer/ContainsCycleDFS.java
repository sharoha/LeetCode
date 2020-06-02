package library.util.GraphUtil.graph_integer;

public class ContainsCycleDFS {
    public enum Mark {
        UNMARKED, //
        TEMPORARY, // current iteration has this node, that means a cycle
        PERMANENT // already been visited,
    }
    private final Graph graph;
    private final Mark[] node;
    public ContainsCycleDFS(Graph g) {
        this.graph = g;
        node = new Mark[graph.size];
        for (int i = 0; i < graph.size; i++) {
            node[i] = Mark.UNMARKED;
        }
    }

    public boolean dfs(int source) {
        if (node[source] == Mark.PERMANENT) {
            return false; // does not contain a cycle
        }
        if (node[source] == Mark.TEMPORARY) {
            return true; // contains a cycle
        }
        boolean containsCycle = false;
        node[source] = Mark.TEMPORARY; // mark with temporary, since we are visiting it in the current iteration
        for (Integer nei : graph.getNeighbor(source)) {
            containsCycle |= dfs(nei);
        }
        node[source] = Mark.PERMANENT;
        return containsCycle; // does not contain a cycle
    }
}
