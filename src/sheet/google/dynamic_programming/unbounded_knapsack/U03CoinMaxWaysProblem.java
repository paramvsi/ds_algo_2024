package sheet.google.dynamic_programming.unbounded_knapsack;

/*The Coin Change Problem (Maximum Number of Ways) is a classic dynamic programming problem. Given a set of coins with specific denominations and a target sum, the objective is to find the number of ways to make up that sum using any number of coins.

Problem Definition
Given:

An integer sum representing the target amount.
An array coins[] where each element represents a coin denomination.
The goal is to find the total number of ways to make the target sum using the available denominations. Each coin can be used multiple times.

Approach (Dynamic Programming)
Define the DP State:
Let dp[i] represent the number of ways to make up the sum i using the given coins.
Base Case:
dp[0] = 1 because there is one way to make the sum 0, which is by choosing no coins.
Recursive Formula:
For each coin in coins, update the dp array by iterating through possible sums from the coin’s value up to sum.
For each sum j, add the ways to make j - coin (which is dp[j - coin]) to dp[j].
This is because if j - coin can be achieved in some ways, then by adding the current coin, we can also achieve j.
dp[j]=dp[j]+dp[j−coin]
*/

public class U03CoinMaxWaysProblem {

    // Function to calculate the maximum number of ways to get the target sum
    public static int countWays(int[] coins, int sum) {
        int[] dp = new int[sum + 1];

        // Base case: there's one way to make sum 0 (by choosing no coins)
        dp[0] = 1;

        // Loop through each coin
        for (int coin : coins) {
            // Update dp array for all values >= coin's value
            for (int j = coin; j <= sum; j++) {
                dp[j] += dp[j - coin];
            }
        }

        // The answer is the number of ways to get the target sum
        return dp[sum];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 3}; // Coin denominations
        int sum = 4;             // Target sum

        System.out.println("Number of ways to make the sum: " + countWays(coins, sum));
    }
}


