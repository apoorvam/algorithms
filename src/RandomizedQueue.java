import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

/*
* A randomized queue is similar to a stack or queue, except that the item removed is chosen uniformly at random from
* items in the data structure.
* */
public class RandomizedQueue<Item> implements Iterable<Item> {

    private int size = 0;

    @Override
    public Iterator<Item> iterator() {
        return new RandomQueueIterator();
    }

    private class Node {
        Item item;
        Node next;
    }

    private class RandomQueueIterator implements Iterator<Item> {
        private Item[] items;
        private int index = 0;

        public RandomQueueIterator() {
            items = (Item[]) new Object[size];
            Node current = first;
            for (int i = 0; i < size; i++) {
                items[i] = current.item;
            }
            StdRandom.shuffle(items);
        }

        @Override
        public boolean hasNext() {
            return index < items.length;
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException("Empty queue");
            return items[index++];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Remove operation not supported");
        }
    }

    private Node first, last;

    public RandomizedQueue(){}

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void enqueue(Item text) {
        if (text == null) throw new IllegalArgumentException("Argument invalid");
        Node oldLast = last;
        Node n = new Node();
        n.item = text;
        n.next = null;
        if (isEmpty()) {
            first = n;
            last = n;
        } else {
            oldLast.next = n;
            last = n;
        }
        size++;
    }

    public Item dequeue() {
        Node previous = samplePrevItem();
        assertNotEmpty();
        if (size-- == 1) {
            Item item = first.item;
            first = null;
            last = null;
            return item;
        }
        if (previous == null) {
            Node current = first;
            first = current.next;
            return current.item;
        }
        Node current = previous.next;
        previous.next = current.next;
        return current.item;
    }

    private void assertNotEmpty() {
        if (isEmpty()) throw new NoSuchElementException("Empty queue");
    }

    public Item sample() {
        assertNotEmpty();
        if (size == 1) return first.item;
        Node prev = samplePrevItem();
        Node sample;
        if (prev == null) sample = first;
        else sample = prev.next;
        return sample.item;
    }

    private Node samplePrevItem() {
        int rand = StdRandom.uniform(0, size);
        Node current = first;
        Node previous = null;
        for (int i = 0; i < rand; i++) {
            previous = current;
            current = current.next;
        }
        return previous;
    }

}
