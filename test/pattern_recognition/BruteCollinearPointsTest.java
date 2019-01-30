package pattern_recognition;

import org.junit.Test;

import static org.junit.Assert.*;

public class BruteCollinearPointsTest {
    @Test
    public void segments() {
        Point[] points = {
                new Point(10, 10),
                new Point(20, 10),
                new Point(30, 10),
                new Point(40, 10),
                new Point(50, 10),
        };

        LineSegment[] segments = new BruteCollinearPoints(points).segments();

        assertEquals(2, segments.length);
        assertEquals("(10, 10) -> (40, 10)", segments[0].toString());
    }

}