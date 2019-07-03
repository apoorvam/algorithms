import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.SET;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdDraw;

/*
PointSET represents a set of points in the unit square
Details: https://coursera.cs.princeton.edu/algs4/assignments/kdtree/specification.php
 */
public class PointSET {
    private final SET<Point2D> set;

    // construct an empty set of points
    public PointSET() {
        set = new SET<>();
    }

    // is the set empty?
    public boolean isEmpty() {
        return set.isEmpty();
    }

    // number of points in the set
    public int size() {
        return set.size();
    }

    // add the point to the set (if it is not already in the set)
    public void insert(Point2D p) {
        handleNull(p);
        set.add(p);
    }

    private void handleNull(Point2D p) {
        if (p == null) {
            throw new IllegalArgumentException("Null argument");
        }
    }


    // does the set contain point p?
    public boolean contains(Point2D p) {
        handleNull(p);
        return set.contains(p);
    }

    // draw all points to standard draw
    public void draw() {
        StdDraw.setPenColor(StdDraw.BLACK);

        for (Point2D p : set)
            StdDraw.point(p.x(), p.y());

        StdDraw.show();
    }

    // all points that are inside the rectangle (or on the boundary)
    public Iterable<Point2D> range(RectHV rect) {
        if (rect == null) throw new IllegalArgumentException("Rect cannot be null");
        Stack<Point2D> stack = new Stack<>();
        for (Point2D p : set) {
            if (rect.contains(p)) {
                stack.push(p);
            }
        }
        return stack;
    }

    // a nearest neighbor in the set to point p; null if the set is empty
    public Point2D nearest(Point2D p) {
        handleNull(p);
        if (set.isEmpty()) return null;

        double minDistance = Double.POSITIVE_INFINITY;
        Point2D nearestPt = null;
        for (Point2D p1 : set) {
            double dist = p.distanceSquaredTo(p1);
            if (dist < minDistance) {
                minDistance = dist;
                nearestPt = p1;
            }
        }
        return nearestPt;
    }

}
