package sheet.google.months_6;


import java.util.Arrays;

public class F16FindTwoNonOverlappingArraysWithEachTargetSum {
    public static void main(String[] args) {
        F16FindTwoNonOverlappingArraysWithEachTargetSum solution = new F16FindTwoNonOverlappingArraysWithEachTargetSum();

        // Test case 1
        int[] arr1 = {3, 2, 2, 4, 3};
        int target1 = 3;
        System.out.println(solution.minSumOfLengths(arr1, target1)); // Output: 2

        // Test case 2
        int[] arr2 = {7, 3, 4, 7};
        int target2 = 7;
        System.out.println(solution.minSumOfLengths(arr2, target2)); // Output: 2

        // Test case 3
        int[] arr3 = {4, 3, 2, 6, 2, 3, 4};
        int target3 = 6;
        System.out.println(solution.minSumOfLengths(arr3, target3)); // Output: -1

        // Test case 4
        int[] arr4 = {5, 5, 4, 4, 5};
        int target4 = 10;
        System.out.println(solution.minSumOfLengths(arr4, target4)); // Output: 4
    }

    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;

        // Array to store the minimum length of subarray with sum `target` ending at or before index `i`
        int[] minLength = new int[n];
        Arrays.fill(minLength, Integer.MAX_VALUE);

        // Sliding window to find subarrays with sum `target`
        int start = 0, currentSum = 0, minSum = Integer.MAX_VALUE;

        // Track the smallest length so far
        int smallestLength = Integer.MAX_VALUE;

        for (int end = 0; end < n; end++) {
            currentSum += arr[end];

            // Shrink the window until the sum becomes less than or equal to target
            while (currentSum > target) {
                currentSum -= arr[start++];
            }

            // If we find a valid subarray with sum `target`
            if (currentSum == target) {
                int currentLength = end - start + 1;

                // Check for a non-overlapping subarray on the left
                if (start > 0 && minLength[start - 1] != Integer.MAX_VALUE) {
                    minSum = Math.min(minSum, currentLength + minLength[start - 1]);
                }

                // Update the smallest length so far
                smallestLength = Math.min(smallestLength, currentLength);
            }

            // Update the minimum length of subarrays ending at or before `end`
            minLength[end] = smallestLength;
        }

        return minSum == Integer.MAX_VALUE ? -1 : minSum;
    }
}

