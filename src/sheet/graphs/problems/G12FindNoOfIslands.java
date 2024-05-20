package sheet.graphs.problems;


public class G12FindNoOfIslands {
    private static final int[] dx = {-1, 1, 0, 0}; // Directions for row movement (up, down)
    private static final int[] dy = {0, 0, -1, 1}; // Directions for column movement (left, right)

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        G12FindNoOfIslands solver = new G12FindNoOfIslands();
        System.out.println("Number of islands: " + solver.numIslands(grid));
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int numIslands = 0;
        int rows = grid.length, cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    // Start a DFS to sink the island
                    dfs(grid, i, j);
                    numIslands++; // Increment the count of islands
                }
            }
        }

        return numIslands;
    }

    private void dfs(char[][] grid, int x, int y) {
        int rows = grid.length, cols = grid[0].length;

        // Check for invalid or visited indices or water
        if (x < 0 || x >= rows || y < 0 || y >= cols || grid[x][y] == '0') {
            return;
        }

        grid[x][y] = '0'; // Mark the visited cell as water to prevent revisiting

        // Explore all four directions
        for (int dir = 0; dir < 4; dir++) {
            dfs(grid, x + dx[dir], y + dy[dir]);
        }
    }
}

