package sheet.google.dynamic_programming.matrix_chain_multiplication;


/*
The Egg Dropping Problem is a classic problem in dynamic programming.
Given a certain number of floors and a certain number of eggs,
the goal is to determine the minimum number of attempts required to find the highest floor
from which an egg can be dropped without breaking.
*/

public class MCM08EggDroppingProblemMemo {

    private static int[][] dp;

    // Recursive function to find the minimum number of attempts required
    public static int eggDrop(int k, int n) {
        // Base cases
        if (n == 0) {
            return 0; // 0 floors, no trials needed
        }
        if (n == 1) {
            return 1; // 1 floor, 1 trial needed
        }
        if (k == 1) {
            return n; // 1 egg, we need n trials (linear search)
        }

        if (dp[k][n] != -1) {
            return dp[k][n];
        }

        int minAttempts = Integer.MAX_VALUE;

        // Try dropping from each floor x, 1 <= x <= n
        for (int x = 1; x <= n; x++) {
            // Calculate the number of attempts if we drop from floor x
            int attempts = 1 + Math.max(eggDrop(k - 1, x - 1), eggDrop(k, n - x));

            // Update minimum attempts needed
            minAttempts = Math.min(minAttempts, attempts);
        }

        dp[k][n] = minAttempts;

        return minAttempts;
    }

    public static void main(String[] args) {
        int k = 2; // Number of eggs
        int n = 10; // Number of floors

        dp = new int[k + 1][n + 1];

        for (int i = 0; i <= k; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println("Minimum number of attempts needed: " + eggDrop(k, n));
    }
}


