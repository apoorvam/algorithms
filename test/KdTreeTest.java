import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import org.junit.Test;

import static org.junit.Assert.*;

public class KdTreeTest {

    @Test
    public void testInsert() {
        KdTree tree = new KdTree();

        assertTrue(tree.isEmpty());
        assertEquals(0, tree.size());

        tree.insert(new Point2D(0.7, 0.2));
        tree.insert(new Point2D(0.5, 0.4));
        tree.insert(new Point2D(0.2, 0.3));
        tree.insert(new Point2D(0.4, 0.7));
        tree.insert(new Point2D(0.9, 1));

        assertFalse(tree.isEmpty());
        assertEquals(5, tree.size());
    }

    @Test
    public void testInsertEdges() {
        KdTree tree = new KdTree();

        assertTrue(tree.isEmpty());
        assertEquals(0, tree.size());

        tree.insert(new Point2D(0.0, 1.0));
        tree.insert(new Point2D(0.0, 0.0));
        tree.insert(new Point2D(0.0, 0.0));

        assertFalse(tree.isEmpty());
        assertEquals(2, tree.size());
    }


    @Test
    public void testContainsGeneral() {
        KdTree tree = new KdTree();

        assertTrue(tree.isEmpty());
        assertEquals(0, tree.size());

        tree.insert(new Point2D(0.7, 0.2));
        tree.insert(new Point2D(0.5, 0.4));
        tree.insert(new Point2D(0.2, 0.3));
        tree.insert(new Point2D(0.4, 0.7));
        tree.insert(new Point2D(0.9, 0.6));

        assertFalse(tree.contains(new Point2D(0.7, 0.6)));
    }

    @Test
    public void testContains() {
        KdTree tree = new KdTree();

        assertTrue(tree.isEmpty());
        assertEquals(0, tree.size());

        tree.insert(new Point2D(0.226, 0.577));
        tree.insert(new Point2D(0.083, 0.51));
        tree.insert(new Point2D(0.372, 0.497));
        tree.insert(new Point2D(0.564, 0.413));
        tree.insert(new Point2D(0.32, 0.708));
        tree.insert(new Point2D(0.417, 0.362));
        tree.insert(new Point2D(0.862, 0.825));
        tree.insert(new Point2D(0.144, 0.179));
        tree.insert(new Point2D(0.785, 0.725));
        tree.insert(new Point2D(0.499, 0.208));

        assertFalse(tree.contains(new Point2D(0.32, 0.92)));
        assertTrue(tree.contains(new Point2D(0.32, 0.708)));
    }

    @Test
    public void testRange() {
        KdTree tree = new KdTree();

        tree.insert(new Point2D(0.226, 0.577));
        tree.insert(new Point2D(0.083, 0.51));
        tree.insert(new Point2D(0.372, 0.497));
        tree.insert(new Point2D(0.564, 0.413));

        Iterable<Point2D> list = tree.range(new RectHV(0.3, 0.3, 0.5, 0.5));
        for (Point2D p : list) {
            assertTrue(p.equals(new Point2D(0.372, 0.497)));
        }
    }


    @Test
    public void testNearest() {
        KdTree tree = new KdTree();

        tree.insert(new Point2D(0.7, 0.2));
        tree.insert(new Point2D(0.5, 0.4));
        tree.insert(new Point2D(0.2, 0.3));
        tree.insert(new Point2D(0.4, 0.7));
        tree.insert(new Point2D(0.9, 0.6));

        Point2D nearest = tree.nearest(new Point2D(0.69, 0.797));
        assertNotNull(nearest);
        assertTrue(nearest.equals(new Point2D(0.9, 0.6)));
    }


    @Test
    public void testNearestSpecialCase() {
        KdTree tree = new KdTree();

        tree.insert(new Point2D(0.625, 0.875));
        tree.insert(new Point2D(0.75, 0.0));
        tree.insert(new Point2D(0.125, 0.125));
        tree.insert(new Point2D(0.0, 0.375));
        tree.insert(new Point2D(0.25, 0.75));

        Point2D nearest = tree.nearest(new Point2D(0.375, 0.5));
        assertNotNull(nearest);
        assertTrue(nearest.equals(new Point2D(0.25, 0.75)));
    }
}