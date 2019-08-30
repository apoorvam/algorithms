package graphs;

import org.junit.Test;

import static org.junit.Assert.*;

public class CyclicGraphTest {

    @Test
    public void testIsCyclic() {
        Graph graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        assertFalse(new CyclicGraph(graph).cycleExists());

        graph.addEdge(4, 2);

        assertTrue(new CyclicGraph(graph).cycleExists());

        graph.addEdge(4, 3);

        assertTrue(new CyclicGraph(graph).cycleExists());
    }
}