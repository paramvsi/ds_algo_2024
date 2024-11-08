package sheet.google.dynamic_programming.matrix_chain_multiplication;

// How to identify -> The function can be partitioned from i to k and k+1 to j
// that two function calls are temporary answer, finally we get answer after applying function to temp answer
/*
Matrix Chain Multiplication (MCM) is a classic optimization problem that can be solved
using recursion and dynamic programming. The goal is to find the minimum number of scalar multiplications
needed to multiply a given chain of matrices.
the objective is to determine the most efficient way to multiply these matrices by choosing
an optimal order of multiplication.
*/


public class MCM01Recursion {

    // Recursive function to find the minimum multiplication cost
    public static int matrixChainOrder(int[] p, int i, int j) {
        // Base case: Only one matrix, no multiplication needed
        if (i == j) {
            return 0;
        }

        // Initialize the minimum cost to a very high value
        int minCost = Integer.MAX_VALUE;

        // Try placing the parenthesis at different positions between i and j
        // and recursively calculate the minimum cost for each position
        for (int k = i; k < j; k++) {
            // Calculate the cost of multiplying matrices from i to k and k+1 to j,
            // then add the cost of multiplying the two resulting matrices
            int cost = matrixChainOrder(p, i, k)
                    + matrixChainOrder(p, k + 1, j)
                    + p[i - 1] * p[k] * p[j];

            // Update the minimum cost
            minCost = Math.min(minCost, cost);
        }

        return minCost;
    }

    public static void main(String[] args) {
        int[] dimensions = {1, 2, 3, 4};
        int n = dimensions.length;

        // Calculate minimum multiplication cost for matrices from 1 to n-1
        System.out.println("Minimum number of multiplications: " + matrixChainOrder(dimensions, 1, n - 1));
    }
}

