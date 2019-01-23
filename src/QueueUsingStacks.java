/*
Implementation of queue using two stacks. inbox and outbox.
Each new item is pushed to inbox. On a pop operation element is popped from outbox if its not empty.
If empty, each element from inbox is popped and pushed to outbox. This reverses the order of stack elements, which brings
elements in original order.

Using this method, each element will be in each stack exactly once - meaning each element will be pushed twice and popped twice,
giving amortized constant time operations.

*/

public class QueueUsingStacks<Item> {

    private Stack<Item> inbox = new Stack<>();
    private Stack<Item> outbox = new Stack<>();


    public void enqueue(Item item) {
        inbox.push(item);
    }

    public Item dequeue() {
        if (outbox.isEmpty()) {
            while (!inbox.isEmpty()) {
                outbox.push(inbox.pop());
            }
        }
        return outbox.pop();
    }
}
