package sheet.graphs.problems;


import java.util.Arrays;
import java.util.LinkedList;

public class G30VertexCoverProblem {
    private final int V;  // Number of vertices
    private final LinkedList<Integer>[] adj;  // Adjacency list for each vertex

    // Constructor for graph
    public G30VertexCoverProblem(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList<>();
    }

    public static void main(String[] args) {
        // Create a given graph
        G30VertexCoverProblem g = new G30VertexCoverProblem(7); // Example with 7 vertices
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 5);
        g.addEdge(5, 6);

        // Prints vertex cover
        g.printVertexCover();
    }

    // Function to add an edge into the graph
    void addEdge(int v, int w) {
        adj[v].add(w);  // Add w to v's list.
        adj[w].add(v);  // Since the graph is undirected
    }

    // The function to print vertex cover
    void printVertexCover() {
        boolean[] visited = new boolean[V];
        Arrays.fill(visited, false);

        // Consider all edges one by one
        for (int u = 0; u < V; u++) {
            // An edge is only picked when both visited[u] and visited[v] are false
            if (!visited[u]) {
                // Go through all adjacents of u and pick the first not yet visited vertex (say v)
                for (int v : adj[u]) {
                    if (!visited[v]) {
                        // Add the vertices (u, v) to the result set.
                        // We make the vertex u and v visited so that all edges from/to
                        // them would be ignored
                        visited[v] = true;
                        visited[u] = true;
                        System.out.println("Vertex Cover: (" + u + ", " + v + ")");
                        break;
                    }
                }
            }
        }
    }
}
