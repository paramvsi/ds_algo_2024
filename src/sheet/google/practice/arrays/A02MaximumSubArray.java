package sheet.google.practice.arrays;

public class A02MaximumSubArray {
    public static int maxSubArray(int[] nums) {
        // Implement your logic here
        int maxSoFar = nums[0];
        int maxEndingHere = nums[0];

        for (int i = 1; i < nums.length; i++) {
            maxEndingHere = Math.max(maxEndingHere + nums[i], nums[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar; // Return the maximum sum of a contiguous subarray
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4}; // Example input
        System.out.println("Maximum sum of a contiguous subarray: " + maxSubArray(nums));
    }
}
