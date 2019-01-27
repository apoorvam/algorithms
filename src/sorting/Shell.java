import edu.princeton.cs.algs4.StdIn;

/*
* Shell sort's idea is to move elements more than one position using an incremental sequence like powers of 2 minus 1, 3x+1, etc.
* Element at position i is compared with element at i+h, where is 7 in case of 7-sort and swapped if out of order. 
* 1-sort is like a insertion sort. Instead of comparing with element left of it, we compare with elements at distance in multiples of h left of element i.
*/
public class Shell {
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
    	int h = 1;
    	int N = arr.length;
    	while(h <= N) h = 3*h + 1; // 3x+1 increment sequence

    	while (h > 0) {
    		// h-sort the array
    		for (int i = h; i < N; i ++) {
    			for (int j = i; j >= h && less(arr[j], arr[j-h]); j -= h) {
    				swap(arr, j, j-h);
    			}
    		}

    		//get next value of increment
    		h = h/3;
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