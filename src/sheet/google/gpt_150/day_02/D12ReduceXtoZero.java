package sheet.google.gpt_150.day_02;


public class D12ReduceXtoZero {
    public static int minOperations(int[] nums, int x) {
        int total_sum = 0;
        for (int num : nums) {
            total_sum += num;
        }

        int target = total_sum - x;
        if (target < 0) return -1;  // If x is greater than the total sum, return -1
        if (target == 0) return nums.length;  // If x equals total sum, return the length of nums

        int maxLength = -1;  // Stores the length of the longest subarray with sum = target
        int current_sum = 0;
        int left = 0;

        // Sliding window approach
        for (int right = 0; right < nums.length; right++) {
            current_sum += nums[right];

            // Shrink the window until current_sum is <= target
            while (current_sum > target && left <= right) {
                current_sum -= nums[left];
                left++;
            }

            // Check if we found a subarray with the sum equal to target
            if (current_sum == target) {
                maxLength = Math.max(maxLength, right - left + 1);
            }
        }

        // If maxLength is -1, we couldn't find a valid subarray, so return -1
        return maxLength == -1 ? -1 : nums.length - maxLength;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 1, 4, 2, 3};
        int x1 = 5;
        System.out.println("Minimum operations to reduce x to zero: " + minOperations(nums1, x1)); // Output: 2

        int[] nums2 = {5, 6, 7, 8, 9};
        int x2 = 4;
        System.out.println("Minimum operations to reduce x to zero: " + minOperations(nums2, x2)); // Output: -1

        int[] nums3 = {3, 2, 20, 1, 1, 3};
        int x3 = 10;
        System.out.println("Minimum operations to reduce x to zero: " + minOperations(nums3, x3)); // Output: 5
    }
}

