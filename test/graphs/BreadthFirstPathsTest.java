package graphs;

import org.junit.Test;

import static org.junit.Assert.*;

public class BreadthFirstPathsTest {

    @Test
    public void hasPathToForEmptyGraph() {
        Graph graph = new Graph(5);

        BreadthFirstPaths paths = new BreadthFirstPaths(graph, 0);

        assertTrue(paths.hasPathTo(0));
        assertFalse(paths.hasPathTo(3));
    }

    @Test
    public void hasPathTo() {
        Graph graph = new Graph(5);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(0, 1);

        BreadthFirstPaths paths = new BreadthFirstPaths(graph, 0);

        assertFalse(paths.hasPathTo(3));
        assertTrue(paths.hasPathTo(1));
        assertTrue(paths.hasPathTo(4));
        assertTrue(paths.hasPathTo(2));
        assertTrue(paths.hasPathTo(0));
    }

    @Test
    public void pathTo() {
        Graph graph = new Graph(5);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(0, 1);

        BreadthFirstPaths paths = new BreadthFirstPaths(graph, 0);

        assertEquals("0 1 4 ", paths.pathTo(4).toString());
        assertEquals("0 ", paths.pathTo(0).toString());
        assertEquals(null, paths.pathTo(3));
    }

}