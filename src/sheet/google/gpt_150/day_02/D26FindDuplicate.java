package sheet.google.gpt_150.day_02;


public class D26FindDuplicate {

    public static void main(String[] args) {
        D26FindDuplicate solution = new D26FindDuplicate();

        int[] nums1 = {1, 3, 4, 2, 2};
        System.out.println("Duplicate number: " + solution.findDuplicate(nums1)); // Output: 2

        int[] nums2 = {3, 1, 3, 4, 2};
        System.out.println("Duplicate number: " + solution.findDuplicate(nums2)); // Output: 3
    }

    public int findDuplicate(int[] nums) {
        // Step 1: Initialize two pointers for cycle detection
        int slow = nums[0];
        int fast = nums[0];

        // Move slow by 1 step and fast by 2 steps until they meet inside the cycle
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // Step 2: Find the entrance to the cycle (duplicate number)
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow; // This is the duplicate number
    }
}

