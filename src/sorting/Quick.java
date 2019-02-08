package sorting;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

/*
* Quick Sort
* - Shuffle array(required for performance gains)
* - Partition it such that for some index k, arr[k] is in place, all entries to left of k are smaller than arr[k] and
*   all entries to the right of k are greater than arr[k]
* - Sort each piece recursively
*
* Time Complexity:
* Best case: N lg N compares
* Worst case: N^2/2 compares (quadratic)
* Average case: ~1.39 N lg N
*
* It does more compares than merge sort, but this is faster because of less data movement.
* Quick sort is in-place, but not stable sorting algorithm.
* */
public class Quick {

    public static void main(String[] args) {
        int count = Integer.parseInt(StdIn.readLine());
        int[] arr = new int[count];
        for (int i = 0; i < count; i++)
            arr[i] = Integer.parseInt(StdIn.readString());

        sort(arr);

        for (int i = 0; i < count; i++)
            System.out.println(arr[i]);
    }

    public static void sort(int[] arr) {
        StdRandom.shuffle(arr);
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int start, int end) {
        if (end <= start) return;

        int partitionIndex = partition(arr, start, end);
        sort(arr, start, partitionIndex - 1);
        sort(arr, partitionIndex + 1, end);
    }

    private static int partition(int[] arr, int low, int high) {
        int i = low, j = high + 1;
        while (true) {
            while (less(arr[++i], arr[low])) if (i == high) break;
            while (less(arr[low], arr[--j])) if (j == low) break;
            if (i >= j) break;

            swap(arr, i, j);
        }
        swap(arr, low, j);
        return j;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static boolean less(int a, int b) {
        return a < b;
    }
}
