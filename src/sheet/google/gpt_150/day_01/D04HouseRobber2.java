package sheet.google.gpt_150.day_01;

/*
Problem Statement: You are a professional robber planning to rob houses along a street.
 Each house has a certain amount of money stashed, but adjacent houses have a security system
 that will alert the police if two adjacent houses are broken into on the same night.

Unlike the previous problem, all houses are arranged in a circle. This means the first house is
adjacent to the last one. Given an integer array nums representing the amount of money of each house,
return the maximum amount of money you can rob tonight without alerting the police.*/
public class D04HouseRobber2 {

    private static int robHouse(int[] nums) {
        if (nums.length == 1) return nums[0];

        return Math.max(robRanges(nums, 0, nums.length - 2), robRanges(nums, 1, nums.length - 1));
    }

    private static int robRanges(int[] nums, int start, int end) {
        int prev1 = 0;
        int prev2 = 0;

        while (start <= end) {
            int temp = prev1;
            prev1 = Math.max(prev2 + nums[start], prev1);
            prev2 = temp;
            start++;
        }

        return prev1;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 3, 2};
        int[] nums2 = {1, 2, 3, 1};
        int[] nums3 = {1, 2, 3};
        int[] nums4 = {0};
        int[] nums5 = {};

        System.out.println("Test Case 1: Expected 3, Actual: " + robHouse(nums1));
        System.out.println("Test Case 2: Expected 4, Actual: " + robHouse(nums2));
        System.out.println("Test Case 3: Expected 3, Actual: " + robHouse(nums3));
        System.out.println("Test Case 4: Expected 0, Actual: " + robHouse(nums4));
        System.out.println("Test Case 5: Expected 0, Actual: " + robHouse(nums5));
    }
}
