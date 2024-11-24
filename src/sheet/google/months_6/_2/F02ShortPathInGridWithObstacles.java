package sheet.google.months_6._2;

//  https://leetcode.com/problems/shortest-path-in-a-grid-with-obstacles-elimination

import java.util.LinkedList;
import java.util.Queue;

public class F02ShortPathInGridWithObstacles {
    public static void main(String[] args) {
        F02ShortPathInGridWithObstacles solution = new F02ShortPathInGridWithObstacles();

        // Example 1
        int[][] grid1 = {
                {0, 0, 0},
                {1, 1, 0},
                {0, 0, 0},
                {0, 1, 1},
                {0, 0, 0}
        };
        int k1 = 1;
        System.out.println(solution.shortestPath(grid1, k1)); // Output: 6

        // Example 2
        int[][] grid2 = {
                {0, 1, 1},
                {1, 1, 1},
                {1, 0, 0}
        };
        int k2 = 1;
        System.out.println(solution.shortestPath(grid2, k2)); // Output: -1
    }

    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        // Directions for moving up, down, left, right
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        // Queue for BFS: [x, y, obstacles_eliminated, steps]
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 0, 0}); // Starting point

        // Visited array: visited[x][y][obstacles_eliminated]
        boolean[][][] visited = new boolean[m][n][k + 1];
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0], y = current[1];
            int obstaclesEliminated = current[2], steps = current[3];

            // If we reach the bottom-right corner, return the steps
            if (x == m - 1 && y == n - 1) {
                return steps;
            }

            // Explore neighbors
            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                // Check if the new cell is within bounds
                if (newX >= 0 && newX < m && newY >= 0 && newY < n) {
                    int newObstaclesEliminated = obstaclesEliminated + grid[newX][newY];

                    // Only proceed if we haven't visited this state and it's valid
                    if (newObstaclesEliminated <= k && !visited[newX][newY][newObstaclesEliminated]) {
                        visited[newX][newY][newObstaclesEliminated] = true;
                        queue.offer(new int[]{newX, newY, newObstaclesEliminated, steps + 1});
                    }
                }
            }
        }

        // If we exhaust the queue without reaching the target, return -1
        return -1;
    }
}

