package sheet.google.dynamic_programming.knapsack_01;


public class K04SubSetSum {

    // Function to determine if there's a subset with a given sum
    public static boolean subsetSum(int[] arr, int sum) {
        int n = arr.length;
        boolean[][] dp = new boolean[n + 1][sum + 1];

        // Initialize the dp table
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;  // Sum 0 can always be achieved with an empty subset
        }

        // Build the dp array
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
        int[] arr = {3, 34, 4, 12, 5, 2};
        int sum = 9;

        if (subsetSum(arr, sum)) {
            System.out.println("Subset with given sum exists.");
        } else {
            System.out.println("Subset with given sum does not exist.");
        }
    }
}

