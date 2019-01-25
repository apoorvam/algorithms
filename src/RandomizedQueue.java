import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

/*
* A randomized queue is similar to a stack or queue, except that the item removed is chosen uniformly at random from items in the data structure.
* */
public class RandomizedQueue<Item> implements Iterable<Item>{
    private Item[] items;
    private int size = 0;

    public RandomizedQueue() {
        items = (Item[]) new Object[1];
    }

    public void enqueue(Item item) {
        if (item == null) throw new IllegalArgumentException("Argument invalid");

        if (size == items.length-1) {
            resize(items.length * 2);
        }
        items[size++] = item;
    }

    private void resize(int capacity) {
        Item[] newQ = (Item[]) new Object[capacity];
        int index = 0;
        for (int i = 0; i < size; i++) {
            newQ[index++] = items[i];
        }
        items = newQ;
    }

    public Item dequeue() {
        assertNotEmpty();
        int rand = StdRandom.uniform(0, size);
        Item item = items[rand];
        items[rand] = items[size-1];
        items[size-1] = null;
        size--;
        if (size == items.length/4) resize(items.length/2);
        return item;
    }


    private void assertNotEmpty() {
        if (isEmpty()) throw new NoSuchElementException("Empty queue");
    }

    public Item sample() {
        assertNotEmpty();
        int rand = StdRandom.uniform(0, size);
        return items[rand];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator();
    }

    private class RandomizedQueueIterator implements Iterator<Item> {
        private Item[] itItems;
        private int index = 0;

        public RandomizedQueueIterator() {
            itItems = (Item[]) new Object[size];
            for (int i = 0; i < size; i++) {
                itItems[i] = items[i];
            }
            StdRandom.shuffle(itItems);
        }

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException("Empty queue");
            return itItems[index++];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Remove operation not supported");
        }
    }
}
