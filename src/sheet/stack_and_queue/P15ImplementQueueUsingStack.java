package sheet.stack_and_queue;

import java.util.Stack;

public class P15ImplementQueueUsingStack {
    private final Stack<Integer> stack1; // Stack to handle enqueue operations
    private final Stack<Integer> stack2; // Stack to handle dequeue operations

    public P15ImplementQueueUsingStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public static void main(String[] args) {
        P15ImplementQueueUsingStack queue = new P15ImplementQueueUsingStack();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println("Front of queue: " + queue.peek());  // Should be 1
        System.out.println("Dequeue: " + queue.dequeue());      // Should return 1
        System.out.println("Front of queue: " + queue.peek());  // Should be 2
        System.out.println("Dequeue: " + queue.dequeue());      // Should return 2
        queue.enqueue(4);
        System.out.println("Dequeue: " + queue.dequeue());      // Should return 3
        System.out.println("Front of queue: " + queue.peek());  // Should be 4
        System.out.println("Dequeue: " + queue.dequeue());      // Should return 4
        System.out.println("Is queue empty? " + queue.isEmpty());// Should return true
    }

    // Add an item to the queue
    public void enqueue(int item) {
        stack1.push(item);
    }

    // Remove an item from the queue
    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        if (stack2.isEmpty()) {
            // Transfer elements from stack1 to stack2
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    // Get the front item from the queue
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}

