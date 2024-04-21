package sheet.stack_and_queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class P18ReverseFirstKElementsOfQueue {

    // Function to print the queue
    public static void printQueue(Queue<Integer> queue) {
        for (Integer item : queue) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    // Function to reverse the first k elements of the given queue
    public static void reverseFirstKElements(Queue<Integer> queue, int k) {
        if (queue.isEmpty() || k > queue.size())
            return; // Check if the queue is empty or k is more than queue size
        if (k <= 0)
            return; // Nothing to reverse if k is 0 or negative

        Stack<Integer> stack = new Stack<>();

        // Push the first k elements into a stack
        for (int i = 0; i < k; i++) {
            stack.push(queue.poll());
        }

        // Enqueue the stack contents back to the queue
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }

        // Remove the elements that are now at the front and put them back at the rear of the queue
        // This is to maintain the order of the non-reversed elements
        int size = queue.size();
        for (int i = 0; i < size - k; i++) {
            queue.add(queue.poll());
        }
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(6);
        queue.add(7);

        int k = 4; // Number of elements to reverse

        System.out.println("Original Queue:");
        printQueue(queue);

        reverseFirstKElements(queue, k);

        System.out.println("Queue after reversing the first " + k + " elements:");
        printQueue(queue);
    }
}

