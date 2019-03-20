import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RangeSearch1DTest {
    @Test
    public void put() {
        RangeSearch1D<Integer, Integer> tree = new RangeSearch1D<>();

        tree.insert(40, null);
        tree.insert(10, null);
        tree.insert(30, null);
        tree.insert(20, null);
        tree.insert(50, null);

        assertEquals("10 20 30 40 50", tree.inorder());
    }

    @Test
    public void rangeCountWithLowKeyPresent() {
        RangeSearch1D<Integer, Integer> tree = new RangeSearch1D<>();

        tree.insert(40, null);
        tree.insert(10, null);
        tree.insert(30, null);
        tree.insert(20, null);
        tree.insert(50, null);

        assertEquals(3, tree.rangeCount(20, 45));
    }

    @Test
    public void rangeCountWithKeyNotIncluded() {
        RangeSearch1D<Integer, Integer> tree = new RangeSearch1D<>();

        tree.insert(40, null);
        tree.insert(10, null);
        tree.insert(30, null);
        tree.insert(20, null);
        tree.insert(50, null);

        assertEquals(3, tree.rangeCount(15, 45));
    }


}