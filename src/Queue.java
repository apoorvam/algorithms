/*
Queue is an implementation of Queue DataStructure using linked lists. Uses generic type to be able to stack objects of any type.
*/
public class Queue<Item> {
    private class Node {
        Item item;
        Node next;
    }

    private Node first, last;

    public void enqueue(Item text) {
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
    }

    public Item dequeue() {
        Item dequeuedItem = first.item;
        first = first.next;
        if (isEmpty()) last = null;
        return dequeuedItem;
    }

    public boolean isEmpty() {
        return first == null;
    }

}
