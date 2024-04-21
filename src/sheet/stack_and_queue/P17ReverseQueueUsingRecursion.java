package sheet.stack_and_queue;

import java.util.LinkedList;
import java.util.Queue;

public class P17ReverseQueueUsingRecursion {
    // Function to print the queue
    public static void printQueue(Queue<Integer> queue) {
        for (Integer item : queue) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    // Recursive function to reverse the queue
    public static void reverseQueue(Queue<Integer> queue) {
        if (queue.isEmpty()) {
            return; // Base case: If queue is empty, return
        }

        // Step 1: Remove the front element
        int data = queue.poll();

        // Step 2: Reverse the remaining queue recursively
        reverseQueue(queue);

        // Step 3: Add the removed item at the back of the queue
        queue.add(data);
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);

        System.out.println("Original Queue:");
        printQueue(queue);

        reverseQueue(queue);

        System.out.println("Reversed Queue:");
        printQueue(queue);
    }
}

