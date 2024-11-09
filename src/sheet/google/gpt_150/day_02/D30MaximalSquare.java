package sheet.google.gpt_150.day_02;

public class D30MaximalSquare {

    public static void main(String[] args) {
        D30MaximalSquare solution = new D30MaximalSquare();

        char[][] matrix1 = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        System.out.println("Maximal square area: " + solution.maximalSquare(matrix1)); // Output: 4

        char[][] matrix2 = {
                {'0', '1'},
                {'1', '0'}
        };
        System.out.println("Maximal square area: " + solution.maximalSquare(matrix2)); // Output: 1
    }

    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        int maxSide = 0;

        // Fill the DP table
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1; // Cells in the first row or column can only be a side of 1 if they're '1'
                    } else {
                        dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                    }
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }

        // Return the area of the largest square
        return maxSide * maxSide;
    }
}

