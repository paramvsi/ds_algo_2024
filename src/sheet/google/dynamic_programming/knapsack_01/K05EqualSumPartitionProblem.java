package sheet.google.dynamic_programming.knapsack_01;


/*The Equal Sum Partition problem asks whether a given array can be partitioned into two subsets with equal sum.
This problem can be transformed into a Subset Sum problem.

Problem Definition
Given:

An array arr[] of non-negative integers.
The objective is to determine if there exists a way to partition the array into two subsets such that
the sum of elements in both subsets is equal.

Approach
Calculate the total sum of the array elements.
Check if the total sum is even:
If it's odd, it is impossible to split the array into two equal sums, so the answer is false.
If it's even, we look for a subset with a sum equal to totalSum / 2.
This reduces the problem to finding a subset with sum S = totalSum / 2 (similar to the subset sum problem).
*/
public class K05EqualSumPartitionProblem {

    // Function to determine if array can be partitioned into two subsets with equal sum
    public static boolean canPartition(int[] arr) {
        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }

        // If total sum is odd, we cannot partition it into two equal subsets
        if (totalSum % 2 != 0) {
            return false;
        }

        int sum = totalSum / 2;
        int n = arr.length;
        boolean[][] dp = new boolean[n + 1][sum + 1];

        // Initialize the dp table
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;  // Sum 0 can always be achieved with an empty subset
        }

        // Fill the dp array
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i - 1] <= j) {
                    // Include the item or exclude it
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
                } else {
                    // Exclude the item
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // The answer is in dp[n][sum]
        return dp[n][sum];
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 11, 5};

        if (canPartition(arr)) {
            System.out.println("Array can be partitioned into two subsets with equal sum.");
        } else {
            System.out.println("Array cannot be partitioned into two subsets with equal sum.");
        }
    }
}

