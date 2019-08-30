package graphs;

public class EulerCycleGraph {
    private Graph graph;

    public EulerCycleGraph(Graph graph) {
        this.graph = graph;
    }

    public boolean eulerCycleExists() {
        for (int i = 0; i < graph.V(); i++) {
            if (graph.degree(i) % 2 != 0) return false;
        }
        return true;
    }
}
