package sorting;

import org.junit.Test;

import static org.junit.Assert.*;

public class QuickTest {
    @Test
    public void sort() {
        int[] arr = {5, 6, 3, 1, 2};
        int[] sorted = {1, 2, 3, 5, 6};

        Quick.sort(arr);

        assertArrayEquals(sorted, arr);
    }

    @Test
    public void sortWithDuplicates() {
        int[] arr = {5, 6, 3, 1, 2, 1, 1, 3};
        int[] sorted = {1, 1, 1, 2, 3, 3, 5, 6};

        Quick.sort(arr);

        assertArrayEquals(sorted, arr);
    }

}