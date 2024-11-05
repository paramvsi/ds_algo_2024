package sheet.google.dynamic_programming.unbounded_knapsack;

public class U01UnboundedKnapsack {
    // Function to solve the Unbounded Knapsack problem using a top-down approach
    public static int unboundedKnapsack(int W, int[] wt, int[] val, int n) {
        int[][] dp = new int[n + 1][W + 1];

        // Build the dp array
        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                if (wt[i - 1] <= w) {
                    // Include the item multiple times (unbounded)
                    dp[i][w] = Math.max(dp[i - 1][w], val[i - 1] + dp[i][w - wt[i - 1]]);
                } else {
                    // Exclude the item
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        // The maximum value with given weight limit W is dp[n][W]
        return dp[n][W];
    }

    public static void main(String[] args) {
        int[] val = {10, 40, 50, 70}; // values of items
        int[] wt = {1, 3, 4, 5};      // weights of items
        int W = 8;                    // maximum capacity of the knapsack
        int n = val.length;

        System.out.println("Maximum value in unbounded knapsack: " + unboundedKnapsack(W, wt, val, n));
    }
}

