package sorting;

import edu.princeton.cs.algs4.StdIn;

/*
* Merge sort - divide array into two halves, recursively sort them, merge two halves.
* Uses divide and conquer method to sort.
*
* Time Complexity: Uses utmost N log N compares and 6N log N array accesses to sort any array.
* Space: Uses extra space proportional to N, for auxillary array.
*
* Optimization 1: Use insertion sort for array sizes ~ 7
* Optimization 2: Avoid if already sorted. If biggest element of left subarray is less than smallest element of right subarray,
* there is no need of merge.
* */
public class Merge {

    private static final int INSERTION_CUTOFF = 7;

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
        int[] aux = new int[arr.length];
        sort(arr, aux, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int[] aux, int start, int end) {
        if (end == start) return;
//      if (end == start + INSERTION_CUTOFF - 1) Insertion.sort(arr); // Opt 1
        int mid = (start + end) / 2;

        sort(arr, aux, start, mid);
        sort(arr, aux, mid + 1, end);
        if (arr[mid] <= arr[mid + 1]) return; // Opt 2
        merge(arr, aux, start, mid, end);
    }

    private static void merge(int[] arr, int[] aux, int start, int mid, int end) {
        int i = start;
        int j = mid + 1;
        int k = start;

        for (int a = start; a <= end; a++)
            aux[a] = arr[a];

        while (i <= mid && j <= end) {
            if (aux[i] <= aux[j]) {
                arr[k] = aux[i];
                i++;
            } else {
                arr[k] = aux[j];
                j++;
            }
            k++;
        }
        // copy rest of left array
        while (i <= mid) {
            arr[k] = aux[i];
            i++;
            k++;
        }
        // copy rest of right array
        while (j <= end) {
            arr[k] = aux[j];
            j++;
            k++;
        }

    }
}
