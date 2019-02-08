package sorting;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

/*
* Selection: Given an array of N items, find k-th smallest item. Min k = 1, Max k = N
* Based on quick select, a modification of quick sort.
*
* Time Complexity: Linear time in average case. But quadratic in worst case.
* */
public class QuickSelect {

    public static void main(String[] args) {
        int count = Integer.parseInt(StdIn.readLine());
        int[] arr = new int[count];
        for (int i = 0; i < count; i++)
            arr[i] = Integer.parseInt(StdIn.readString());
        int k = Integer.parseInt(StdIn.readString());
        if (k < 1 || k > arr.length) throw new IllegalArgumentException("Index out of range");

        System.out.println(findKthTopElement(arr, k));
    }

    public static int findKthTopElement(int[] arr, int kthNumber) {
        StdRandom.shuffle(arr);
        return quickSelect(arr, kthNumber - 1, 0, arr.length - 1);
    }

    private static int quickSelect(int[] arr, int k, int low, int high) {
        while (low < high) {
            int partitionIndex = partition(arr, low, high);
            if (k == partitionIndex) return arr[k];
            if (k < partitionIndex) high = partitionIndex - 1;
            else low = partitionIndex + 1;
        }
        return arr[k];
    }

    private static int partition(int[] arr, int low, int high) {
        int i = low, j = high + 1;

        while (true) {
            while (arr[++i] < arr[low]) if (i == high) break;
            while (arr[--j] > arr[low]) if (j == low) break;

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

}
