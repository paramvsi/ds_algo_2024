package sheet.google.dynamic_programming.unbounded_knapsack;


/*The Rod Cutting problem is a classic example of dynamic programming similar to the Unbounded Knapsack problem. Given a rod of a certain length and a list of prices for each length, the goal is to maximize profit by cutting the rod into smaller pieces of defined lengths.

Problem Definition
Given:

An integer n representing the length of the rod.
An array price[] where price[i] represents the price for a rod of length i+1.
The objective is to find the maximum revenue obtainable by cutting the rod into pieces and selling them.

Approach
Define the DP State:
Let dp[i] represent the maximum profit obtainable for a rod of length i.
Recursive Formula:
For each length i, consider every possible first cut length j (where 1 <= j <= i), and then maximize the profit by:
Including the profit from selling a piece of length j, which is price[j-1].
Adding it to the maximum profit obtainable from the remaining length i - j, which is dp[i - j].
dp[i]=max(dp[i],price[j−1]+dp[i−j])
Base Case:
dp[0] = 0, as there is no profit for a rod of length 0.*/
public class U02RodCuttingProblem {

    // Function to solve the rod cutting problem using dynamic programming
    public static int rodCutting(int[] price, int n) {
        int[] dp = new int[n + 1];

        // Build the dp array in a bottom-up manner
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], price[j - 1] + dp[i - j]);
            }
        }

        // The maximum profit for a rod of length n is dp[n]
        return dp[n];
    }

    public static void main(String[] args) {
        int[] price = {1, 5, 8, 9, 10, 17, 17, 20}; // Prices for each length from 1 to n
        int n = price.length;                       // Length of the rod

        System.out.println("Maximum profit: " + rodCutting(price, n));
    }
}
