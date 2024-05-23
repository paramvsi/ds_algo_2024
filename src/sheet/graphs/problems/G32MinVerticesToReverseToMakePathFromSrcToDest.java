package sheet.graphs.problems;

import java.util.*;

public class G32MinVerticesToReverseToMakePathFromSrcToDest {
    private final int V;  // number of vertices
    private final List<List<Integer>> adj;  // adjacency list

    public G32MinVerticesToReverseToMakePathFromSrcToDest(int V) {
        this.V = V;
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    public static void main(String[] args) {
        G32MinVerticesToReverseToMakePathFromSrcToDest g = new G32MinVerticesToReverseToMakePathFromSrcToDest(4);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 0);
        g.addEdge(0, 2);
        g.addEdge(3, 2);

        int src = 0, dest = 3;
        System.out.println("Minimum edges to reverse to make at least one path from " +
                src + " to " + dest + ": " + g.minReversal(src, dest));
    }

    public void addEdge(int u, int v) {
        adj.get(u).add(v);  // Directed edge from u to v
    }

    // Function to return the minimum number of edges to reverse
    public int minReversal(int src, int dest) {
        // Create a reverse adjacency list
        List<List<Integer>> revAdj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            revAdj.add(new ArrayList<>());
        }
        for (int u = 0; u < V; u++) {
            for (int v : adj.get(u)) {
                revAdj.get(v).add(u);
            }
        }

        // Shortest path computation using modified Dijkstra's algorithm
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));
        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int u = curr.node;

            // Regular edges (original direction)
            for (int v : adj.get(u)) {
                if (dist[v] > dist[u]) {
                    dist[v] = dist[u];
                    pq.add(new Pair(v, dist[v]));
                }
            }

            // Reversed edges
            for (int v : revAdj.get(u)) {
                if (dist[v] > dist[u] + 1) {
                    dist[v] = dist[u] + 1;
                    pq.add(new Pair(v, dist[v]));
                }
            }
        }

        return dist[dest] == Integer.MAX_VALUE ? -1 : dist[dest];
    }

    static class Pair {
        int node, cost;

        Pair(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }
}

