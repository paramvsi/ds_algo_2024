package sheet.google.sliding_window;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class SW01FirstNegativeNumberInEveryWindowOfKSize {

    public static List<Integer> firstNegativeInWindow(int[] arr, int k) {
        List<Integer> result = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>(); // To store indices of negative numbers

        for (int i = 0; i < arr.length; i++) {
            // Remove elements out of the current window
            if (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }

            // Add current element index if it is negative
            if (arr[i] < 0) {
                deque.add(i);
            }

            // If we have a valid window of size k, add the result for this window
            if (i >= k - 1) {
                if (!deque.isEmpty()) {
                    result.add(arr[deque.peek()]); // First negative number in the current window
                } else {
                    result.add(0); // No negative number in the current window
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {12, -1, -7, 8, -15, 30, 16, 28};
        int k = 3;
        System.out.println("First negative number in each window: " + firstNegativeInWindow(arr, k));
        // Expected output: [-1, -1, -7, -15, -15, 0]
    }
}

