package sheet.google.gpt_150.day_01;

public class D05JumpGame2 {
    private static int minJumps(int[] nums) {
        int jumps = 0;
        int farthest = 0;
        int currentEnd = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);

            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;
            }

            if (currentEnd >= nums.length - 1) {
                return jumps;
            }
        }

        return jumps;
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] nums1 = {2, 3, 1, 1, 4};
        System.out.println("Test Case 1: Expected 2, Actual: " + minJumps(nums1));

        // Test Case 2
        int[] nums2 = {2, 3, 0, 1, 4};
        System.out.println("Test Case 2: Expected 2, Actual: " + minJumps(nums2));

        // Test Case 3
        int[] nums3 = {1, 2, 1, 1, 1};
        System.out.println("Test Case 3: Expected 3, Actual: " + minJumps(nums3));

        // Test Case 4 (Single element)
        int[] nums4 = {0};
        System.out.println("Test Case 4: Expected 0, Actual: " + minJumps(nums4));

        // Test Case 5 (Already at the end)
        int[] nums5 = {5, 4, 3, 2, 1, 0};
        System.out.println("Test Case 5: Expected 1, Actual: " + minJumps(nums5));
    }

}
