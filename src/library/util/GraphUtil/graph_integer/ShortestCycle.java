package library.util.GraphUtil.graph_integer;

import library.util.MathUtil.Cons;

import java.util.*;

// Valid for undirected graph
public class ShortestCycle extends Graph {
    private final Set<Integer> S; // To keep track of the visited nodes
    private final Queue<Integer> R; // To add vertices for bfs traversal
    private final int[] parent; // keeps track of parent
    private final int[] dis; // distance of vertex from source
    private int shortestCycle; // This field stores the shortest cycle length after all the iteration

    public ShortestCycle(int size) {
        super(size);
        this.S = new HashSet<>();
        this.R = new ArrayDeque<>();
        this.parent = new int[size];
        this.dis = new int[size];
        this.shortestCycle = Cons.max;
    }

    /**
     * This gets the smallest cycle based on the fact that, if you get a node which you already visited while
     * doing a bfs, then you get a cycle of min length from source, and length is dis(source, already_visited_node) + dis(source, node which is used to reach
     * already_visited_node) + 1
     * @param source Starting point in the graph
     */
    public void smallestCycleLength(int source) {
        if (graph.get(source).size() == 0) return;
        clearEverything();
        parent[source] = -1;
        dis[source] = 0;
        R.add(source);
        int girth = Cons.max;
        while (!R.isEmpty()) {
            int current = R.poll();
            S.add(current);
            for (Integer nei : graph.get(current)) {
                if (nei != parent[current]) { // already visited
                    if (!S.contains(nei)) {
                        parent[nei] = current;
                        dis[nei] = dis[current] + 1;
                        R.add(nei);
                    } else {
                        girth = Math.min(girth, dis[nei] + dis[current] + 1);
                    }
                }
            }
        }
        this.shortestCycle = Math.min(this.shortestCycle, girth);
    }

    public int getShortestCycle() {
        return shortestCycle;
    }

    /**
     * Do not call this method for zero neighbors, since that takes extra processing steps here
     */
    public void clearEverything() {
        this.S.clear();
        this.R.clear();
        Arrays.fill(this.parent, -2);
        Arrays.fill(this.dis, 0);
    }
}
