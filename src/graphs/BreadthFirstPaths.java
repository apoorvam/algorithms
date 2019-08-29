package graphs;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

// BreadthFirstPaths implements BFS for graph traversal
public class BreadthFirstPaths implements GraphPaths{
    private Graph graph;
    private boolean[] marked;
    private int[] edgeTo;
    private int source;

    public BreadthFirstPaths(Graph graph, int source) {
        this.graph = graph;
        marked = new boolean[graph.V()];
        edgeTo = new int[graph.V()];
        this.source = source;
        bfs();
    }

    private void bfs() {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(source);
        marked[source] = true;
        while(!queue.isEmpty()) {
            Integer node = queue.dequeue();
            for (Integer i : graph.adj(node)) {
                if (!marked[i]) {
                    marked[i] = true;
                    queue.enqueue(i);
                    edgeTo[i] = node;
                }
            }
        }
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

}
