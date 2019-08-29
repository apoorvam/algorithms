package graphs;

import org.junit.Test;

import static org.junit.Assert.*;

public class ConnectedComponentTest {

    @Test
    public void isConnected() {
        Graph graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(2, 3);
        ConnectedComponent cc = new ConnectedComponent(graph);

        assertEquals(3, cc.numberOfComponents());
        assertTrue(cc.isConnected(0, 1));
        assertTrue(cc.isConnected(2, 3));
        assertFalse(cc.isConnected(0, 3));
        assertFalse(cc.isConnected(0, 2));
        assertFalse(cc.isConnected(1, 3));
        assertFalse(cc.isConnected(1, 2));
        assertFalse(cc.isConnected(1, 4));
        assertFalse(cc.isConnected(2, 4));
    }
}