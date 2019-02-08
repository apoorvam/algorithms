import java.util.Scanner;

/*
This is a brute force algorithm to find the three sum that's zero. Uses a triple loop with all combinations of numbers
to find the set which sums to zero.

Complexity: Cubic
Detail: NC3 loops => 3 array access per loop
        ~ 1/2 N^3 array accesses

*/
public class ThreeSumBF {

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
        int count = 0;
        int N = nums.length;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        count++;
                    }
                }

            }
        }
        return count;
    }
}
