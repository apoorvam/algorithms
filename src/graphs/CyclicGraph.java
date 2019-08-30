package graphs;

public class CyclicGraph {
    private boolean[] marked;
    private Graph graph;

    public CyclicGraph(Graph graph) {
        this.graph = graph;
        marked = new boolean[graph.V()];
    }

    public boolean cycleExists() {
        for (int i = 0; i < graph.V(); i++) {
            if (!marked[i]) {
                if (isCyclic(i, -1)) return true;
            }
        }
        return false;
    }

    private boolean isCyclic(int u, int parent) {
        marked[u] = true;
        for (int v : graph.adj(u)) {
            if (v == parent) continue;
            if (!marked[v]) {
                if (isCyclic(v, u)) return true;
            } else {
                return true;
            }
        }
        return false;
    }

}
