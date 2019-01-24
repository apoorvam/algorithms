import org.junit.Test;

import static org.junit.Assert.*;

public class RandomizedQueueTest {
    @Test
    public void queueAndDeque() {
        RandomizedQueue<String> q = new RandomizedQueue<String>();

        q.enqueue("A");
        q.enqueue("B");

        assertEquals(2, q.size());
        assertFalse(q.isEmpty());
        assertTrue("AB".contains(q.dequeue()));
        assertTrue("AB".contains(q.dequeue()));
        assertTrue(q.isEmpty());

        q.enqueue("A");

        assertEquals("A", q.dequeue());
    }

    @Test
    public void dequeue() {
        RandomizedQueue<String> q = new RandomizedQueue<String>();
        q.enqueue("A");
        q.enqueue("B");
        q.enqueue("C");
        q.enqueue("D");
        q.enqueue("E");

        assertEquals(5, q.size());
        for (int i = 0; i < 5; i++) {
            assertTrue("ABCDE".contains(q.dequeue()));
        }
        assertTrue(q.isEmpty());
    }

    @Test
    public void sample() {
        RandomizedQueue<String> q = new RandomizedQueue<String>();
        q.enqueue("A");
        q.enqueue("B");
        q.enqueue("C");
        q.enqueue("D");

        for (int i = 0; i < 20; i++) {
            assertTrue("ABCD".contains(q.sample()));
        }
    }

    @Test
    public void iterator() {
        RandomizedQueue<String> q = new RandomizedQueue<String>();
        q.enqueue("A");
        q.enqueue("B");
        q.enqueue("C");
        q.enqueue("D");

        for (String item : q) {
            assertTrue("ABCD".contains(item));
        }
    }

}