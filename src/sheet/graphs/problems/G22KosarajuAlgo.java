package sheet.graphs.problems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class G22KosarajuAlgo {
    private final int V; // Number of vertices
    private final LinkedList<Integer>[] adj; // Adjacency list for graph

    G22KosarajuAlgo(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    public static void main(String args[]) {
        // Create a graph given in the above diagram
        G22KosarajuAlgo g = new G22KosarajuAlgo(5);
        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(3, 4);

        System.out.println("Following are strongly connected components " +
                "in given graph ");
        g.printSCCs();
    }

    // Function to add an edge into the graph
    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    // DFS function
    void DFSUtil(int v, boolean[] visited, Stack stack) {
        // Mark the current node as visited and print it
        visited[v] = true;

        // Recur for all vertices adjacent to this vertex
        for (int n : adj[v]) {
            if (!visited[n])
                DFSUtil(n, visited, stack);
        }

        // All vertices reachable from v are processed, push v to Stack
        if (stack != null)
            stack.push(v);
    }

    // Function that returns reverse (or transpose) of this graph
    G22KosarajuAlgo getTranspose() {
        G22KosarajuAlgo g = new G22KosarajuAlgo(V);
        for (int v = 0; v < V; v++) {
            // Recur for all the vertices adjacent to this vertex
            for (int i : adj[v]) {
                g.adj[i].add(v);
            }
        }
        return g;
    }

    // The main function that finds and prints all strongly connected components
    void printSCCs() {
        Stack stack = new Stack();

        // Mark all the vertices as not visited (For first DFS)
        boolean[] visited = new boolean[V];
        Arrays.fill(visited, false);

        // Fill vertices in stack according to their finishing times
        for (int i = 0; i < V; i++)
            if (!visited[i])
                DFSUtil(i, visited, stack);

        // Create a reversed graph
        G22KosarajuAlgo gr = getTranspose();

        // Mark all the vertices as not visited (For second DFS)
        Arrays.fill(visited, false);

        // Now process all vertices in order defined by Stack
        while (!stack.empty()) {
            // Pop a vertex from stack
            int v = (int) stack.pop();

            // Print Strongly connected component of the popped vertex
            if (!visited[v]) {
                gr.DFSUtil(v, visited, null);
                System.out.println();
            }
        }
    }
}

