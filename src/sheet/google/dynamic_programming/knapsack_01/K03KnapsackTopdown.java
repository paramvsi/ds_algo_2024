package sheet.google.dynamic_programming.knapsack_01;


public class K03KnapsackTopdown {

    // Function to solve 0-1 Knapsack problem using the top-down approach
    public static int knapsack(int W, int[] wt, int[] val, int n) {
        int[][] dp = new int[n + 1][W + 1];

        // Build the dp array from the bottom up
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                // Base case: no items or zero capacity
                if (i == 0 || w == 0) {
                    dp[i][w] = 0;
                }
                // If the weight of the current item is more than the current capacity
                // of the knapsack, exclude it
                else if (wt[i - 1] <= w) {
                    // Maximize the value by either including or excluding the current item
                    dp[i][w] = Math.max(val[i - 1] + dp[i - 1][w - wt[i - 1]], dp[i - 1][w]);
                } else {
                    // Exclude the current item
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        // The final answer is in dp[n][W]
        return dp[n][W];
    }

    public static void main(String[] args) {
        int[] val = {60, 100, 120}; // values of items
        int[] wt = {10, 20, 30};    // weights of items
        int W = 50;                  // maximum capacity of the knapsack
        int n = val.length;

        System.out.println("Maximum value in knapsack: " + knapsack(W, wt, val, n));
    }
}

