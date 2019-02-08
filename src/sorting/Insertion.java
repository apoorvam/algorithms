package sorting;

import edu.princeton.cs.algs4.StdIn;

/*
* Insertion sort - starting from current element every consecutive element to it's left is compared. If any is less than previous one,
* they are swapped. If not, move the current element pointer to right and continue.
* 
* Time Complexity:
* Worst case: ~N^2/2 compares and swaps if array is sorted in reverse order. Otherwise, its less than quadratic time.
* Best case: Already sorted takes N-1 compares and 0 swaps. 
* Better in best and random cases when compared to Selection sort, but not in worst case.
* Better suited for partially sorted input.
*/
public class Insertion {
    public static void main(String[] args) {
        int count = Integer.parseInt(StdIn.readLine());
        Comparable[] arr = new Comparable[count];
        for (int i = 0; i < count; i++)
            arr[i] = Integer.parseInt(StdIn.readString());

        sort(arr);

        for (int i = 0; i < count; i++)
            System.out.println(arr[i]);
    }

    public static void sort(Comparable[] arr) {
        int N = arr.length;
        for (int i = 0; i < N; i++) {
            for (int j = i; j > 0; j--) {
                if (less(arr[j], arr[j - 1])) swap(arr, j, j - 1);
                else break;
            }
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