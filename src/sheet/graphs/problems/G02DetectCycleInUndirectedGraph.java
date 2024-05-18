package sheet.graphs.problems;

import java.util.ArrayList;
import java.util.List;

public class G02DetectCycleInUndirectedGraph {
    private final int V;   // Number of vertices
    private final List<List<Integer>> adj; // Adjacency list

    public G02DetectCycleInUndirectedGraph(int V) {
        this.V = V;
        adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());
    }

    public static void main(String[] args) {
        G02DetectCycleInUndirectedGraph graph = new G02DetectCycleInUndirectedGraph(5); // Create a graph with 5 vertices
        graph.addEdge(1, 0);
        graph.addEdge(0, 2);
        graph.addEdge(2, 1);
        graph.addEdge(0, 3);
        graph.addEdge(3, 4);

        if (graph.isCyclic())
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't contain cycle");
    }

    // Function to add an edge into the graph
    public void addEdge(int v, int w) {
        adj.get(v).add(w);
        adj.get(w).add(v); // Since the graph is undirected
    }

    // A recursive function to use DFS to detect cycle in a graph.
    private boolean isCyclicUtil(int v, boolean[] visited, int parent) {
        // Mark the current node as visited
        visited[v] = true;

        // Recur for all the vertices adjacent to this vertex
        for (Integer i : adj.get(v)) {
            // If an adjacent is not visited, then recur for that adjacent
            if (!visited[i]) {
                if (isCyclicUtil(i, visited, v))
                    return true;
            }
            // If an adjacent is visited and not parent of current vertex, then there is a cycle.
            else if (i != parent)
                return true;
        }
        return false;
    }

    // Returns true if the graph contains a cycle, else false.
    public boolean isCyclic() {
        // Mark all the vertices as not visited and not part of recursion stack
        boolean[] visited = new boolean[V];

        // Call the recursive helper function to detect cycle in different DFS trees
        for (int i = 0; i < V; i++)
            if (!visited[i])  // Don't recur for u if it is already visited
                if (isCyclicUtil(i, visited, -1))
                    return true;

        return false;
    }
}

