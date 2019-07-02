import edu.princeton.cs.algs4.StdIn;

public class SweepLine {
    private static final boolean LEFT_END = true;
    private static final boolean RIGHT_END = false;
    private static final boolean HORIZONTAL = true;
    private static final boolean VERTICAL = false;

    private static class Point {
        private int x;
        private int y;
        private boolean startEnd;
        private boolean orientation;

        public Point(int x, int y, boolean startEnd, boolean orientation) {
            this.x = x;
            this.y = y;
            this.startEnd = startEnd;
            this.orientation = orientation;
        }
    }
    public static void main(String[] args) {
        Point[] points = new Point[] {
                new Point(0, 0, LEFT_END, HORIZONTAL),
                new Point(0, 9, RIGHT_END, HORIZONTAL),
                new Point(1, 2, LEFT_END, HORIZONTAL),
                new Point(5, 2, RIGHT_END, HORIZONTAL),
                new Point(2, 4, LEFT_END, HORIZONTAL),
                new Point(3, 4, RIGHT_END, HORIZONTAL),
                new Point(4, 2, LEFT_END, HORIZONTAL),
                new Point(4, 4, RIGHT_END, VERTICAL),
        };

        BST tree = new BST();
        for (Point p : points) {


        }

    }
}
