package graphs;

import org.junit.Test;

import static org.junit.Assert.*;

public class GraphTest {

    @Test
    public void addEdge() {
        Graph graph = new Graph(5);
        assertFalse(graph.isEmpty());

        graph.addEdge(1,2);
        graph.addEdge(1,0);
        graph.addEdge(2,3);

        assertFalse(graph.isEmpty());
    }

    @Test
    public void adj() {
        Graph graph = new Graph(5);
        graph.addEdge(1,2);
        graph.addEdge(1,0);
        graph.addEdge(2,3);

        for (Integer i: graph.adj(3)) {
            assertEquals(i, Integer.valueOf(2));
        }
    }
}