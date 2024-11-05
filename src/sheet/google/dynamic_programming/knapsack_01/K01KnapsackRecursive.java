package sheet.google.dynamic_programming.knapsack_01;


public class K01KnapsackRecursive {

    // Recursive function to solve 0-1 Knapsack problem
    public static int knapsack(int W, int[] wt, int[] val, int n) {
        // Base case: if no items or capacity is 0
        if (n == 0 || W == 0) {
            return 0;
        }

        // If the weight of the nth item is more than the knapsack capacity W
        // exclude the item and move to the next
        if (wt[n - 1] > W) {
            return knapsack(W, wt, val, n - 1);
        } else {
            // Return the maximum of two cases:
            // (1) nth item included
            // (2) nth item not included
            int includeItem = val[n - 1] + knapsack(W - wt[n - 1], wt, val, n - 1);
            int excludeItem = knapsack(W, wt, val, n - 1);
            return Math.max(includeItem, excludeItem);
        }
    }

    public static void main(String[] args) {
        int[] val = {60, 100, 120}; // values of items
        int[] wt = {10, 20, 30};    // weights of items
        int W = 50;                  // maximum capacity of the knapsack
        int n = val.length;

        System.out.println("Maximum value in knapsack: " + knapsack(W, wt, val, n));

        // Since we are checking all possibilities we are having tc of O(2^n)
    }
}

