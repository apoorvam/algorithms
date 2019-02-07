public class ResizableQueue {

    private String[] q;
    private int head, tail = 0;

    public ResizableQueue(int capacity) {
        q = new String[capacity];
    }

    public void enqueue(String item) {
        if (tail == q.length - 1) {
            resize(q.length * 2);
        }
        q[++tail] = item;
    }

    private void resize(int capacity) {
        String[] newQ = new String[capacity];
        int index = 0;
        for (int i = head; i <= tail; i++) {
            newQ[index++] = q[i];
        }
        tail = tail - head;
        head = 0;
        q = newQ;
    }

    public String dequeue() {
        String item = q[head];
        q[head] = null;
        if (!isEmpty()) head++;
        if (tail - head == q.length / 4) resize(q.length / 2);
        return item;
    }

    public boolean isEmpty() {
        return tail == head;
    }

}
