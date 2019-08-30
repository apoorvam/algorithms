package graphs;

import org.junit.Test;

import static org.junit.Assert.*;

public class EulerCycleGraphTest {

    @Test
    public void eulerCycleExists() {
        Graph graph = new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);

        assertFalse(new EulerCycleGraph(graph).eulerCycleExists());
    }

    @Test
    public void eulerCycleDoesNotExists() {
        Graph graph = new Graph(3);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);

        assertTrue(new EulerCycleGraph(graph).eulerCycleExists());
    }
}