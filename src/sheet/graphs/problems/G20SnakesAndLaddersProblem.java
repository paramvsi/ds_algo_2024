package sheet.graphs.problems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class G20SnakesAndLaddersProblem {
    // Function to return the minimum number of throws required to win the game
    public static int getMinDiceThrows(int[] moves, int N) {
        int[] visited = new int[N]; // Array to keep track of visited squares
        Queue<QEntry> queue = new LinkedList<>(); // BFS queue

        // The queue entry (qentry) for BFS. It contains the square number and the minimum dice throws to reach the square
        QEntry start = new QEntry();
        start.v = 0; // Start from square 0 (usually represented as square 1)
        start.dist = 0; // No moves initially

        // Mark the start node as visited and enqueue it
        visited[0] = 1;
        queue.add(start);

        // BFS loop
        while (!queue.isEmpty()) {
            QEntry qe = queue.poll();
            int v = qe.v;

            // If the front vertex is the destination vertex
            if (v == N - 1) break;

            // Throw dice for all possible outcomes from 1 to 6
            for (int j = v + 1; j <= (v + 6) && j < N; ++j) {
                // If not already visited
                if (visited[j] == 0) {
                    QEntry a = new QEntry();
                    a.dist = qe.dist + 1;
                    visited[j] = 1;

                    // Check if there's a snake or ladder at 'j'
                    // Otherwise move to j
                    if (moves[j] != -1)
                        a.v = moves[j];
                    else
                        a.v = j;

                    queue.add(a);
                }
            }
        }

        // We reach here when 'qe' has the last vertex
        assert queue.peek() != null;
        return queue.peek().dist;
    }

    public static void main(String[] args) {
        // Let us construct the board given in above diagram
        int N = 100;
        int[] moves = new int[N];
        Arrays.fill(moves, -1);

        // Ladders
        moves[1] = 38;
        moves[4] = 14;
        moves[9] = 31;
        moves[21] = 42;
        moves[28] = 84;
        moves[51] = 67;
        moves[72] = 91;
        moves[80] = 99;

        // Snakes
        moves[17] = 7;
        moves[54] = 34;
        moves[62] = 19;
        moves[64] = 60;
        moves[87] = 36;
        moves[93] = 73;
        moves[95] = 75;
        moves[98] = 79;

        System.out.println("Min Dice throws required is " + getMinDiceThrows(moves, N));
    }

    static class QEntry {
        int v; // Vertex number
        int dist; // Distance of this vertex from source
    }
}

