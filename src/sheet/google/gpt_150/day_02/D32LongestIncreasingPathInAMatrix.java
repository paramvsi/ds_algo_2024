package sheet.google.gpt_150.day_02;


public class D32LongestIncreasingPathInAMatrix {

    public static void main(String[] args) {
        D32LongestIncreasingPathInAMatrix solution = new D32LongestIncreasingPathInAMatrix();

        int[][] matrix1 = {
                {9, 9, 4},
                {6, 6, 8},
                {2, 1, 1}
        };
        System.out.println("Longest increasing path length: " + solution.longestIncreasingPath(matrix1)); // Output: 4

        int[][] matrix2 = {
                {3, 4, 5},
                {3, 2, 6},
                {2, 2, 1}
        };
        System.out.println("Longest increasing path length: " + solution.longestIncreasingPath(matrix2)); // Output: 4
    }

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] memo = new int[rows][cols];
        int maxLength = 0;

        // Start DFS from each cell
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                maxLength = Math.max(maxLength, dfs(matrix, i, j, memo));
            }
        }

        return maxLength;
    }

    // DFS function to find longest increasing path from (i, j)
    private int dfs(int[][] matrix, int i, int j, int[][] memo) {
        // If already computed, return the stored result
        if (memo[i][j] != 0) {
            return memo[i][j];
        }

        int maxPath = 1; // Each cell alone is a path of length 1
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // Right, Down, Left, Up

        // Explore all 4 directions
        for (int[] dir : directions) {
            int newRow = i + dir[0];
            int newCol = j + dir[1];

            // Move to the neighboring cell if it's within bounds and has a greater value
            if (newRow >= 0 && newRow < matrix.length && newCol >= 0 && newCol < matrix[0].length
                    && matrix[newRow][newCol] > matrix[i][j]) {
                maxPath = Math.max(maxPath, 1 + dfs(matrix, newRow, newCol, memo));
            }
        }

        // Memoize the result
        memo[i][j] = maxPath;
        return maxPath;
    }
}

