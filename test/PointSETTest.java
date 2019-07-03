import edu.princeton.cs.algs4.Point2D;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PointSETTest {

    @Test
    public void testPointSetInit() {
        PointSET set = new PointSET();

        assertTrue(set.isEmpty());
        assertEquals(0, set.size());

        set.insert(new Point2D(1, 2));

        assertFalse(set.isEmpty());
        assertEquals(1, set.size());
    }

    @Test
    public void testPointSetContains() {
        PointSET set = new PointSET();

        assertFalse(set.contains(new Point2D(1, 2)));
        set.insert(new Point2D(1, 2));
        assertTrue(set.contains(new Point2D(1, 2)));

        assertFalse(set.contains(new Point2D(2, 2)));
        set.insert(new Point2D(2, 2));
        assertTrue(set.contains(new Point2D(2, 2)));
        assertTrue(set.contains(new Point2D(1, 2)));
    }


}