package sheet.graphs;

import java.util.Iterator;
import java.util.LinkedList;

class GraphBFS {
    private final int V;   // Number of vertices
    private final LinkedList<Integer>[] adjList; // Adjacency list

    // Constructor
    GraphBFS(int v) {
        V = v;
        adjList = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adjList[i] = new LinkedList<>();
    }

    public static void main(String args[]) {
        GraphBFS g = new GraphBFS(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Breadth First Traversal (starting from vertex 2)");

        g.BFS(2);
    }

    // Function to add an edge into the graph
    void addEdge(int v, int w) {
        adjList[v].add(w);
    }

    // Function to perform BFS traversal of the graph
    void BFS(int s) {
        // Mark all the vertices as not visited(By default set as false)
        boolean visited[] = new boolean[V];

        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<>();

        // Mark the current node as visited and enqueue it
        visited[s] = true;
        queue.add(s);

        while (queue.size() != 0) {
            // Dequeue a vertex from queue and print it
            s = queue.poll();
            System.out.print(s + " ");

            // Get all adjacent vertices of the dequeued vertex s
            // If an adjacent has not been visited, then mark it visited and enqueue it
            Iterator<Integer> i = adjList[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }
}

