import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.StdDraw;

import java.util.ArrayList;
import java.util.List;

/*
KdTree uses a 2d-tree.
A 2d-tree is a generalization of a BST to two-dimensional keys. The idea is to build a BST with points in the nodes, using the x- and y-coordinates of the points as keys in strictly alternating sequence.

Details: https://coursera.cs.princeton.edu/algs4/assignments/kdtree/specification.php
 */
public class KdTree {

    private Node root;

    private class Node {
        private final Point2D point;
        private final RectHV rect;
        private final int level;
        private Node left, right;
        private int size;

        public Node(Point2D point, RectHV rect, int level) {
            this.point = point;
            this.rect = rect;
            this.level = level;
            this.size = 1;
        }

        public double compare(Point2D anotherPoint) {
            if (level % 2 == 0) {
                return anotherPoint.x() - this.point.x();
            } else {
                return anotherPoint.y() - this.point.y();
            }
        }

        public boolean isInsideOf(final RectHV rectToCheck) {
            if (level % 2 == 0) {
                return rectToCheck.xmin() <= point.x() && point.x() <= rectToCheck.xmax();
            } else {
                return rectToCheck.ymin() <= point.y() && point.y() <= rectToCheck.ymax();
            }
        }

        public boolean isRightOf(final RectHV rectToCheck) {
            if (level % 2 == 0) {
                return rectToCheck.xmin() < point.x() && rectToCheck.xmax() < point.x();
            } else {
                return rectToCheck.ymin() < point.y() && rectToCheck.ymax() < point.y();
            }
        }
    }

    // construct an empty set of points
    public KdTree() {
    }

    // is the set empty?
    public boolean isEmpty() {
        return size() == 0;
    }

    // number of points in the set
    public int size() {
        return size(root);
    }

    // add the point to the set (if it is not already in the set)
    public void insert(Point2D p) {
        handleNull(p);
        root = put(root, p, 0, new RectHV(0, 0, 1, 1));
    }

    private Node put(Node node, Point2D pointToPut, int level, RectHV rect) {
        if (node == null) {
            return new Node(pointToPut, rect, level);
        }
        RectHV rectLeft = null;
        RectHV rectRight = null;
        double cmp = node.compare(pointToPut);
        if (cmp < 0 && node.left == null) {
            if (level % 2 == 0)
                rectLeft = new RectHV(node.rect.xmin(), node.rect.ymin(), node.point.x(), node.rect.ymax());
            else
                rectLeft = new RectHV(node.rect.xmin(), node.rect.ymin(), node.rect.xmax(), node.point.y());
        } else if (cmp >= 0 && node.right == null) {
            if (level % 2 == 0)
                rectRight = new RectHV(node.point.x(), node.rect.ymin(), node.rect.xmax(), node.rect.ymax());
            else
                rectRight = new RectHV(node.rect.xmin(), node.point.y(), node.rect.xmax(), node.rect.ymax());
        }
        if (cmp < 0) node.left = put(node.left, pointToPut, level + 1, rectLeft);
        else if (cmp > 0) node.right = put(node.right, pointToPut, level + 1, rectRight);
        else if (!pointToPut.equals(node.point)) node.right = put(node.right, pointToPut, level + 1, rectRight);
        node.size = 1 + size(node.left) + size(node.right);
        return node;
    }

    private int size(Node node) {
        if (node == null) return 0;
        return node.size;
    }

    private void handleNull(Point2D p) {
        if (p == null) {
            throw new IllegalArgumentException("Null point");
        }
    }


    // does the set contain point p?
    public boolean contains(Point2D p) {
        handleNull(p);
        return get(root, p) != null;
    }

    private Point2D get(Node node, Point2D point) {
        if (node == null) return null;
        double cmp = node.compare(point);
        if (cmp < 0) return get(node.left, point);
        else if (cmp > 0) return get(node.right, point);
        else if (!point.equals(node.point)) return get(node.right, point);
        return node.point;
    }

    // draw all points to standard draw
    public void draw() {
        draw(root);
    }

    private void draw(Node nodeToDraw) {
        if (nodeToDraw == null) return;
        StdDraw.point(nodeToDraw.point.x(), nodeToDraw.point.y());
        draw(nodeToDraw.left);
        draw(nodeToDraw.right);
    }

    // all points that are inside the rectangle (or on the boundary)
    public Iterable<Point2D> range(RectHV rect) {
        if (rect == null) throw new IllegalArgumentException("Rectangle cannot be null");
        return range(rect, root);
    }

    private List<Point2D> range(RectHV rect, Node node) {
        List<Point2D> points = new ArrayList<>();
        if (node == null) return points;
        if (node.isInsideOf(rect)) {
            if (rect.contains(node.point)) points.add(node.point);
            points.addAll(range(rect, node.left));
            points.addAll(range(rect, node.right));
        } else {
            if (node.isRightOf(rect)) return range(rect, node.left);
            else return range(rect, node.right);
        }
        return points;
    }

    // a nearest neighbor in the set to point p; null if the set is empty
    public Point2D nearest(Point2D queryPoint) {
        handleNull(queryPoint);
        if (root == null) return null;
        return nearest(root, queryPoint, root.point);
    }

    private Point2D nearest(Node node, Point2D p, Point2D mp) {
        Point2D min = mp;

        if (node == null)    return min;
        if (p.distanceSquaredTo(node.point) < p.distanceSquaredTo(min))
            min = node.point;

        if (node.level % 2 == 0) {
            if (node.point.x() < p.x()) {
                min = nearest(node.right, p, min);
                if (node.left != null && (min.distanceSquaredTo(p) > node.left.rect.distanceSquaredTo(p)))
                    min = nearest(node.left, p, min);
            } else {
                min = nearest(node.left, p, min);
                if (node.right != null && (min.distanceSquaredTo(p) > node.right.rect.distanceSquaredTo(p)))
                    min = nearest(node.right, p, min);
            }
        } else {
            if (node.point.y() < p.y()) {
                min = nearest(node.right, p, min);
                if (node.left != null && (min.distanceSquaredTo(p) > node.left.rect.distanceSquaredTo(p)))
                    min = nearest(node.left, p, min);
            } else {
                min = nearest(node.left, p, min);
                if (node.right != null && (min.distanceSquaredTo(p) > node.right.rect.distanceSquaredTo(p)))
                    min = nearest(node.right, p, min);
            }
        }
        return min;
    }

}
