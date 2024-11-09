package sheet.google.gpt_150.day_03;


import java.util.PriorityQueue;

public class D05KthLargestElement {
    private PriorityQueue<Integer> minHeap;
    private int k;

    public D05KthLargestElement(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>(k);

        // Add initial elements to the heap
        for (int num : nums) {
            add(num);
        }
    }

    public static void main(String[] args) {
        int k = 3;
        int[] nums = {4, 5, 8, 2};
        D05KthLargestElement kthLargest = new D05KthLargestElement(k, nums);

        System.out.println("Kth largest after adding 3: " + kthLargest.add(3)); // Output: 4
        System.out.println("Kth largest after adding 5: " + kthLargest.add(5)); // Output: 5
        System.out.println("Kth largest after adding 10: " + kthLargest.add(10)); // Output: 5
        System.out.println("Kth largest after adding 9: " + kthLargest.add(9)); // Output: 8
        System.out.println("Kth largest after adding 4: " + kthLargest.add(4)); // Output: 8
    }

    public int add(int val) {
        // If the heap has fewer than k elements, add the new element
        if (minHeap.size() < k) {
            minHeap.offer(val);
        }
        // If the heap is at capacity and the new element is larger than the smallest (root), replace the root
        else if (val > minHeap.peek()) {
            minHeap.poll();
            minHeap.offer(val);
        }

        // The root of the heap is the k-th largest element
        return minHeap.peek();
    }
}

