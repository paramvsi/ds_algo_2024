package sheet.stack_and_queue;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class P22FirstNegativeIntegerInEveryWindowOfSizeK {
    public static int[] firstNegative(int[] arr, int k) {
        int n = arr.length;
        Deque<Integer> deque = new LinkedList<>();
        int[] result = new int[n - k + 1];  // Result array to store the first negatives for each window

        // Process the first 'k' elements separately
        for (int i = 0; i < k; i++) {
            if (arr[i] < 0) {
                deque.addLast(i);
            }
        }

        // The first result (for the first window)
        result[0] = deque.isEmpty() ? 0 : arr[deque.peekFirst()];

        // Process the rest of the elements
        for (int i = k; i < n; i++) {
            // Remove the elements not within the window
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // Add the current element if it is negative
            if (arr[i] < 0) {
                deque.addLast(i);
            }

            // The front of the deque is the first negative integer in the current window
            result[i - k + 1] = deque.isEmpty() ? 0 : arr[deque.peekFirst()];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {12, -1, -7, 8, 15, 30, 16, 28};
        int k = 3;
        int[] result = firstNegative(arr, k);
        System.out.println("First negative integer in every window of size " + k + ": " + Arrays.toString(result));
    }
}

