package sheet.google.sliding_window;


import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class SW03MaxOfAllSubArrayOfSizeK {

    public static List<Integer> maxOfAllSubArrays(int[] arr, int k) {
        List<Integer> result = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>(); // To store indices of useful elements for each window

        for (int i = 0; i < arr.length; i++) {
            // Remove elements from the front of the deque that are out of the current window
            if (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }

            // Remove elements from the back of the deque that are smaller than the current element
            // because they are not useful (they won't be the maximum for this or any future window)
            while (!deque.isEmpty() && arr[deque.peekLast()] <= arr[i]) {
                deque.pollLast();
            }

            // Add the current element's index to the deque
            deque.addLast(i);

            // If we have processed at least 'k' elements, record the result for the current window
            if (i >= k - 1) {
                result.add(arr[deque.peek()]); // The front of the deque is the max for the current window
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        System.out.println("Maximum of each subarray of size k: " + maxOfAllSubArrays(arr, k));
        // Expected output: [3, 3, 5, 5, 6, 7]
    }
}

