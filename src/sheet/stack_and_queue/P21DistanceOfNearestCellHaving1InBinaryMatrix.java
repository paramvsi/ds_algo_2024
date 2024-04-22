package sheet.stack_and_queue;

import java.util.LinkedList;
import java.util.Queue;

public class P21DistanceOfNearestCellHaving1InBinaryMatrix {

    public static int[][] updateMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int[][] distances = new int[rows][cols];

        // Initialize the queue with all '1' cells and distances
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                    distances[i][j] = 0;
                } else {
                    distances[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        // Directions array for moving in 4 directions
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        // Process the queue
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentRow = current[0];
            int currentCol = current[1];

            for (int[] direction : directions) {
                int newRow = currentRow + direction[0];
                int newCol = currentCol + direction[1];

                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols &&
                        distances[newRow][newCol] > distances[currentRow][currentCol] + 1) {
                    distances[newRow][newCol] = distances[currentRow][currentCol] + 1;
                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }

        return distances;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };

        int[][] distances = updateMatrix(matrix);

        System.out.println("Updated matrix with distances:");
        for (int[] row : distances) {
            for (int distance : row) {
                System.out.print(distance + " ");
            }
            System.out.println();
        }
    }
}

