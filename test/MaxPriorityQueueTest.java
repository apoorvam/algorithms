import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

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

}