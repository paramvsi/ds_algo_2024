package sheet.google.dynamic_programming.matrix_chain_multiplication;

public class MCM02Memoization {

    // Memoization table to store minimum multiplication costs
    private static int[][] dp;

    // Function to find the minimum multiplication cost using memoization
    public static int matrixChainOrder(int[] p, int i, int j) {
        // Base case: Only one matrix, no multiplication needed
        if (i == j) {
            return 0;
        }

        // Check if the result is already computed
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        // Initialize the minimum cost to a very high value
        int minCost = Integer.MAX_VALUE;

        // Try placing the parenthesis at different positions between i and j
        // and recursively calculate the minimum cost for each position
        for (int k = i; k < j; k++) {
            int cost = matrixChainOrder(p, i, k)
                    + matrixChainOrder(p, k + 1, j)
                    + p[i - 1] * p[k] * p[j];

            // Update the minimum cost
            minCost = Math.min(minCost, cost);
        }

        // Memoize the result
        dp[i][j] = minCost;

        return minCost;
    }

    public static void main(String[] args) {
        int[] dimensions = {1, 2, 3, 4};
        int n = dimensions.length;

        // Initialize the memoization table with -1
        dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }

        // Calculate the minimum multiplication cost
        System.out.println("Minimum number of multiplications: " + matrixChainOrder(dimensions, 1, n - 1));
    }
}

