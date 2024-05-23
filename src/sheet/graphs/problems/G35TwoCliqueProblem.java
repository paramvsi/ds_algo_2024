package sheet.graphs.problems;

import java.util.*;

public class G35TwoCliqueProblem {
    private final int V;  // number of vertices
    private final List<Integer>[] adj;  // adjacency list for graph

    public G35TwoCliqueProblem(int V) {
        this.V = V;
        adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        G35TwoCliqueProblem g = new G35TwoCliqueProblem(5);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 0);
        g.addEdge(1, 3);
        g.addEdge(2, 4);

        if (g.canBeDividedInTwoCliques())
            System.out.println("Yes, it can be divided into two cliques.");
        else
            System.out.println("No, it cannot be divided into two cliques.");
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    // Function to check if the graph is Bipartite
    private boolean isBipartite(int src, int[] colors) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        colors[src] = 1;  // Color the source vertex with color 1

        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int v : adj[u]) {
                if (colors[v] == -1) {  // If not colored
                    colors[v] = 1 - colors[u];  // Assign alternate color
                    queue.add(v);
                } else if (colors[v] == colors[u]) {  // If adjacent vertices have the same color
                    return false;
                }
            }
        }
        return true;
    }

    // Main function to check if the graph can be divided into two cliques
    public boolean canBeDividedInTwoCliques() {
        // Create a complement of the given graph
        G35TwoCliqueProblem complement = new G35TwoCliqueProblem(V);
        for (int u = 0; u < V; u++) {
            Set<Integer> nonAdj = new HashSet<>();
            for (int v = 0; v < V; v++) nonAdj.add(v);
            nonAdj.remove(u);
            for (int neighbor : adj[u]) nonAdj.remove(neighbor);
            for (int v : nonAdj) complement.addEdge(u, v);
        }

        // Check if the complement graph is bipartite
        int[] colors = new int[V];
        Arrays.fill(colors, -1);  // Initialize all colors as -1
        for (int i = 0; i < V; i++) {
            if (colors[i] == -1) {
                if (!complement.isBipartite(i, colors)) {
                    return false;
                }
            }
        }
        return true;
    }
}

