package sorting;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class ThreeWayPartitionTest {
    @Test
    public void sort() throws Exception {
        int[] arr = {0, 5, 4, 3, 1, 1, 6, 6};
        int[] sorted = {0, 1, 1, 3, 4, 5, 6, 6};

        ThreeWayPartition.sort(arr);

        assertArrayEquals(sorted, arr);
    }

    @Test
    public void sortWithSameItems() throws Exception {
        int[] arr = {1, 1, 1, 1, 1, 1, 1};

        ThreeWayPartition.sort(arr);

        assertArrayEquals(arr, arr);
    }

}