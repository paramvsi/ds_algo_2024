package sheet.graphs.problems;

import java.util.ArrayList;
import java.util.List;

public class G25JourneyToTheMoon {
    private static List<List<Integer>> adj; // Graph adjacency list
    private static boolean[] visited;       // Visited array

    public static void main(String[] args) {
        int n = 100; // Total number of astronauts
        int[][] astronautPairs = {{0, 2}, {1, 8}, {1, 4}, {2, 8}, {2, 6}, {3, 5}, {6, 9}}; // Pairs from the same country

        System.out.println(journeyToTheMoon(n, astronautPairs));
    }

    public static long journeyToTheMoon(int n, int[][] astronautPairs) {
        adj = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Build the graph
        for (int[] pair : astronautPairs) {
            adj.get(pair[0]).add(pair[1]);
            adj.get(pair[1]).add(pair[0]);
        }

        visited = new boolean[n];
        List<Integer> componentSizes = new ArrayList<>();

        // Find all connected components
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                componentSizes.add(dfs(i));
            }
        }

        // Calculate the total number of pairs
        long totalPairs = (long) n * (n - 1) / 2;
        for (int size : componentSizes) {
            long pairsWithinComponent = (long) size * (size - 1) / 2;
            totalPairs -= pairsWithinComponent;
        }

        return totalPairs;
    }

    private static int dfs(int node) {
        int size = 1;
        visited[node] = true;
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                size += dfs(neighbor);
            }
        }
        return size;
    }
}

