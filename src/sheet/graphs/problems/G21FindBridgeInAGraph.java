package sheet.graphs.problems;

import java.util.Arrays;
import java.util.LinkedList;

public class G21FindBridgeInAGraph {
    private final int V; // No. of vertices
    private final LinkedList<Integer>[] adj; // Adjacency list
    private int time = 0; // Time variable used by DFS

    // Constructor
    public G21FindBridgeInAGraph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    public static void main(String[] args) {
        System.out.println("Bridges in first graph ");
        G21FindBridgeInAGraph g1 = new G21FindBridgeInAGraph(5);
        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(2, 1);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);
        g1.findBridges();

        System.out.println("\nBridges in second graph");
        G21FindBridgeInAGraph g2 = new G21FindBridgeInAGraph(4);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        g2.addEdge(2, 3);
        g2.findBridges();
    }

    // Function to add an edge into the graph
    void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    // DFS function to find and print bridges
    private void bridgeUtil(int u, boolean[] visited, int[] discovery, int[] low, int[] parent) {
        // Mark the current node as visited
        visited[u] = true;

        // Initialize discovery time and low value
        discovery[u] = low[u] = ++time;

        // Go through all vertices adjacent to this
        for (int v : adj[u]) {
            if (!visited[v]) {
                parent[v] = u;
                bridgeUtil(v, visited, discovery, low, parent);

                // Check if the subtree rooted at v has a connection back to one of ancestors of u
                low[u] = Math.min(low[u], low[v]);

                // If the lowest vertex reachable from subtree under v is below u in DFS tree, then u-v is a bridge
                if (low[v] > discovery[u])
                    System.out.println(u + " " + v);
            }

            // Update low value of u for parent function calls.
            else if (v != parent[u])
                low[u] = Math.min(low[u], discovery[v]);
        }
    }

    // Function to find and print all bridges
    void findBridges() {
        // Mark all the vertices as not visited
        boolean[] visited = new boolean[V];
        int[] discovery = new int[V];
        int[] low = new int[V];
        int[] parent = new int[V];

        // Initialize parent and visited arrays
        Arrays.fill(parent, -1);
        Arrays.fill(visited, false);

        // Call the recursive helper function to find Bridges in DFS tree rooted with vertex 'i'
        for (int i = 0; i < V; i++)
            if (!visited[i])
                bridgeUtil(i, visited, discovery, low, parent);
    }
}

