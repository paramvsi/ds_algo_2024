package sheet.google.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class H02FindKthSmallestElement {
    public static void main(String[] args) {
        H02FindKthSmallestElement finder = new H02FindKthSmallestElement();
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 3;
        int result = finder.findKthSmallest(nums, k);
        System.out.println("The " + k + "th smallest element is: " + result);
    }

    public int findKthSmallest(int[] nums, int k) {
        // Use a Max-Heap to keep track of the smallest k elements
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int num : nums) {
            maxHeap.offer(num); // Add the current number to the heap

            // Ensure the heap only contains k elements
            if (maxHeap.size() > k) {
                maxHeap.poll(); // Remove the largest element
            }
        }

        // The root of the Max-Heap is the k-th smallest element
        return maxHeap.peek();
    }
}
