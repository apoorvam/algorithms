package graphs;

public class BipartiteGraph {

    private boolean[] marked;
    private boolean[] color;
    private Graph graph;

    public BipartiteGraph(Graph graph) {
        this.graph = graph;
        marked = new boolean[graph.V()];
        color = new boolean[graph.V()];
    }

    public boolean isBipartite() {
        return isBipartite(0);
    }

    private boolean isBipartite(int v) {
        boolean noAdj = true;
        for (Integer u: graph.adj(v)) {
            noAdj = false;
            if (!marked[u]) {
                marked[u] = true;
                color[u] = !color[v];
                if (!isBipartite(u)) return false;
            } else {
                if (color[u] == color[v]) return false;
            }
        }
        return !noAdj;
    }
}
