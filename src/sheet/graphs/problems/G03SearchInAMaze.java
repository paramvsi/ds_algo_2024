package sheet.graphs.problems;


public class G03SearchInAMaze {
    private static final int[] rowOffset = {0, 1, 0, -1}; // Right, Down, Left, Up
    private static final int[] colOffset = {1, 0, -1, 0}; // Right, Down, Left, Up

    // Check if the current position is safe to proceed
    private static boolean isSafe(int[][] maze, int x, int y, boolean[][] visited) {
        return (x >= 0) && (x < maze.length) && (y >= 0) && (y < maze[0].length)
                && maze[x][y] == 1 && !visited[x][y];
    }

    // Util function to solve the maze problem using DFS
    private static boolean solveMazeDFS(int[][] maze, int x, int y, int destX, int destY, boolean[][] visited) {
        // If destination is reached
        if (x == destX && y == destY) {
            return true;
        }

        // Mark the current cell as visited
        visited[x][y] = true;

        // Explore all four possible directions
        for (int dir = 0; dir < 4; dir++) {
            int nextX = x + rowOffset[dir];
            int nextY = y + colOffset[dir];

            if (isSafe(maze, nextX, nextY, visited)) {
                if (solveMazeDFS(maze, nextX, nextY, destX, destY, visited)) {
                    return true;
                }
            }
        }

        // Backtrack: Unmark x, y as part of solution path
        visited[x][y] = false;
        return false;
    }

    // Function to start the maze solving process
    public static boolean solveMaze(int[][] maze, int startX, int startY, int destX, int destY) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        return solveMazeDFS(maze, startX, startY, destX, destY, visited);
    }

    public static void main(String[] args) {
        int[][] maze = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 1, 0, 0},
                {1, 1, 1, 1}
        };
        int startX = 0;
        int startY = 0;
        int destX = 3;
        int destY = 3;

        boolean pathExists = solveMaze(maze, startX, startY, destX, destY);
        if (pathExists) {
            System.out.println("Path exists from start to destination.");
        } else {
            System.out.println("No path exists from start to destination.");
        }
    }
}

