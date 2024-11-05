package sheet.google.dynamic_programming.knapsack_01;

public class K08CountSubSetWithGivenDiff {

    // Function to count subsets with a given difference
    public static int countSubsetsWithGivenDiff(int[] arr, int diff) {
        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }

        // Calculate the target sum for one of the subsets
        if ((diff + totalSum) % 2 != 0) {
            return 0;  // If (diff + totalSum) is odd, we can't split as required
        }

        int targetSum = (diff + totalSum) / 2;
        return countSubsetsWithSum(arr, targetSum);
    }

    // Helper function to count subsets with a given sum
    private static int countSubsetsWithSum(int[] arr, int sum) {
        int n = arr.length;
        int[][] dp = new int[n + 1][sum + 1];

        // Initialize dp array
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;  // There is one way to make sum 0 (by choosing an empty subset)
        }

        // Fill the dp table
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (arr[i - 1] <= j) {
                    // Include or exclude the current item
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] + dp[i - 1][j];
                } else {
                    // Exclude the current item
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // The result is in dp[n][sum]
        return dp[n][sum];
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 3};
        int diff = 1;

        System.out.println("Number of subsets with given difference: " + countSubsetsWithGivenDiff(arr, diff));
    }
}

