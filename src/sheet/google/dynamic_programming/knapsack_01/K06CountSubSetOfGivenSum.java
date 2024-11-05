package sheet.google.dynamic_programming.knapsack_01;


public class K06CountSubSetOfGivenSum {

    // Function to count subsets with a given sum
    public static int countSubsets(int[] arr, int sum) {
        int n = arr.length;
        int[][] dp = new int[n + 1][sum + 1];

        // Initialize the dp array
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;  // There's one way to achieve a sum of 0 (empty subset)
        }

        // Build the dp array
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (arr[i - 1] <= j) {
                    // Count subsets including or excluding the current item
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] + dp[i - 1][j];
                } else {
                    // Exclude the current item
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        // The result is in dp[n][sum]
        return dp[n][sum];
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 6, 8, 10};
        int sum = 10;

        System.out.println("Number of subsets with given sum: " + countSubsets(arr, sum));
    }

    // Same variation can be done for count subset with given difference
    // S1−S2=diff
    // S1+S2=totalSum
    // so S1 = (diff + totalSum) / 2;
}




