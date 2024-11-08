package sheet.google.backtracking;

/*
The "Rat in a Maze" problem is a classic backtracking problem where a rat needs
to find a path from the top-left corner of a maze to the bottom-right corner, moving only in specific
directions (typically up, down, left, and right).
The maze is represented as a 2D matrix where 1
indicates a path and 0 indicates an obstacle.
*/


import java.util.ArrayList;
import java.util.List;

public class B04RatInAMaze {
    public static void main(String[] args) {
        int[][] maze = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 1, 0, 0},
                {1, 1, 1, 1}
        };
        List<String> paths = findPaths(maze);
        System.out.println("Possible paths:");
        for (String path : paths) {
            System.out.println(path);
        }
    }

    // Method to initiate path-finding
    public static List<String> findPaths(int[][] maze) {
        List<String> paths = new ArrayList<>();
        int n = maze.length;
        if (maze[0][0] == 1) { // Start only if the starting cell is not blocked
            boolean[][] visited = new boolean[n][n];
            findPath(maze, 0, 0, "", visited, paths);
        }
        return paths;
    }

    // Recursive function to find paths
    public static void findPath(int[][] maze, int row, int col, String path, boolean[][] visited, List<String> paths) {
        int n = maze.length;

        // Base case: if the rat has reached the bottom-right corner, add the path to the list
        if (row == n - 1 && col == n - 1) {
            paths.add(path);
            return;
        }

        // Mark the current cell as visited
        visited[row][col] = true;

        // Moving Down
        if (isSafe(maze, row + 1, col, visited)) {
            findPath(maze, row + 1, col, path + "D", visited, paths);
        }

        // Moving Left
        if (isSafe(maze, row, col - 1, visited)) {
            findPath(maze, row, col - 1, path + "L", visited, paths);
        }

        // Moving Right
        if (isSafe(maze, row, col + 1, visited)) {
            findPath(maze, row, col + 1, path + "R", visited, paths);
        }

        // Moving Up
        if (isSafe(maze, row - 1, col, visited)) {
            findPath(maze, row - 1, col, path + "U", visited, paths);
        }

        // Backtrack: Unmark the current cell as visited
        visited[row][col] = false;
    }

    // Helper method to check if a cell is safe for the rat to enter
    public static boolean isSafe(int[][] maze, int row, int col, boolean[][] visited) {
        int n = maze.length;
        return (row >= 0 && row < n && col >= 0 && col < n && maze[row][col] == 1 && !visited[row][col]);
    }
}

