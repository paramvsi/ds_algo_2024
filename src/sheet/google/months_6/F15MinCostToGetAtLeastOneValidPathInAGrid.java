package sheet.google.months_6;

// https://leetcode.com/problems/minimum-cost-to-make-at-least-one-valid-path-in-a-grid/description/


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class F15MinCostToGetAtLeastOneValidPathInAGrid {
    public static void main(String[] args) {
        F15MinCostToGetAtLeastOneValidPathInAGrid solution = new F15MinCostToGetAtLeastOneValidPathInAGrid();

        // Test case 1
        int[][] grid1 = {
                {1, 1, 1},
                {3, 2, 2},
                {1, 1, 4}
        };
        System.out.println(solution.minCost(grid1)); // Output: 0

        // Test case 2
        int[][] grid2 = {
                {1, 2},
                {4, 3}
        };
        System.out.println(solution.minCost(grid2)); // Output: 1
    }

    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Directions map
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        // Cost array
        int[][] cost = new int[m][n];
        for (int[] row : cost) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        cost[0][0] = 0;

        // Deque for 0-1 BFS
        Deque<int[]> deque = new ArrayDeque<>();
        deque.offer(new int[]{0, 0});

        // BFS
        while (!deque.isEmpty()) {
            int[] current = deque.pollFirst();
            int x = current[0];
            int y = current[1];

            // Explore all 4 directions
            for (int d = 0; d < 4; d++) {
                int newX = x + directions[d][0];
                int newY = y + directions[d][1];

                if (newX >= 0 && newX < m && newY >= 0 && newY < n) {
                    int newCost = cost[x][y] + (grid[x][y] == d + 1 ? 0 : 1);
                    if (newCost < cost[newX][newY]) {
                        cost[newX][newY] = newCost;
                        if (grid[x][y] == d + 1) {
                            deque.offerFirst(new int[]{newX, newY}); // 0-cost move
                        } else {
                            deque.offerLast(new int[]{newX, newY}); // 1-cost move
                        }
                    }
                }
            }
        }

        return cost[m - 1][n - 1];
    }
}
