package sheet.google.heap;

import java.util.PriorityQueue;

public class H01FindKthLargestElement {
    public static void main(String[] args) {
        H01FindKthLargestElement finder = new H01FindKthLargestElement();
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        int result = finder.findKthLargest(nums, k);
        System.out.println("The " + k + "th largest element is: " + result);
    }

    public int findKthLargest(int[] nums, int k) {
        // Use a Min-Heap to keep track of the largest k elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.offer(num); // Add the current number to the heap

            // Ensure the heap only contains k elements
            if (minHeap.size() > k) {
                minHeap.poll(); // Remove the smallest element
            }
        }

        // The root of the Min-Heap is the k-th largest element
        return minHeap.peek();
    }
}
