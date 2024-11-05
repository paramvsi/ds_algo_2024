package sheet.google.dynamic_programming.knapsack_01;

/*
The Minimum Subset Sum Difference problem is a variation of the subset sum problem.
The goal is to partition a given set into two subsets such that the difference between their sums is minimized.

Problem Definition
Given:

An array arr[] of non-negative integers.
The objective is to divide arr into two subsets such that the difference between their sums is minimized.

Approach
Calculate the Total Sum of the array.
        Let’s denote the two subsets as S1 and S2.
We know that the sum of the array is totalSum = S1 + S2.
        To minimize |S1 - S2|, we aim to find S1 as close as possible to totalSum / 2.
Subset Sum Problem:
We transform the problem into finding the maximum possible subset sum S1 that is less than or equal to totalSum / 2.
If we can find a subset sum S1, then S2 = totalSum - S1, and the difference is |S1 - S2| = |totalSum - 2 * S1|.
*/

public class K07MinSubSetSumDiff {

    // Function to find the minimum subset sum difference
    public static int minSubsetSumDiff(int[] arr) {
        int n = arr.length;
        int totalSum = 0;

        for (int num : arr) {
            totalSum += num;
        }

        int target = totalSum / 2;

        // DP array to store achievable subset sums
        boolean[][] dp = new boolean[n + 1][target + 1];

        // Initialize dp array
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;  // Zero sum is always achievable (empty subset)
        }

        // Fill dp table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // Find the maximum subset sum close to totalSum / 2
        int maxSubsetSum = 0;
        for (int j = target; j >= 0; j--) {
            if (dp[n][j]) {
                maxSubsetSum = j;
                break;
            }
        }

        // Minimum subset sum difference
        return Math.abs(totalSum - 2 * maxSubsetSum);
    }

    public static void main(String[] args) {
        int[] arr = {1, 6, 11, 5};
        System.out.println("Minimum subset sum difference: " + minSubsetSumDiff(arr));
    }
}
