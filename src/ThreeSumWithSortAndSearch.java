import java.util.Arrays;
import java.util.Scanner;

/*
ThreeSumWithSortAndSearch is a approach to solve three sum problem, with a solution better than brute force method.
It uses sort, say quick sort to sort the numbers first. For every combination of two numbers in array, -(two numbers)
which has to be third number is found using binary search.

Complexity:

Sort: n ln n OR n^2
Binary Search: ln n
Total : n ln n + n^2*(ln n) OR n^2 + n^2 * ln n
*/
public class ThreeSumWithSortAndSearch {

    public static void Main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCount = scanner.nextInt();
        int[] nums = new int[numCount];

        for (int i = 0; i < numCount; i++) {
            nums[i] = scanner.nextInt();
        }

        System.out.println(threeSumOfZero(nums));
    }

    private static int threeSumOfZero(int[] nums) {
        Arrays.sort(nums);
        int N = nums.length;
        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                int toFind = -(nums[i] + nums[j]);
                int searchRes = BinarySearch.binarySearch(nums, toFind);
                if (searchRes != -1) count++;
            }
        }
        return count;
    }

}
