import java.util.Scanner;

/*
Searches a sorted array of integers to find the given number.
If present returns the position of number, else returns -1.

Complexity:
ln n

Best case: 1
Average and worst case: ln n
*/
public class BinarySearch {

    public static int binarySearch(int[] arr, int givenNum) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (givenNum == arr[mid]) {
                return mid;
            }
            if (givenNum < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int numToFind = scanner.nextInt();
            int[] arr = {1, 2, 4, 6, 8, 10, 12, 15, 18, 19, 20, 25};

            int result = binarySearch(arr, numToFind);
            if (result == -1) {
                System.out.printf("Number %d not found\n", numToFind);
            } else {
                System.out.printf("Number %d is found at position %d.\n", numToFind, result + 1);
            }
        }
    }
}
