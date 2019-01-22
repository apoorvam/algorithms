import java.util.Scanner;

/* Implementation of Data Structure Stack of strings using linked lists.

Time complexiety: Every operation takes constant time
Space: ~40 bytes per stack node(excluding string itself): 16B object overhead, 8B each for inner object, item and next
*/
public class Stack<Item> {

    private Node first = null;
    private class Node {
        Item item;
        Node next;
    }

    private Item pop() {
        Item item = first.item;
        first = first.next;
        return item;
    }

    private boolean isEmpty() {
        return first == null;
    }

    private void push(Item line) {
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
        while(s.hasNextLine()) {
            String line = s.nextLine();
            if (line.equals("-")) {
                System.out.println(stack.pop());
            } else {
                stack.push(line);
            }
        }
    }

}
