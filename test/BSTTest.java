import org.junit.Test;

import static org.junit.Assert.*;

public class BSTTest {
    @Test
    public void put() {
        BST<Integer, Integer> tree = new BST<>();

        tree.put(40, null);
        tree.put(10, null);
        tree.put(30, null);
        tree.put(20, null);
        tree.put(50, null);

        assertEquals("10 20 30 40 50", tree.inorder());
        assertEquals(5, tree.size());
        assertFalse(tree.isEmpty());
    }

    @Test
    public void putDuplicateValues() {
        BST<Integer, Integer> tree = new BST<>();

        tree.put(40, null);
        tree.put(10, null);
        tree.put(30, null);
        tree.put(20, null);
        tree.put(40, null);

        assertEquals("10 20 30 40", tree.inorder());
        assertEquals(4, tree.size());
        assertFalse(tree.isEmpty());
    }

    @Test
    public void testEmptyTree() {
        BST<Integer, Integer> tree = new BST<>();

        assertEquals("", tree.inorder());
        assertEquals(0, tree.size());
        assertTrue(tree.isEmpty());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPutNullKey() {
        BST<Integer, Integer> tree = new BST<>();

        tree.put(null, null);
    }

    @Test
    public void getValue() {
        BST<Integer, Integer> tree = new BST<>();

        tree.put(40, 4);
        tree.put(10, 1);
        tree.put(30, 3);
        tree.put(30, 6);
        tree.put(50, 5);

        assertEquals((int) tree.get(50), 5);
        assertEquals((int) tree.get(10), 1);
        assertEquals((int) tree.get(30), 6);
    }

    @Test
    public void contains() {
        BST<Integer, Integer> tree = new BST<>();

        tree.put(40, 4);
        tree.put(10, 1);
        tree.put(30, 3);
        tree.put(30, 6);
        tree.put(50, 5);

        assertTrue(tree.contains(40));
        assertTrue(tree.contains(30));
        assertTrue(tree.contains(50));
        assertFalse(tree.contains(60));
        assertFalse(tree.contains(1));
    }

    @Test
    public void levelOrder() {
        BST<Integer, Integer> tree = new BST<>();

        tree.put(40, 40);
        tree.put(10, 10);
        tree.put(30, 30);
        tree.put(20, 20);
        tree.put(50, 50);
        tree.put(5, 5);
        tree.put(45, 45);
        tree.put(60, 60);

        int i = 0;
        int[] expectedOrder = {40, 10, 50, 5, 30, 45, 60, 20};
        assertEquals(expectedOrder.length, tree.size());
        for (int key : tree.levelOrder()) assertEquals(expectedOrder[i++], key);
    }

}