package sheet.google.gpt_150.day_02;

/*
Given an integer array nums, return true if you can partition the array into two subsets such
that the sum of elements in both subsets is equal, otherwise, return false.*/
public class D03PartitionEqualSubSetSum {
    public static boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        // If total sum is odd, it's impossible to partition
        if (totalSum % 2 != 0) return false;

        int target = totalSum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int num : nums) {
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }

        return dp[target];
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 5, 11, 5};
        System.out.println("Can partition: " + canPartition(nums1)); // Output: true

        int[] nums2 = {1, 2, 3, 5};
        System.out.println("Can partition: " + canPartition(nums2)); // Output: false
    }
}



