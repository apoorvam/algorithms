import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

/*
* Knuth Shuffle - in each iteration, pick integer r between 0 and i uniformly at random. Swap elements at position r and i.
* 
* Time Complexity: Linear
*/
public class KnuthShuffle {

    public static void main(String[] args) {
        int count = Integer.parseInt(StdIn.readLine());
        Object[] arr = new Object[count];
        for (int i = 0; i < count; i++)
            arr[i] = Integer.parseInt(StdIn.readString());

        shuffle(arr);

        for (int i = 0; i < count; i++)
            System.out.println(arr[i]);
    }

    public static void shuffle(Object[] a) {
        for (int i = 0; i < a.length; i++) {
            int rand = StdRandom.uniform(i + 1);
            swap(a, i, rand);
        }
    }

    private static void swap(Object[] arr, int i1, int i2) {
        Object swap = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = swap;
    }

}