package sheet.graphs.problems;

import java.util.Arrays;
import java.util.LinkedList;

public class G19GraphColoringProblem {
    private final int V; // No. of vertices
    private final LinkedList<Integer>[] adj; // Adjacency list

    // Constructor
    G19GraphColoringProblem(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    public static void main(String[] args) {
        G19GraphColoringProblem g1 = new G19GraphColoringProblem(5);
        g1.addEdge(0, 1);
        g1.addEdge(0, 2);
        g1.addEdge(1, 2);
        g1.addEdge(1, 3);
        g1.addEdge(2, 3);
        g1.addEdge(3, 4);
        System.out.println("Coloring of the graph:");
        g1.greedyColoring();
    }

    // Function to add an edge into the graph
    void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v); // Graph is undirected
    }

    // Assigns colors to vertices using a greedy approach
    void greedyColoring() {
        int[] result = new int[V];

        // Initialize all vertices as unassigned
        Arrays.fill(result, -1);

        // Assign the first color to the first vertex
        result[0] = 0;

        // A temporary array to store the available colors. False value of available[cr]
        // indicates that the color cr is assigned to one of its adjacent vertices
        boolean[] available = new boolean[V];

        // Initially, all colors are available
        Arrays.fill(available, true);

        // Assign colors to remaining V-1 vertices
        for (int u = 1; u < V; u++) {
            // Process all adjacent vertices and flag their colors as unavailable
            for (int i : adj[u]) {
                if (result[i] != -1) // If the color is assigned to vertex i
                    available[result[i]] = false;
            }

            // Find the first available color
            int cr;
            for (cr = 0; cr < V; cr++) {
                if (available[cr])
                    break;
            }

            result[u] = cr; // Assign the found color

            // Reset the values back to true for the next iteration
            Arrays.fill(available, true);
        }

        // Print the result
        for (int u = 0; u < V; u++)
            System.out.println("Vertex " + u + " --->  Color " + result[u]);
    }
}

