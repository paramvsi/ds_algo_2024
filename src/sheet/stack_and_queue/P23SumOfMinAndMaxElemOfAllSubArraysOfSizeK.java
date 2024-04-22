package sheet.stack_and_queue;

import java.util.Deque;
import java.util.LinkedList;

public class P23SumOfMinAndMaxElemOfAllSubArraysOfSizeK {

    public static int sumOfMinAndMax(int[] arr, int k) {
        int sum = 0;
        Deque<Integer> minDeque = new LinkedList<>();
        Deque<Integer> maxDeque = new LinkedList<>();

        // Process the first 'k' elements separately
        for (int i = 0; i < k; i++) {
            // Remove all previous greater elements for minDeque
            while (!minDeque.isEmpty() && arr[minDeque.peekLast()] >= arr[i]) {
                minDeque.removeLast();
            }

            // Remove all previous smaller elements for maxDeque
            while (!maxDeque.isEmpty() && arr[maxDeque.peekLast()] <= arr[i]) {
                maxDeque.removeLast();
            }

            // Add new element at rear of both deques
            minDeque.addLast(i);
            maxDeque.addLast(i);
        }

        // Sum of min and max for the first window
        sum += arr[minDeque.peekFirst()] + arr[maxDeque.peekFirst()];

        // Process the rest of the elements
        for (int i = k; i < arr.length; i++) {
            // Remove the elements which are out of this window
            while (!minDeque.isEmpty() && minDeque.peekFirst() <= i - k) {
                minDeque.removeFirst();
            }
            while (!maxDeque.isEmpty() && maxDeque.peekFirst() <= i - k) {
                maxDeque.removeFirst();
            }

            // Remove all previous greater elements for minDeque
            while (!minDeque.isEmpty() && arr[minDeque.peekLast()] >= arr[i]) {
                minDeque.removeLast();
            }

            // Remove all previous smaller elements for maxDeque
            while (!maxDeque.isEmpty() && arr[maxDeque.peekLast()] <= arr[i]) {
                maxDeque.removeLast();
            }

            // Add new element at rear of both deques
            minDeque.addLast(i);
            maxDeque.addLast(i);

            // Sum of min and max for the current window
            sum += arr[minDeque.peekFirst()] + arr[maxDeque.peekFirst()];
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, -1, 7, -3, -1, -2};
        int k = 4;
        System.out.println("Sum of minimum and maximum elements of every subarray of size " + k + ": " + sumOfMinAndMax(arr, k));
    }
}

