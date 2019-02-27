import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class MaxPriorityQueueTest {

    @Test
    public void testInsert() {
        MaxPriorityQueue q = new MaxPriorityQueue();

        q.insert("A");

        assertFalse(q.isEmpty());
    }

    @Test
    public void testDeletionOrder() {
        MaxPriorityQueue q = new MaxPriorityQueue();

        q.insert("D");
        q.insert("A");
        q.insert("E");
        q.insert("C");
        q.insert("B");


        assertEquals("E", q.deleteMax());
        assertEquals("D", q.deleteMax());
        assertEquals("C", q.deleteMax());
        assertEquals("B", q.deleteMax());
        assertEquals("A", q.deleteMax());
    }

    @Test(expected = NoSuchElementException.class)
    public void testDeleteFromEmptyQueue() {
        MaxPriorityQueue q = new MaxPriorityQueue();

        q.insert("A");

        assertEquals("A", q.deleteMax());
        q.deleteMax();
    }

    @Test
    public void testGetSample() {
        MaxPriorityQueue q = new MaxPriorityQueue();

        q.insert("C");
        q.insert("D");
        q.insert("A");
        q.insert("E");

        List expected = Arrays.asList("A", "C", "D", "E");

        for (int i = 0; i < 10; i++) assertTrue(expected.contains(q.sample()));
    }

}