package sheet.google.gpt_150.day_02;


import java.util.Collections;
import java.util.PriorityQueue;

public class D13MedianOfADataStream {

    private PriorityQueue<Integer> maxHeap; // left side (max-heap)
    private PriorityQueue<Integer> minHeap; // right side (min-heap)

    /**
     * Initialize the data structure
     */
    public D13MedianOfADataStream() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }

    public static void main(String[] args) {
        D13MedianOfADataStream medianFinder = new D13MedianOfADataStream();

        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println("Median: " + medianFinder.findMedian()); // Output: 1.5

        medianFinder.addNum(3);
        System.out.println("Median: " + medianFinder.findMedian()); // Output: 2.0
    }

    /**
     * Adds a number to the data structure
     */
    public void addNum(int num) {
        // Step 1: Add to maxHeap, then balance heaps
        maxHeap.offer(num);

        // Step 2: Move the maximum from maxHeap to minHeap to keep balance
        minHeap.offer(maxHeap.poll());

        // Step 3: Rebalance if minHeap has more elements
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    /**
     * Returns the median of all elements so far
     */
    public double findMedian() {
        // If both heaps are the same size, return the average of the roots
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
        // Otherwise, maxHeap has the extra element, so return its root
        return maxHeap.peek();
    }
}

