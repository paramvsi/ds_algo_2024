package sheet.google.dynamic_programming.knapsack_01;

// The Target Sum problem is similar to the Count of Subsets with Given Difference problem.
// In this problem, we are given an array and a target sum, and we need to assign a + or - sign
// to each element in the array so that the sum of all elements with their signs equals the target sum.
// We need to find the number of ways to achieve this target sum.

public class K09TargetSum {

    // Function to calculate the number of ways to achieve the target sum
    public static int findTargetSumWays(int[] nums, int target) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        // Check if a valid subset sum can be achieved
        if ((target + totalSum) % 2 != 0 || target > totalSum) {
            return 0;
        }

        int subsetSum = (target + totalSum) / 2;
        return countSubsetsWithSum(nums, subsetSum);
    }

    // Helper function to count subsets with a given sum
    private static int countSubsetsWithSum(int[] nums, int sum) {
        int n = nums.length;
        int[][] dp = new int[n + 1][sum + 1];

        // Initialize dp array
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;  // One way to make sum 0 (by choosing an empty subset)
        }

        // Build the dp array
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (nums[i - 1] <= j) {
                    // Include or exclude the current element
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] + dp[i - 1][j];
                } else {
                    // Exclude the current element
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // The result is in dp[n][sum]
        return dp[n][sum];
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 6, 1};
        int target = 3;

        System.out.println("Number of ways to achieve target sum: " + findTargetSumWays(nums, target));
    }
}

