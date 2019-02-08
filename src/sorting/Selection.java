package sorting;

import edu.princeton.cs.algs4.StdIn;

/*
* Selection sort - sorts by finding a min to the right of current position and swap with current element.
*
* Time Complexity:
* N^2 /2 compares and N swaps.
* Quadratic time irrespective of input.
* */
public class Selection {

    public static void main(String[] args) {
        int count = Integer.parseInt(StdIn.readLine());
        Comparable[] arr = new Comparable[count];
        for (int i = 0; i < count; i++)
            arr[i] = Integer.parseInt(StdIn.readString());

        sort(arr);

        for (int i = 0; i < count; i++)
            System.out.println(arr[i]);
    }

    private static void sort(Comparable[] arr) {
        int N = arr.length;
        for (int i = 0; i < N; i++) {
            int minIndex = i;
            for (int j = i + 1; j < N; j++) {
                if (less(arr[j], arr[minIndex])) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    private static void swap(Comparable[] arr, int i1, int i2) {
        Comparable swap = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = swap;
    }

    private static boolean less(Comparable i1, Comparable i2) {
        return i1.compareTo(i2) < 0;
    }
}
