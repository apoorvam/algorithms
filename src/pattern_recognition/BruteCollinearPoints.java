package pattern_recognition;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BruteCollinearPoints {

    private final LineSegment[] lineSegments;

    public BruteCollinearPoints(Point[] points) {
        if (points == null) throw new IllegalArgumentException("Argument cannot be null");
        validatePoints(points);
        Point[] sortedPoints = points.clone();
        Arrays.sort(sortedPoints);

        int N = sortedPoints.length;
        List<LineSegment> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    for (int l = k + 1; l < N; l++) {
                        Point p = sortedPoints[i], q = sortedPoints[j], r = sortedPoints[k], s = sortedPoints[l];
                        if (p.slopeTo(q) == q.slopeTo(r) && q.slopeTo(r) == r.slopeTo(s) && r.slopeTo(s) == s.slopeTo(p)) {
                            list.add(new LineSegment(p, s));
                        }
                    }
                }
            }
        }
        lineSegments = list.toArray(new LineSegment[0]);
    }

    private void validatePoints(Point[] points) {
        for (Point p : points)
            if (p == null) throw new IllegalArgumentException("Point cannot be null");
        for (int i = 0; i < points.length; i++)
            for (int j = i + 1; j < points.length; j++)
                if (points[i].compareTo(points[j]) == 0) throw new IllegalArgumentException("Duplicate points found");
    }

    public int numberOfSegments() {
        return this.lineSegments.length;
    }

    public LineSegment[] segments() {
        return this.lineSegments.clone();
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

        // draw the points
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        for (Point p : points) {
            p.draw();
        }
        StdDraw.show();

        // print and draw the line segments
        BruteCollinearPoints collinear = new BruteCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
    }
}
