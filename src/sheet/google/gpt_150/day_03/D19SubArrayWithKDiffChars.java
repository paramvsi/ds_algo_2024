package sheet.google.gpt_150.day_03;


import java.util.HashMap;
import java.util.Map;

public class D19SubArrayWithKDiffChars {

    public static void main(String[] args) {
        D19SubArrayWithKDiffChars solution = new D19SubArrayWithKDiffChars();

        int[] nums1 = {1, 2, 1, 2, 3};
        int K1 = 2;
        System.out.println("Number of subarrays with exactly " + K1 + " distinct integers: "
                + solution.subarraysWithKDistinct(nums1, K1)); // Output: 7

        int[] nums2 = {1, 2, 1, 3, 4};
        int K2 = 3;
        System.out.println("Number of subarrays with exactly " + K2 + " distinct integers: "
                + solution.subarraysWithKDistinct(nums2, K2)); // Output: 3
    }

    public int subarraysWithKDistinct(int[] nums, int K) {
        return atMostKDistinct(nums, K) - atMostKDistinct(nums, K - 1);
    }

    // Helper function to count subarrays with at most K distinct integers
    private int atMostKDistinct(int[] nums, int K) {
        int left = 0;
        int count = 0;
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int right = 0; right < nums.length; right++) {
            // Add nums[right] to the frequency map
            freqMap.put(nums[right], freqMap.getOrDefault(nums[right], 0) + 1);

            // If more than K distinct elements, shrink the window
            while (freqMap.size() > K) {
                freqMap.put(nums[left], freqMap.get(nums[left]) - 1);
                if (freqMap.get(nums[left]) == 0) {
                    freqMap.remove(nums[left]);
                }
                left++;
            }

            // Count all subarrays ending at 'right' with at most K distinct elements
            count += right - left + 1;
        }

        return count;
    }
}

