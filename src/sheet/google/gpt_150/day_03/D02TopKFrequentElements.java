package sheet.google.gpt_150.day_03;

// Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.


import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class D02TopKFrequentElements {

    public static void main(String[] args) {
        D02TopKFrequentElements solution = new D02TopKFrequentElements();

        int[] nums1 = {1, 1, 1, 2, 2, 3};
        int k1 = 2;
        System.out.println("Top " + k1 + " frequent elements: " + java.util.Arrays.toString(solution.topKFrequent(nums1, k1))); // Output: [1, 2]

        int[] nums2 = {1};
        int k2 = 1;
        System.out.println("Top " + k2 + " frequent elements: " + java.util.Arrays.toString(solution.topKFrequent(nums2, k2))); // Output: [1]
    }

    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Build the frequency map
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Use a min-heap to keep the top k elements
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
                Comparator.comparingInt(Map.Entry::getValue) // Min-heap based on frequency
        );

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            minHeap.offer(entry);
            if (minHeap.size() > k) {
                minHeap.poll(); // Remove the least frequent element
            }
        }

        // Step 3: Extract elements from the min-heap
        int[] result = new int[k];
        int index = 0;
        while (!minHeap.isEmpty()) {
            result[index++] = minHeap.poll().getKey();
        }

        return result;
    }
}

