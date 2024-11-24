package sheet.google.months_6._2;

//  https://leetcode.com/problems/cherry-pickup-ii


public class F09CherryPickUp2 {

    public static void main(String[] args) {
        F09CherryPickUp2 solution = new F09CherryPickUp2();

        // Test case 1
        int[][] grid1 = {
                {3, 1, 1},
                {2, 5, 1},
                {1, 5, 5},
                {2, 1, 1}
        };
        System.out.println(solution.cherryPickup(grid1)); // Output: 24

        // Test case 2
        int[][] grid2 = {
                {1, 0, 0, 0, 0, 0, 1},
                {2, 0, 0, 0, 0, 3, 0},
                {2, 0, 9, 0, 0, 0, 0},
                {0, 3, 0, 5, 4, 0, 0},
                {1, 0, 2, 3, 0, 0, 6}
        };
        System.out.println(solution.cherryPickup(grid2)); // Output: 28
    }

    public int cherryPickup(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        // DP array: dp[row][col1][col2] stores max cherries collected at row with robots at col1 and col2
        int[][][] dp = new int[rows][cols][cols];

        // Initialize the DP array
        for (int row = rows - 1; row >= 0; row--) {
            for (int col1 = 0; col1 < cols; col1++) {
                for (int col2 = 0; col2 < cols; col2++) {
                    // Base case: Last row
                    if (row == rows - 1) {
                        dp[row][col1][col2] = (col1 == col2) ? grid[row][col1] : grid[row][col1] + grid[row][col2];
                    } else {
                        // Transition for other rows
                        int maxCherries = 0;

                        // Try all possible movements for both robots
                        for (int move1 = -1; move1 <= 1; move1++) {
                            for (int move2 = -1; move2 <= 1; move2++) {
                                int newCol1 = col1 + move1;
                                int newCol2 = col2 + move2;

                                // Check if the new positions are valid
                                if (newCol1 >= 0 && newCol1 < cols && newCol2 >= 0 && newCol2 < cols) {
                                    maxCherries = Math.max(maxCherries, dp[row + 1][newCol1][newCol2]);
                                }
                            }
                        }

                        // Add cherries at the current positions
                        dp[row][col1][col2] = maxCherries + ((col1 == col2) ? grid[row][col1] : grid[row][col1] + grid[row][col2]);
                    }
                }
            }
        }

        // The result is stored in dp[0][0][cols - 1]
        return dp[0][0][cols - 1];
    }
}
