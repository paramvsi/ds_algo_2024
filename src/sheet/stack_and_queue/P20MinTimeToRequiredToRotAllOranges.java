package sheet.stack_and_queue;


import java.util.LinkedList;
import java.util.Queue;

public class P20MinTimeToRequiredToRotAllOranges {
    public static int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) return -1;
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;

        // Initialize the queue with all rotten orange positions and count fresh oranges
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }

        if (freshCount == 0) return 0; // No fresh oranges to start with

        int minutesPassed = 0;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // Up, down, left, right

        // BFS to rot all reachable oranges
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] point = queue.poll();
                for (int[] direction : directions) {
                    assert point != null;
                    int x = point[0] + direction[0];
                    int y = point[1] + direction[1];

                    if (x >= 0 && y >= 0 && x < rows && y < cols && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        queue.offer(new int[]{x, y});
                        freshCount--;
                    }
                }
            }
            if (!queue.isEmpty()) minutesPassed++;
        }

        // If there are still fresh oranges left, return -1
        return freshCount == 0 ? minutesPassed : -1;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };
        System.out.println("Minimum time required to rot all oranges: " + orangesRotting(grid));
    }
}

