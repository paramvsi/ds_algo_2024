package sheet.graphs.problems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

class G15ImplementPrimsAlgo {
    int V; // Number of vertices
    LinkedList<Edge>[] adj; // Adjacency list

    // Constructor
    G15ImplementPrimsAlgo(int v) {
        V = v;
        adj = new LinkedList[V];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList<>();
        }
    }

    public static void main(String[] args) {
        G15ImplementPrimsAlgo g = new G15ImplementPrimsAlgo(4);
        g.addEdge(0, 1, 10);
        g.addEdge(0, 2, 6);
        g.addEdge(0, 3, 5);
        g.addEdge(1, 3, 15);
        g.addEdge(2, 3, 4);

        // Function call
        g.primMST();
    }

    // Function to add an edge into the graph
    void addEdge(int src, int dest, int weight) {
        Edge newEdge = new Edge(src, dest, weight);
        adj[src].add(newEdge);
        adj[dest].add(newEdge); // Add this line because the graph is undirected
    }

    // Function to construct and print MST using Prim's algorithm
    void primMST() {
        // Priority queue to store the vertices based on key values
        PriorityQueue<Node> pq = new PriorityQueue<>(V, Comparator.comparingInt(a -> a.key));
        // Array to track vertices in MST
        boolean[] inMST = new boolean[V];
        // Array to store constructed MST
        Edge[] result = new Edge[V];
        // Keys used to pick minimum weight edge in cut
        int[] key = new int[V];

        // Initialize all keys to infinity and fill the priority queue
        Arrays.fill(key, Integer.MAX_VALUE);
        key[0] = 0; // Make key of the first vertex 0 to pick it first
        pq.offer(new Node(0, 0)); // Add the first node to the priority queue

        while (!pq.isEmpty()) {
            Node u = pq.poll();

            inMST[u.vertex] = true; // Include vertex in MST

            // Traverse all vertices adjacent to u
            for (Edge edge : adj[u.vertex]) {
                int v = edge.src == u.vertex ? edge.dest : edge.src;

                // If v is not in MST and weight of (u,v) is smaller than current key of v
                if (!inMST[v] && edge.weight < key[v]) {
                    key[v] = edge.weight;
                    pq.offer(new Node(v, key[v]));
                    result[v] = edge; // Store the edge in result
                }
            }
        }

        // Print edges of MST using result[]
        for (int i = 1; i < V; i++)
            if (result[i] != null)
                System.out.println(result[i].src + " - " + result[i].dest + "  Weight: " + result[i].weight);
    }

    static class Edge {
        int src, dest, weight;

        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    // Class to represent a node in the graph
    static class Node {
        int vertex, key;

        public Node(int vertex, int key) {
            this.vertex = vertex;
            this.key = key;
        }
    }
}

