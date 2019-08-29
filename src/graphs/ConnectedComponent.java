package graphs;

public class ConnectedComponent {
    private boolean[] marked;
    private int[] cc;
    private int count = 0;

    public ConnectedComponent(Graph graph) {
        marked = new boolean[graph.V()];
        cc = new int[graph.V()];
        for (int i = 0; i < graph.V(); i++) {
            if (!marked[i]) {
                dfs(graph, i);
                count++;
            }
        }
    }

    private void dfs(Graph graph, int s) {
        marked[s] = true;
        cc[s] = count;
        for (Integer n : graph.adj(s))
            if (!marked[n])
                dfs(graph, n);
    }

    public boolean isConnected(int u, int v) {
        return cc[u] == cc[v];
    }

    public int numberOfComponents() {
        return count;
    }

    public int id(int v) {
        return cc[v];
    }
}
