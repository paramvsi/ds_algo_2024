package sheet.google.dynamic_programming.knapsack_01;

import java.util.Arrays;

public class K02KnapsackMemoization {

    // Function to solve 0-1 Knapsack problem with memoization
    public static int knapsack(int W, int[] wt, int[] val, int n, int[][] memo) {
        // Base case: no items or knapsack capacity is zero
        if (n == 0 || W == 0) {
            return 0;
        }

        // Check if value already calculated
        if (memo[n][W] != -1) {
            return memo[n][W];
        }

        // If the weight of the nth item is more than the knapsack capacity W,
        // exclude the item and move to the next
        if (wt[n - 1] > W) {
            memo[n][W] = knapsack(W, wt, val, n - 1, memo);
        } else {
            // Option to include or exclude the current item
            int includeItem = val[n - 1] + knapsack(W - wt[n - 1], wt, val, n - 1, memo);
            int excludeItem = knapsack(W, wt, val, n - 1, memo);
            memo[n][W] = Math.max(includeItem, excludeItem);
        }

        return memo[n][W];
    }

    public static void main(String[] args) {
        int[] val = {60, 100, 120}; // values of items
        int[] wt = {10, 20, 30};    // weights of items
        int W = 50;                  // maximum capacity of the knapsack
        int n = val.length;

        // Initialize memo table with -1 to indicate uncalculated values
        int[][] memo = new int[n + 1][W + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        System.out.println("Maximum value in knapsack: " + knapsack(W, wt, val, n, memo));
        // Time complexity is O(n * W) / Space complexity is also same
    }
}

