package graphs;

import org.junit.Test;

import static org.junit.Assert.*;

public class BipartiteGraphTest {

    @Test
    public void isBipartiteForDisconnectedGraph() {
        Graph graph = new Graph(5);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);

        assertFalse(new BipartiteGraph(graph).isBipartite());
    }

    @Test
    public void isBipartite() {
        Graph graph = new Graph(3);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);

        assertFalse(new BipartiteGraph(graph).isBipartite());
    }

    @Test
    public void isBipartiteSuccess() {
        Graph graph = new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 0);

        assertTrue(new BipartiteGraph(graph).isBipartite());
    }

}