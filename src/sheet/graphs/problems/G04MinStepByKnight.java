package sheet.graphs.problems;

import java.util.LinkedList;
import java.util.Queue;

class Point {
    int x, y;
    int dist; // distance from the source

    public Point(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}

public class G04MinStepByKnight {
    // Method to check if a position is inside the board and has not been visited
    private static boolean isInside(int x, int y, int N) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    // Returns minimum steps a Knight will take from source to destination
    public static int minStepToReachTarget(int[] knightPos, int[] targetPos, int N) {
        // All possible moves for a Knight
        int[] dx = {-2, -1, 1, 2, -2, -1, 1, 2};
        int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};

        // Queue for BFS
        Queue<Point> q = new LinkedList<>();

        // Push starting position of knight with 0 distance
        q.add(new Point(knightPos[0], knightPos[1], 0));

        boolean[][] visited = new boolean[N][N];
        visited[knightPos[0]][knightPos[1]] = true;

        // Loop until we have one element in queue
        while (!q.isEmpty()) {
            Point t = q.poll();

            // If current cell is equal to target position, return its distance
            if (t.x == targetPos[0] && t.y == targetPos[1])
                return t.dist;

            // Iterate for all possible movements for a knight
            for (int i = 0; i < 8; i++) {
                int x = t.x + dx[i];
                int y = t.y + dy[i];

                // If reachable state is not yet visited and inside board, push that state into queue
                if (isInside(x, y, N) && !visited[x][y]) {
                    visited[x][y] = true;
                    q.add(new Point(x, y, t.dist + 1));
                }
            }
        }
        return Integer.MAX_VALUE; // If destination is not reachable
    }

    public static void main(String[] args) {
        int N = 8; // Dimension of the chessboard
        int[] knightPos = {0, 0}; // starting position of the knight
        int[] targetPos = {7, 7}; // target position
        System.out.println("Minimum steps: " + minStepToReachTarget(knightPos, targetPos, N));
    }
}

