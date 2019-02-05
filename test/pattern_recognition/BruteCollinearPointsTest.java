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

        assertEquals(5, segments.length);
    }


    @Test
    public void segmentsWithPointsLessThanFour() {
        Point[] points = {
                new Point(10, 10),
                new Point(20, 10),
        };

        LineSegment[] segments = new BruteCollinearPoints(points).segments();

        assertEquals(0, segments.length);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsIllegalArgForNullPoint() {
        Point[] points = {
                new Point(10, 10),
                new Point(20, 10),
                null,
        };

        new BruteCollinearPoints(points);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsIllegalArgForNullArg() {
        Point[] points = null;

        new BruteCollinearPoints(points);
    }

}