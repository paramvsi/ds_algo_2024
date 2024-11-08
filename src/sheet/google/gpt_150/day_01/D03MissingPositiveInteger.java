package sheet.google.gpt_150.day_01;

public class D03MissingPositiveInteger {
    public static void main(String[] args) {
        D03MissingPositiveInteger solution = new D03MissingPositiveInteger();

        // Test Case 1
        int[] nums1 = {1, 2, 0};
        System.out.println("Test Case 1:");
        System.out.println("Expected Output: 3");
        System.out.println("Actual Output: " + solution.firstMissingPositive(nums1));
        System.out.println();

        // Test Case 2
        int[] nums2 = {3, 4, -1, 1};
        System.out.println("Test Case 2:");
        System.out.println("Expected Output: 2");
        System.out.println("Actual Output: " + solution.firstMissingPositive(nums2));
        System.out.println();

        // Test Case 3
        int[] nums3 = {7, 8, 9, 11, 12};
        System.out.println("Test Case 3:");
        System.out.println("Expected Output: 1");
        System.out.println("Actual Output: " + solution.firstMissingPositive(nums3));
        System.out.println();

        // Test Case 4 (Edge case: all numbers from 1 to n)
        int[] nums4 = {1, 2, 3};
        System.out.println("Test Case 4:");
        System.out.println("Expected Output: 4");
        System.out.println("Actual Output: " + solution.firstMissingPositive(nums4));
        System.out.println();

        // Test Case 5 (Single element array)
        int[] nums5 = {2};
        System.out.println("Test Case 5:");
        System.out.println("Expected Output: 1");
        System.out.println("Actual Output: " + solution.firstMissingPositive(nums5));
        System.out.println();
    }

    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // Step 1: Place each number in its correct position if possible
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                // Swap nums[i] with nums[nums[i] - 1]
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }

        // Step 2: Find the first missing positive
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        // Step 3: If all numbers are in the correct positions
        return n + 1;
    }

}


