package sheet.google.dynamic_programming.unbounded_knapsack;
/*
The Coin Change Problem (Minimum Number of Coins) is a variation of the coin change problem
where the objective is to find the minimum number of coins needed to make a target sum using given coin denominations.
If it’s not possible to make the target sum with the given coins, return -1.
        Problem Definition
        Given:

        An integer sum representing the target amount.
        An array coins[] where each element represents a coin denomination.
        The objective is to find the minimum number of coins needed to make up the target sum. Each coin can be used multiple times.

        Approach (Dynamic Programming)
        Define the DP State:

        Let dp[i] represent the minimum number of coins required to achieve the sum i.
        Base Case:

        dp[0] = 0 because no coins are needed to make a sum of 0.
        Recursive Formula:

        For each coin in coins, update the dp array by iterating from the coin’s value up to sum.
        For each sum j, if the current coin can contribute to making up j, we calculate dp[j] as:

        dp[j]=min(dp[j],1+dp[j−coin])
*/

import java.util.Arrays;

public class U04CoinChangeNumberOfCoins {

    // Function to calculate the minimum number of coins needed to get the target sum
    public static int minCoins(int[] coins, int sum) {
        int[] dp = new int[sum + 1];

        // Initialize dp array with a large number (infinity)
        Arrays.fill(dp, sum + 1);

        // Base case: zero coins needed for sum 0
        dp[0] = 0;

        // Loop through each coin
        for (int coin : coins) {
            // Update dp array for all values >= coin's value
            for (int j = coin; j <= sum; j++) {
                dp[j] = Math.min(dp[j], 1 + dp[j - coin]);
            }
        }

        // If dp[sum] is still a large number, return -1 (sum cannot be achieved)
        return dp[sum] > sum ? -1 : dp[sum];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5}; // Coin denominations
        int sum = 11;            // Target sum

        System.out.println("Minimum number of coins to make the sum: " + minCoins(coins, sum));
    }
}

