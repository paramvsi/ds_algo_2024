package sheet.graphs.problems;


public class G18TravellingSalesmanProblem {
    // Number of vertices (cities)
    private final int n;
    // Distances between cities, distance[i][j] is the distance from city i to city j
    private final int[][] distance;
    // Memoization table, dp[mask][i] will be storing the minimum cost of visiting cities in mask, ending in city i
    private final int[][] dp;

    public G18TravellingSalesmanProblem(int[][] distance) {
        this.n = distance.length;
        this.distance = distance;
        this.dp = new int[1 << n][n];
        for (int i = 0; i < (1 << n); i++) {
            java.util.Arrays.fill(dp[i], -1);
        }
    }

    public static void main(String[] args) {
        // Example distance matrix
        int[][] distance = {
                {0, 10, 15, 20},
                {10, 0, 35, 25},
                {15, 35, 0, 30},
                {20, 25, 30, 0}
        };
        G18TravellingSalesmanProblem tsp = new G18TravellingSalesmanProblem(distance);
        int minCost = tsp.tsp(1, 0); // Start the tour at the first city
        System.out.println("Minimum cost of the tour is: " + minCost);
    }

    public int tsp(int mask, int pos) {
        if (mask == (1 << n) - 1) {
            // All cities are visited, return cost to return to start city
            return distance[pos][0];
        }
        if (dp[mask][pos] != -1) {
            // Already computed state
            return dp[mask][pos];
        }

        // Set a large number
        int ans = Integer.MAX_VALUE;
        // Try to go to an unvisited city
        for (int city = 0; city < n; city++) {
            if ((mask & (1 << city)) == 0) {
                int newAns = distance[pos][city] + tsp(mask | (1 << city), city);
                ans = Math.min(ans, newAns);
            }
        }

        return dp[mask][pos] = ans;
    }
}

