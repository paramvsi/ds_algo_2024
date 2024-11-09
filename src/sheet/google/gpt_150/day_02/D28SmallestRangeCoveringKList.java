package sheet.google.gpt_150.day_02;


import java.util.List;
import java.util.PriorityQueue;

public class D28SmallestRangeCoveringKList {

    public static void main(String[] args) {
        D28SmallestRangeCoveringKList solution = new D28SmallestRangeCoveringKList();

        List<List<Integer>> nums = List.of(
                List.of(4, 10, 15, 24, 26),
                List.of(0, 9, 12, 20),
                List.of(5, 18, 22, 30)
        );

        int[] result = solution.smallestRange(nums);
        System.out.println("Smallest range: [" + result[0] + ", " + result[1] + "]"); // Output: [20, 24]
    }

    public int[] smallestRange(List<List<Integer>> nums) {
        // Min-heap to keep track of the smallest element across the lists
        PriorityQueue<Element> minHeap = new PriorityQueue<>((a, b) -> a.value - b.value);

        int currentMax = Integer.MIN_VALUE; // Track the maximum value in the current range
        int start = 0, end = Integer.MAX_VALUE; // Initialize the smallest range

        // Step 1: Initialize the heap with the first element of each list
        for (int i = 0; i < nums.size(); i++) {
            int value = nums.get(i).get(0);
            minHeap.offer(new Element(value, i, 0));
            currentMax = Math.max(currentMax, value); // Update the max value
        }

        // Step 2: Expand the range until we exhaust any one of the lists
        while (minHeap.size() == nums.size()) {
            // Get the smallest element from the heap
            Element minElement = minHeap.poll();
            int currentMin = minElement.value;

            // Update the smallest range if the current range is smaller
            if (currentMax - currentMin < end - start) {
                start = currentMin;
                end = currentMax;
            }

            // Step 3: Move to the next element in the same list of the min element
            if (minElement.indexInList + 1 < nums.get(minElement.listIndex).size()) {
                int nextValue = nums.get(minElement.listIndex).get(minElement.indexInList + 1);
                minHeap.offer(new Element(nextValue, minElement.listIndex, minElement.indexInList + 1));
                currentMax = Math.max(currentMax, nextValue); // Update the max value if necessary
            } else {
                // If we exhaust any one list, we stop
                break;
            }
        }

        return new int[]{start, end};
    }

    // Helper class to store elements with list and index info
    private static class Element {
        int value;
        int listIndex;
        int indexInList;

        Element(int value, int listIndex, int indexInList) {
            this.value = value;
            this.listIndex = listIndex;
            this.indexInList = indexInList;
        }
    }
}

