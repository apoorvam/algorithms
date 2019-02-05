package pattern_recognition;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FastCollinearPoints {

    private final LineSegment[] lineSegments;

    public FastCollinearPoints(Point[] points) {
        if (points == null) throw new IllegalArgumentException("Argument cannot be null");
        validatePoints(points);

        List<LineSegment> list = new ArrayList<>();
        Point[] basePoints = points.clone();
        Arrays.sort(basePoints);

        for (int p = 0; p < basePoints.length - 3; p++) {
            Point origin = basePoints[p];
            List<Point> sortedPointsList = new ArrayList<>();
            for (int k = 0; k < p; k++) sortedPointsList.add(basePoints[k]);
            for (int i = p + 1; i < basePoints.length; i++) sortedPointsList.add(basePoints[i]);
            Point[] sortedPoints = sortedPointsList.toArray(new Point[0]);
            Arrays.sort(sortedPoints, origin.slopeOrder());

            for (int matchStart = 0; matchStart < sortedPoints.length; ) {
                int matchCurr = matchStart;
                double currentSlope = origin.slopeTo(sortedPoints[matchCurr++]);
                int count = 1;
                while (matchCurr < sortedPoints.length && currentSlope == origin.slopeTo(sortedPoints[matchCurr])) {
                    count++;
                    matchCurr++;
                }
                int matchEnd;
                if (matchCurr == sortedPoints.length) matchEnd = sortedPoints.length - 1;
                else matchEnd = matchCurr - 1;
                if (count >= 3) {
                    Point[] tempPoints = new Point[count + 1];
                    tempPoints[0] = origin;
                    for (int i = matchStart, index = 1; i <= matchEnd; i++, index++) {
                        tempPoints[index] = sortedPoints[i];
                    }
                    Arrays.sort(tempPoints);
                    if (tempPoints[0].compareTo(origin) == 0)
                        list.add(new LineSegment(origin, sortedPoints[matchEnd]));
                    matchStart = matchCurr;
                } else matchStart = matchStart + 1;
            }
        }

        lineSegments = list.toArray(new LineSegment[0]);
    }

    public int numberOfSegments() {
        return this.lineSegments.length;
    }

    public LineSegment[] segments() {
        return this.lineSegments.clone();
    }

    private void validatePoints(Point[] points) {
        for (Point p : points)
            if (p == null) throw new IllegalArgumentException("Point cannot be null");
        for (int i = 0; i < points.length; i++)
            for (int j = i + 1; j < points.length; j++)
                if (points[i].compareTo(points[j]) == 0) throw new IllegalArgumentException("Duplicate points found");
        if (points.length < 4) throw new IllegalArgumentException("Insufficient number of points");
    }

    public static void main(String[] args) {

        // read the n points from a file
        In in = new In(args[0]);
        int n = in.readInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
        }

//         draw the points
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        for (Point p : points) {
            p.draw();
        }
        StdDraw.show();

        // print and draw the line segments
        FastCollinearPoints collinear = new FastCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
    }

}
