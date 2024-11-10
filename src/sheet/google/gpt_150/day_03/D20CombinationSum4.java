package sheet.google.gpt_150.day_03;


public class D20CombinationSum4 {

    public static void main(String[] args) {
        D20CombinationSum4 solution = new D20CombinationSum4();

        int[] nums1 = {1, 2, 3};
        int target1 = 4;
        System.out.println("Number of combinations: " + solution.combinationSum4(nums1, target1)); // Output: 7

        int[] nums2 = {9};
        int target2 = 3;
        System.out.println("Number of combinations: " + solution.combinationSum4(nums2, target2)); // Output: 0
    }

    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1; // There's one way to make target 0: by choosing nothing

        // Fill dp array from 1 to target
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i >= num) {
                    dp[i] += dp[i - num];
                }
            }
        }

        return dp[target];
    }
}

