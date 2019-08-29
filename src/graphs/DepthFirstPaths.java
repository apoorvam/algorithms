package graphs;

import edu.princeton.cs.algs4.Stack;

// DepthFirstPaths uses Graph data structure and implements DFS traverse through it
public class DepthFirstPaths implements GraphPaths {
    private final int source;
    private final Graph graph;
    private boolean[] marked;
    private int[] edgeTo;

    public DepthFirstPaths(Graph graph, int source) {
        this.graph = graph;
        this.source = source;
        marked = new boolean[graph.V()];
        edgeTo = new int[graph.V()];
        dfs(source);
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        Stack<Integer> stack = new Stack<>();
        for (int node = v; node != source; node = edgeTo[node]) {
            stack.push(node);
        }
        stack.push(source);
        return stack;
    }

    private void dfs(int s) {
        marked[s] = true;
        for (int n: graph.adj(s)) {
            if (!marked[n]) {
                dfs(n);
                edgeTo[n] = s;
            }
        }
    }
}
