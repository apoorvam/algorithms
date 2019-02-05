package pattern_recognition;

import org.junit.Test;

import static org.junit.Assert.*;

public class FastCollinearPointsTest {
    @Test
    public void segmentsWithFourHorizontalPoints() {
        Point[] points = {
                new Point(30, 10),
                new Point(20, 10),
                new Point(40, 10),
                new Point(10, 10),
        };

        LineSegment[] segments = new FastCollinearPoints(points).segments();

        assertEquals(1, segments.length);
        assertEquals("(10, 10) -> (40, 10)", segments[0].toString());
    }

    @Test
    public void segmentsWithFiveHorizontalPoints() {
        Point[] points = {
                new Point(30, 10),
                new Point(50, 10),
                new Point(10, 10),
                new Point(20, 10),
                new Point(40, 10),
        };

        LineSegment[] segments = new FastCollinearPoints(points).segments();

        assertEquals(1, segments.length);
        assertEquals("(10, 10) -> (50, 10)", segments[0].toString());
    }

    @Test
    public void segmentsWithFiveHorizontalPointsAlongWithRandomPoints() {
        Point[] points = {
                new Point(30, 10),
                new Point(50, 10),
                new Point(30, 400),
                new Point(10, 10),
                new Point(20, 10),
                new Point(40, 10),
                new Point(200, 4),
        };

        LineSegment[] segments = new FastCollinearPoints(points).segments();

        assertEquals(1, segments.length);
        assertEquals("(10, 10) -> (50, 10)", segments[0].toString());
    }

    @Test
    public void segmentsWithTwoHorizontalLines() {
        Point[] points = {
                new Point(30, 10),
                new Point(50, 10),
                new Point(10, 10),
                new Point(20, 10),
                new Point(40, 10),
                new Point(10, 50),
                new Point(20, 50),
                new Point(30, 50),
                new Point(40, 50),
        };

        LineSegment[] segments = new FastCollinearPoints(points).segments();
        for (LineSegment line : segments) {
            System.out.println(line);
        }

        assertEquals(2, segments.length);
        assertEquals("(10, 10) -> (50, 10)", segments[0].toString());
        assertEquals("(10, 50) -> (40, 50)", segments[1].toString());
    }

    @Test
    public void segmentsWithNoPointsOfCommonSlope() {
        Point[] points = {
                new Point(30, 10),
                new Point(50, 100),
                new Point(10, 10),
                new Point(20, 100),
                new Point(200, 100),
        };

        LineSegment[] segments = new FastCollinearPoints(points).segments();

        assertEquals(0, segments.length);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsIllegalArgForNullPoint() {
        Point[] points = {
                new Point(10, 10),
                new Point(20, 10),
                null,
        };

        new FastCollinearPoints(points);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsIllegalArgForNullArg() {
        Point[] points = null;

        new FastCollinearPoints(points);
    }

    @Test
    public void segmentsWithPointsLessThanFour() {
        Point[] points = {
                new Point(10, 10),
                new Point(20, 10),
        };

        LineSegment[] segments = new FastCollinearPoints(points).segments();

        assertEquals(0, segments.length);
    }

}