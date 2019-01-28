package sorting;

/*Intersection of two sets.
 Given two arrays a[] and b[], each containing n distinct 2D points in the plane, design a subquadratic algorithm
 to count the number of points that are contained both in array a[] and array b[].

 Complexiety: Shell sort O(N^3/2) + n
*/
public class ArrayIntersection {
    public static void main(String[] args) {
        Point[] A = new Point[]{new Point(1, 2), new Point(4, 5), new Point(2, 2), new Point(2, 5), new Point(3, 2)};
        Point[] B = new Point[]{new Point(4, 2), new Point(1, 5), new Point(2, 2), new Point(3, 4), new Point(3, 1), new Point(2, 5)};

        printIntersectionPoints(A, B);
    }

    private static void printIntersectionPoints(Point[] a, Point[] b) {
        Shell.sort(a);
        Shell.sort(b);

        int i = 0, j = 0, numCommmon = 0 ;
        while(i < a.length && j < b.length) {
            if (a[i].x > b[j].x) j++;
            else if (a[i].x < b[j].x) i++;
            else if (a[i].y < b[j].y) i++;
            else if (a[i].y > b[j].y) j++;
            else {
                System.out.printf("(%d, %d)\n", a[i].x, a[i].y);
                i++;
                j++;
                numCommmon++;
            }
        }
        System.out.println("Total number of intersection points: "+numCommmon);
    }


    public static class Point implements Comparable<Point>{
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point that) {
            if (this.x < that.x) return -1;
            else if (this.x > that.x) return 1;
            if (this.x == that.x) {
                if (this.y < that.y) return -1;
                else if (this.y > that.y) return 1;
            }
            return 0;
        }
    }
}
