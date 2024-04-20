package sheet.stack_and_queue;

import java.util.LinkedList;
import java.util.Queue;

public class P13ImplementStackUsingQueue {
    Queue<Integer> queue;

    public P13ImplementStackUsingQueue() {
        queue = new LinkedList<>();
    }

    public static void main(String[] args) {
        P13ImplementStackUsingQueue stack = new P13ImplementStackUsingQueue();

        // Push elements onto the stack
        System.out.println("Pushing 1 onto the stack.");
        stack.push(1);
        System.out.println("Top element: " + stack.top());  // Should show 1

        System.out.println("Pushing 2 onto the stack.");
        stack.push(2);
        System.out.println("Top element: " + stack.top());  // Should show 2

        System.out.println("Pushing 3 onto the stack.");
        stack.push(3);
        System.out.println("Top element: " + stack.top());  // Should show 3

        // Pop elements from the stack
        System.out.println("Popping top element: " + stack.pop());  // Should remove 3
        System.out.println("Top element now: " + stack.top());      // Should show 2

        System.out.println("Popping top element: " + stack.pop());  // Should remove 2
        System.out.println("Top element now: " + stack.top());      // Should show 1

        // Check if stack is empty
        System.out.println("Is the stack empty? " + stack.empty()); // Should return false
        stack.pop();  // Removing the last element
        System.out.println("Is the stack empty now? " + stack.empty()); // Should return true
    }

    // Push element x onto stack
    public void push(int x) {
        queue.add(x);
        int size = queue.size();
        // Rotate the queue to put the element at the front
        while (size > 1) {
            queue.add(queue.remove());
            size--;
        }
    }

    // Removes the element on top of the stack
    public int pop() {
        return queue.remove();
    }

    // Get the top element
    public int top() {
        return queue.peek();
    }

    // Return whether the stack is empty
    public boolean empty() {
        return queue.isEmpty();
    }
}

