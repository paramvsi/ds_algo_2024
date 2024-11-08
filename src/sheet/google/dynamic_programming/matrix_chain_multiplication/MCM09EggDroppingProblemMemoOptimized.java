package sheet.google.dynamic_programming.matrix_chain_multiplication;


public class MCM09EggDroppingProblemMemoOptimized {

    private static int[][] dp;

    // Recursive function with binary search to find the minimum number of attempts
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

        // Check memoization table
        if (dp[k][n] != -1) {
            return dp[k][n];
        }

        int minAttempts = Integer.MAX_VALUE;
        int low = 1, high = n;

        // Use binary search to find the optimal floor to drop the egg
        while (low <= high) {
            int mid = (low + high) / 2;

            int breaks = eggDrop(k - 1, mid - 1);  // Egg breaks
            int noBreaks = eggDrop(k, n - mid);    // Egg does not break

            int worstCase = 1 + Math.max(breaks, noBreaks);

            // Minimize the worst-case attempts
            minAttempts = Math.min(minAttempts, worstCase);

            // Move binary search boundaries
            if (breaks > noBreaks) {
                // Too high, go lower
                high = mid - 1;
            } else {
                // Too low, go higher
                low = mid + 1;
            }
        }

        // Store result in memoization table
        dp[k][n] = minAttempts;

        return minAttempts;
    }

    public static void main(String[] args) {
        int k = 2; // Number of eggs
        int n = 10; // Number of floors

        // Initialize memoization table
        dp = new int[k + 1][n + 1];
        for (int i = 0; i <= k; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println("Minimum number of attempts needed: " + eggDrop(k, n));
    }
}

