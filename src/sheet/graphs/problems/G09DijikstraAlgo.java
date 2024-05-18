package sheet.graphs.problems;


import java.util.*;

class G09DijikstraAlgo {
    private final int V; // Number of vertices
    private final List<List<Node>> adj; // Adjacency list

    G09DijikstraAlgo(int V) {
        this.V = V;
        adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    public static void main(String[] args) {
        G09DijikstraAlgo g = new G09DijikstraAlgo(5);
        g.addEdge(0, 1, 9);
        g.addEdge(0, 2, 6);
        g.addEdge(0, 3, 5);
        g.addEdge(0, 4, 3);
        g.addEdge(2, 1, 2);
        g.addEdge(2, 3, 4);

        g.dijkstra(0);
    }

    void addEdge(int u, int v, int w) {
        adj.get(u).add(new Node(v, w));
        // If the graph is undirected, add the line below:
        // adj.get(v).add(new Node(u, w));
    }

    void dijkstra(int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(V, Comparator.comparingInt(a -> a.weight));
        pq.add(new Node(src, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int u = node.vertex;

            for (Node neighbor : adj.get(u)) {
                int v = neighbor.vertex;
                int weight = neighbor.weight;

                if (dist[v] > dist[u] + weight) {
                    dist[v] = dist[u] + weight;
                    pq.add(new Node(v, dist[v]));
                }
            }
        }

        printSolution(dist);
    }

    void printSolution(int[] dist) {
        System.out.println("Vertex distance from source");
        for (int i = 0; i < V; i++) {
            System.out.println(i + " \t\t " + dist[i]);
        }
    }

    static class Node {
        int vertex, weight;

        Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }
}

