package sheet.stack_and_queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class P14ImplementStackUsingDequeue {
    private final Deque<Integer> deque;

    public P14ImplementStackUsingDequeue() {
        deque = new ArrayDeque<>();
    }

    // Main method to test the stack implementation
    public static void main(String[] args) {
        P14ImplementStackUsingDequeue stack = new P14ImplementStackUsingDequeue();

        // Push elements onto the stack
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Current top: " + stack.top()); // Should print 30
        System.out.println("Popping top: " + stack.pop()); // Should print and remove 30
        System.out.println("New top: " + stack.top());     // Should print 20
        System.out.println("Is stack empty? " + stack.isEmpty()); // Should print false

        // Pop remaining elements
        stack.pop();
        stack.pop();
        System.out.println("Is stack empty now? " + stack.isEmpty()); // Should print true
    }

    // Push element x onto stack
    public void push(int x) {
        deque.addFirst(x);
    }

    // Removes the element on top of the stack
    public int pop() {
        return deque.removeFirst();
    }

    // Get the top element
    public int top() {
        return deque.peekFirst();
    }

    // Return whether the stack is empty
    public boolean isEmpty() {
        return deque.isEmpty();
    }
}

