import org.junit.Test;

import static org.junit.Assert.*;

public class DequeTest {
    @Test
    public void addFirstRemoveFirst() {
        Deque<String> deck = new Deque<String>();

        deck.addFirst("A");
        deck.addFirst("B");
        deck.addFirst("C");

        assertEquals(deck.size(), 3);
        assertEquals(deck.removeFirst(), "C");
        assertEquals(deck.size(), 2);
        assertEquals(deck.removeFirst(), "B");
        assertEquals(deck.size(), 1);
        assertEquals(deck.removeFirst(), "A");
        assertEquals(deck.size(), 0);
    }

    @Test
    public void addLastRemoveLast() {
        Deque<String> deck = new Deque<String>();

        deck.addLast("A");
        deck.addLast("B");
        deck.addLast("C");

        assertEquals(deck.size(), 3);
        assertEquals(deck.removeFirst(), "A");
        assertEquals(deck.size(), 2);
        assertEquals(deck.removeFirst(), "B");
        assertEquals(deck.size(), 1);
        assertEquals(deck.removeFirst(), "C");
        assertEquals(deck.size(), 0);
    }

    @Test
    public void removeFirst() {
        Deque<String> deck = new Deque<String>();

        deck.addLast("A");
        deck.addFirst("B");
        deck.addFirst("C");
        deck.addLast("D");

        assertEquals(deck.removeFirst(), "C");
        assertEquals(deck.removeFirst(), "B");
        assertEquals(deck.removeFirst(), "A");
        assertEquals(deck.removeFirst(), "D");
    }

    @Test
    public void addLastRemoveFirst() {
        Deque<String> deck = new Deque<String>();

        deck.addLast("D");

        assertEquals(deck.removeFirst(), "D");
    }

    @Test
    public void addFirstRemoveLast() {
        Deque<String> deck = new Deque<String>();

        deck.addFirst("D");

        assertEquals(deck.removeLast(), "D");
    }

    @Test
    public void testRandomOrder() {
        Deque<String> deck = new Deque<String>();

        deck.addFirst("D");
        assertEquals(deck.removeLast(), "D");

        deck.addLast("A");
        assertEquals(deck.removeFirst(), "A");

        deck.addLast("A");
        assertEquals(deck.removeFirst(), "A");

        deck.addLast("A");
        deck.addLast("B");
        assertEquals(deck.removeFirst(), "A");
        assertEquals(deck.removeFirst(), "B");

        deck.addLast("A");
        deck.addFirst("C");
        deck.addLast("B");
        assertEquals(deck.removeFirst(), "C");
        assertEquals(deck.removeLast(), "B");
        assertEquals(deck.removeLast(), "A");
    }

    @Test
    public void testIteratorForFirstToLast() {
        Deque<String> deck = new Deque<String>();

        deck.addFirst("D");
        deck.addLast("A");
        deck.addLast("B");
        deck.addLast("C");

        String result = "";
        for (String item : deck) {
            result += item;
        }
        assertEquals("DABC", result);
    }

}