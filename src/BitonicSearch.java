import java.util.Scanner;

/*
An array is bitonic if it is comprised of an increasing sequence of integers followed immediately by a decreasing sequence of integers.
Given a bitonic array of n distinct integer values, this determines whether a given integer is in the array.

Find max using ~ln n compares, which divides array to increasing and decreasing portions.
Now binary search ~ln n can be used to find element.
*/
public class BitonicSearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int numToFind = scanner.nextInt();
            int[] arr = {1, 2, 4, 6, 8, 10, 12, 15, 18, 14, 7, 5};

            int result = bitonicSearch(arr, numToFind);
            if (result == -1) {
                System.out.printf("Number %d not found\n", numToFind);
            } else {
                System.out.printf("Number %d is found at position %d.\n", numToFind, result + 1);
            }
        }
    }

    private static int bitonicSearch(int[] arr, int numToFind) {
        int pivot = getPivot(arr, 0, arr.length-1);
        System.out.printf("0-%d-%d\n", pivot, arr.length-1);
        int res1 = ascendingBinarySearch(arr, numToFind, 0, pivot);
        if (res1 == -1 ){
            int res2 = descendingBinarySearch(arr,numToFind, pivot+1, arr.length-1);
            if (res2 == -1) {
                return -1;
            }
            return res2;
        }
        return res1;
    }

    private static int descendingBinarySearch(int[] arr, int numToFind, int low, int high) {
        while(low <= high) {
            int mid = (low+high)/2;
            if (numToFind == arr[mid]) {
                return mid;
            }
            if (numToFind < arr[mid]) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return -1;
    }

    public static int ascendingBinarySearch(int[] arr, int givenNum, int low, int high) {
        while(low <= high) {
            int mid = (low+high)/2;
            if (givenNum == arr[mid]) {
                return mid;
            }
            if (givenNum < arr[mid]) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return -1;
    }

    public static int getPivot(int[] arr, int startIndex, int endIndex) {
        int mid = (startIndex + endIndex) / 2;
        if (startIndex == endIndex) {
            return mid;
        }
        if (arr[mid] > arr[mid - 1]) {
            if (arr[mid] > arr[mid+1]) return mid;
            return getPivot(arr, mid+1, endIndex);
        } else {
            return getPivot(arr, startIndex, mid);
        }
    }


}
