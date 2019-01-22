/*
Fixed Size Stack is an implementation of stack using arrays. Downside of this approach is that capacity of stack has to be predetermined.
But this is efficient with space, compared to that of its implementation using linked lists.
However, overflow and underflow can throw exception.
*/
public class ResizableStack {

    private String[] arr;
    private int N = 0;

    public ResizableStack(int capacity) {
        arr = new String[capacity];
    }

    public void push(String item) {
        if (N == arr.length) {
            resize(2*arr.length);
        }
        arr[N++] = item;
    }

    private void resize(int capacity) {
        String[] newArr = new String[capacity];
        for (int i =0; i<arr.length; i++) newArr[i] = arr[i];
        arr = newArr;
    }

    public String pop() {
        String item = arr[--N];
        arr[N] = null;
        if (N == arr.length/4) resize(arr.length/2);
        return item;
    }

    public boolean isEmpty() {
        return N == 0;
    }
}
