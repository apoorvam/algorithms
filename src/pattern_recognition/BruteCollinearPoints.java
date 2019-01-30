package pattern_recognition;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BruteCollinearPoints {

    private final Point[] points;
    private LineSegment[] lineSegments;

    public BruteCollinearPoints(Point[] points){
        if (points == null) throw new IllegalArgumentException("Argument cannot be null");
        Arrays.sort(points);
        validatePoints(points);

        this.points = points;
        int N = points.length;
        List<LineSegment> list = new ArrayList<>();

        for (int i = 0; i < N-3; i++) {
            for (int j = i + 1; j < N-2; j++) {
                for (int k = j + 1; k < N-1; k++) {
                    for (int l = k + 1; l < N; l++) {
                        Point p = points[i], q = points[j], r = points[k], s = points[l];
                        if (p.slopeTo(q) == q.slopeTo(r) && q.slopeTo(r) == r.slopeTo(s)) {
                            LineSegment ls = new LineSegment(p, s);
                            list.add(ls);
                        }
                    }
                }
            }
        }
        lineSegments = list.toArray(new LineSegment[0]);
    }

    private void validatePoints(Point[] points) {
        for (Point p: points)
            if (p == null) throw new IllegalArgumentException("Point cannot be null");
        for (int i = 0; i < points.length-1; i++)
            if (points[i].compareTo(points[i+1]) == 0) throw new IllegalArgumentException("Duplicate points found");
        if (points.length < 4) throw new IllegalArgumentException("Insufficient number of points");
    }

    public int numberOfSegments() {
        return this.lineSegments.length;
    }

    public LineSegment[] segments() {
        return this.lineSegments;
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
