package sheet.graphs.problems;

import java.util.Arrays;

class G24DetectNegativeCycleInAGraph {
    int V, E;
    Edge[] edges;

    public G24DetectNegativeCycleInAGraph(int v, int e) {
        V = v;
        E = e;
        edges = new Edge[E];
    }

    public static void main(String[] args) {
        int V = 4, E = 4;
        G24DetectNegativeCycleInAGraph graph = new G24DetectNegativeCycleInAGraph(V, E);
        graph.addEdge(0, 0, 1, 1);
        graph.addEdge(1, 1, 2, -1);
        graph.addEdge(2, 2, 3, -1);
        graph.addEdge(3, 3, 1, -1);

        if (graph.isNegativeCycleBellmanFord(0))
            System.out.println("Graph contains negative weight cycle");
        else
            System.out.println("Graph does not contain negative weight cycle");
    }

    void addEdge(int index, int src, int dest, int weight) {
        edges[index] = new Edge(src, dest, weight);
    }

    boolean isNegativeCycleBellmanFord(int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for (int i = 1; i < V; i++) {
            for (int j = 0; j < E; j++) {
                int u = edges[j].src;
                int v = edges[j].dest;
                int weight = edges[j].weight;
                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                }
            }
        }

        // Check for negative-weight cycles.
        for (int j = 0; j < E; ++j) {
            int u = edges[j].src;
            int v = edges[j].dest;
            int weight = edges[j].weight;
            if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                return true;
            }
        }
        return false;
    }

    static class Edge {
        int src, dest, weight;

        Edge(int s, int d, int w) {
            src = s;
            dest = d;
            weight = w;
        }
    }
}

