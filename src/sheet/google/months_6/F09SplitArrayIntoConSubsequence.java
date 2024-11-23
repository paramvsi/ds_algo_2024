package sheet.google.months_6;
//  https://leetcode.com/problems/split-array-into-consecutive-subsequences

import java.util.HashMap;
import java.util.Map;

public class F09SplitArrayIntoConSubsequence {
    public static void main(String[] args) {
        F09SplitArrayIntoConSubsequence solution = new F09SplitArrayIntoConSubsequence();

        // Test cases
        int[] nums1 = {1, 2, 3, 3, 4, 5};
        System.out.println(solution.isPossible(nums1)); // Output: true

        int[] nums2 = {1, 2, 3, 4, 4, 5};
        System.out.println(solution.isPossible(nums2)); // Output: false
    }

    public boolean isPossible(int[] nums) {
        // Frequency map to count occurrences of each number
        Map<Integer, Integer> freq = new HashMap<>();
        // Map to track subsequences ending at a specific number
        Map<Integer, Integer> endMap = new HashMap<>();

        // Build frequency map
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Iterate through the array
        for (int num : nums) {
            if (freq.get(num) == 0) {
                continue; // Skip if the number is already used
            }

            // Try to extend an existing subsequence
            if (endMap.getOrDefault(num - 1, 0) > 0) {
                // Decrease the count of subsequences ending at num - 1
                endMap.put(num - 1, endMap.get(num - 1) - 1);
                // Increase the count of subsequences ending at num
                endMap.put(num, endMap.getOrDefault(num, 0) + 1);
            }
            // Try to start a new subsequence
            else if (freq.getOrDefault(num + 1, 0) > 0 && freq.getOrDefault(num + 2, 0) > 0) {
                // Use num, num + 1, and num + 2 to form a new subsequence
                freq.put(num + 1, freq.get(num + 1) - 1);
                freq.put(num + 2, freq.get(num + 2) - 1);
                // Mark subsequence ending at num + 2
                endMap.put(num + 2, endMap.getOrDefault(num + 2, 0) + 1);
            }
            // Neither extending nor starting is possible
            else {
                return false;
            }

            // Decrease the frequency of num
            freq.put(num, freq.get(num) - 1);
        }

        return true;
    }
}

