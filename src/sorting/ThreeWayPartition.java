package sorting;

import edu.princeton.cs.algs4.StdIn;

/*
* 3-way partitioning:
* Quick sort takes quadratic time to sort items with duplicates. 3-way partition can perform better than that. Idea is to partition array into 3 parts such that:
* - Entries between lt and gt are all equal to partition item
* - Entries to left of lt are less than partition item
* - Entries to right of gt are greater than partition item
*
* If a[lo] is partition item v,
* - a[i] < v, swap v and a[i], increment i and lt
* - a[i] > v, swap a[i] and a[gt], decrement gt
* - a[i] == v, increment i
*
* Efficiency: It is entropy optimal. Linear in many cases.
* */
public class ThreeWayPartition {

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
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int low, int high) {
        if (low >= high) return;
        int lt = low, i = low, gt = high;
        while(i <= gt) {
            if (arr[i] < arr[lt]) {
                swap(arr, lt, i);
                lt++; i++;
            } else if (arr[i] > arr[lt]) {
                swap(arr, gt, i);
                gt--;
            } else i++;
        }
        sort(arr, low, lt-1);
        sort(arr, gt+1, high);
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
