package sheet.google.sliding_window;


import java.util.HashMap;
import java.util.Map;

public class SW04LargestSubArraySizeOfSumK {

    public static int largestSubArrayWithSumK(int[] arr, int K) {
        int maxLength = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            // Check if current sum is equal to K
            if (sum == K) {
                maxLength = i + 1;
            }

            // If sum - K is present in map, update maxLength
            if (map.containsKey(sum - K)) {
                maxLength = Math.max(maxLength, i - map.get(sum - K));
            }

            // Store sum in map if it is not already present
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] arr = {10, 5, 2, 7, 1, 9};
        int K = 15;
        System.out.println("Length of the longest subarray with sum K: " + largestSubArrayWithSumK(arr, K));
        // Expected output: 4, since the subarray [5, 2, 7, 1] has a sum of 15
    }
}

