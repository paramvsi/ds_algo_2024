package sheet.graphs.problems;

import java.util.ArrayList;
import java.util.List;

public class G34NoOfTrianglesInDirectedGraph {
    private final int V; // Number of vertices
    private final List<Integer>[] adj; // Adjacency list for each vertex

    public G34NoOfTrianglesInDirectedGraph(int v) {
        V = v;
        adj = new ArrayList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        G34NoOfTrianglesInDirectedGraph g = new G34NoOfTrianglesInDirectedGraph(4);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Total triangles: " + g.countTriangles());
    }

    public void addEdge(int v, int w) {
        adj[v].add(w); // Add w to v's list.
    }

    public int countTriangles() {
        int count = 0;

        // Check every triplet (u, v, w)
        for (int u = 0; u < V; u++) {
            for (int v = 0; v < adj[u].size(); v++) {
                for (int w = 0; w < adj[v].size(); w++) {
                    // Check if u->v, v->w and w->u form a triangle
                    if (adj[w].contains(u)) {
                        count++;
                    }
                }
            }
        }

        // Since each triangle is counted 3 times
        return count / 3;
    }
}

