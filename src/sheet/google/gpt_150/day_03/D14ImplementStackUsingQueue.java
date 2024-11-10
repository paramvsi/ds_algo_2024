package sheet.google.gpt_150.day_03;


import java.util.LinkedList;
import java.util.Queue;

public class D14ImplementStackUsingQueue {

    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    public D14ImplementStackUsingQueue() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public static void main(String[] args) {
        D14ImplementStackUsingQueue stack = new D14ImplementStackUsingQueue();

        stack.push(1);
        stack.push(2);
        System.out.println("Top element: " + stack.top()); // Output: 2
        System.out.println("Popped element: " + stack.pop()); // Output: 2
        System.out.println("Is stack empty? " + stack.empty()); // Output: false
    }

    public void push(int x) {
        // Step 1: Add new element to queue2
        queue2.add(x);

        // Step 2: Move all elements from queue1 to queue2
        while (!queue1.isEmpty()) {
            queue2.add(queue1.remove());
        }

        // Step 3: Swap queue1 and queue2
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    public int pop() {
        // Remove and return the front element from queue1
        return queue1.remove();
    }

    public int top() {
        // Return the front element from queue1
        return queue1.peek();
    }

    public boolean empty() {
        // Check if queue1 is empty
        return queue1.isEmpty();
    }
}

