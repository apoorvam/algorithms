import java.util.Iterator;
import java.util.NoSuchElementException;

/*
* A double-ended queue or deque (pronounced “deck”) is a generalization of a stack and a queue that supports adding and
* removing items from either the front or the back of the data structure.
* */
public class Deque<Item> implements Iterable<Item>{

    private int size = 0;

    private class Node {
        Node next;
        Node previous;
        Item item;
    }

    private Node first, last = null;

    public Deque() {}

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

    public void addFirst(Item item) {
        checkNull(item);
        Node newNode = new Node();
        newNode.item = item;
        newNode.next = first;
        boolean isEmpty = isEmpty();
        if (!isEmpty) first.previous = newNode;
        else last = newNode;
        first = newNode;
        size++;
    }

    public void addLast(Item item) {
        checkNull(item);
        Node newNode = new Node();
        newNode.item = item;
        boolean isEmpty = isEmpty();
        if (!isEmpty) {
            last.next = newNode;
            newNode.previous = last;
        }
        last = newNode;
        if (isEmpty) first = newNode;
        size++;
    }

    private void checkNull(Item item) {
        if (item == null) throw new IllegalArgumentException("Null argument is invalid");
    }

    private void validateNotEmpty() {
        if (isEmpty()) throw new NoSuchElementException("No element found");
    }

    public Item removeFirst() {
        validateNotEmpty();
        Item item = first.item;
        if (first.next == null) last = null;
        first = first.next;
        size--;
        return item;
    }

    public Item removeLast() {
        validateNotEmpty();
        Item item = last.item;
        if (last.previous != null) last = last.previous;
        else {
            last = null;
            first = null;
        }
        size--;
        return item;
    }

    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            private Node current = first;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Item next() {
                if (current == null) throw new NoSuchElementException("No element found");
                Item item = current.item;
                current = current.next;
                return item;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("Operation not supported");
            }
        };
    }

    public static void main(String[] args) {

    }

}
