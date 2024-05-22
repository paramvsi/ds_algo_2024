package sheet.graphs.problems;


import java.util.*;

public class G23CheckWhetherGraphIsBiPartiteOrNot {
    private final int V; // Number of vertices
    private final List<Integer>[] adj; // Adjacency list

    public G23CheckWhetherGraphIsBiPartiteOrNot(int V) {
        this.V = V;
        adj = new ArrayList[V];
        for (int i = 0; i < V; ++i) {
            adj[i] = new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        G23CheckWhetherGraphIsBiPartiteOrNot g = new G23CheckWhetherGraphIsBiPartiteOrNot(4);
        g.addEdge(0, 1);
        g.addEdge(0, 3);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        System.out.println("Graph is bipartite: " + g.isBipartite());
    }

    // Function to add an edge into the graph
    void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v); // Since the graph is undirected
    }

    // This function returns true if graph is Bipartite, else false
    boolean isBipartite() {
        int[] colorArr = new int[V];
        Arrays.fill(colorArr, -1); // -1 indicates no color assigned

        // This code is to handle disconnected graph
        for (int i = 0; i < V; i++) {
            if (colorArr[i] == -1) {
                // Start BFS from vertex i
                if (!bfsCheck(i, colorArr))
                    return false;
            }
        }
        return true;
    }

    // Returns true if BFS starting from src leads to a bipartite graph, else false
    private boolean bfsCheck(int src, int[] colorArr) {
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        colorArr[src] = 1; // Start coloring src with 1

        while (!q.isEmpty()) {
            int u = q.poll();

            // Return false if there is a self-loop
            if (adj[u].contains(u))
                return false;

            for (int v : adj[u]) {
                // If no color is assigned to vertex, then assign it the alternate color
                if (colorArr[v] == -1) {
                    colorArr[v] = 1 - colorArr[u];
                    q.add(v);
                }
                // If the vertex has the same color as its adjacent, then the graph is not bipartite
                else if (colorArr[v] == colorArr[u])
                    return false;
            }
        }
        return true;
    }
}

