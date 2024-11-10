package sheet.google.gpt_150.day_03;
/*
Given a 2D matrix matrix, handle multiple queries of the following type:

Calculate the sum of elements of the submatrix from (row1, col1) to (row2, col2).
Implement the NumMatrix class:

NumMatrix(int[][] matrix) initializes the object with the integer matrix matrix.
int sumRegion(int row1, int col1, int row2, int col2) returns the sum of the elements of the
submatrix from (row1, col1) to (row2, col2).
*/

public class D11RangeSumQuery2D {
    private int[][] prefixSum;

    public D11RangeSumQuery2D(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        prefixSum = new int[m + 1][n + 1];

        // Compute prefix sum
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                prefixSum[i + 1][j + 1] = matrix[i][j]
                        + prefixSum[i][j + 1]
                        + prefixSum[i + 1][j]
                        - prefixSum[i][j];
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };

        D11RangeSumQuery2D numMatrix = new D11RangeSumQuery2D(matrix);

        System.out.println("Sum of region (2, 1, 4, 3): " + numMatrix.sumRegion(2, 1, 4, 3)); // Output: 8
        System.out.println("Sum of region (1, 1, 2, 2): " + numMatrix.sumRegion(1, 1, 2, 2)); // Output: 11
        System.out.println("Sum of region (1, 2, 2, 4): " + numMatrix.sumRegion(1, 2, 2, 4)); // Output: 12
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return prefixSum[row2 + 1][col2 + 1]
                - prefixSum[row1][col2 + 1]
                - prefixSum[row2 + 1][col1]
                + prefixSum[row1][col1];
    }
}

