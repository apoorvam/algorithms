import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

/* Implementation of Data Structure Stack of strings using linked lists.

Time Complexity: Every operation takes constant time
Space: ~40 bytes per stack node(excluding string itself): 16B object overhead, 8B each for inner object, item and next
*/
public class Stack<Item> implements Iterable<Item> {

    private Node first = null;

    @Override
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            private Node current = first;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Item next() {
                if (!hasNext()) throw new NoSuchElementException("No element found");
                Item item = current.item;
                current = current.next;
                return item;
            }
        };
    }

    private class Node {
        Item item;
        Node next;
    }

    public Item pop() {
        Item item = first.item;
        first = first.next;
        return item;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void push(Item line) {
        Node oldFirst = first;
        Node newNode = new Node();
        newNode.item = line;
        newNode.next = oldFirst;
        first = newNode;
    }

    public static void main(String[] args) {
        System.out.println("Enter - to pop from stack and type word in new line to push it to stack.");
        Scanner s = new Scanner(System.in);
        Stack stack = new Stack();
        while (s.hasNextLine()) {
            String line = s.nextLine();
            if (line.equals("-")) {
                System.out.println(stack.pop());
            } else {
                stack.push(line);
            }
        }
    }

}
