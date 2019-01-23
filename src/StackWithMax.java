public class StackWithMax {

    private class Node {
        Integer item;
        Node next;
    }

    private Node first = null;
    private Integer max = null;

    public void push(Integer element) {
        Node newNode = new Node();
        newNode.item = element;
        if (isEmpty()) first = newNode;
        else {
            newNode.next = first;
            first = newNode;
        }
        if (element.compareTo(max) > 0) max = element;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public Integer pop() {
        Integer item = first.item;
        first = first.next;
        return item;
    }

    public Integer max() {
        return max;
    }

}
