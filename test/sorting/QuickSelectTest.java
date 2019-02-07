package sorting;

import org.junit.Test;

import static org.junit.Assert.*;

public class QuickSelectTest {

    @Test
    public void findTopKthElement() {
        int[] arr = {5, 6, 3, 1, 2, 4};

        assertEquals(3, QuickSelect.findKthTopElement(arr, 3));
        assertEquals(1, QuickSelect.findKthTopElement(arr, 1));
        assertEquals(6, QuickSelect.findKthTopElement(arr, 6));
    }

    @Test
    public void findTopKthElementWithDuplicates() {
        int[] arr = {5, 6, 3, 1, 2, 4, 1, 1, 3};

        assertEquals(1, QuickSelect.findKthTopElement(arr, 3));
        assertEquals(1, QuickSelect.findKthTopElement(arr, 1));
        assertEquals(3, QuickSelect.findKthTopElement(arr, 6));
        assertEquals(6, QuickSelect.findKthTopElement(arr, 9));
    }

}