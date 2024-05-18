package sheet.graphs;


import java.util.ArrayList;
import java.util.List;

class GraphUsingAdjacencyList {
    private List<List<Integer>> adjList; // For an unweighted graph
    private List<List<Pair>> adjListWeighted; // For a weighted graph

    // Constructor for unweighted graph
    public GraphUsingAdjacencyList(int numVertices) {
        adjList = new ArrayList<>();
        for (int i = 0; i < numVertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    // Constructor for weighted graph
    public GraphUsingAdjacencyList(int numVertices, boolean isWeighted) {
        adjListWeighted = new ArrayList<>();
        for (int i = 0; i < numVertices; i++) {
            adjListWeighted.add(new ArrayList<>());
        }
    }

    public static void main(String[] args) {
        GraphUsingAdjacencyList graph = new GraphUsingAdjacencyList(5); // Unweighted graph example
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 1);
        graph.addEdge(3, 2);
        graph.addEdge(4, 3);

        graph.printGraph();

        GraphUsingAdjacencyList weightedGraph = new GraphUsingAdjacencyList(5, true); // Weighted graph example
        weightedGraph.addWeightedEdge(0, 1, 10);
        weightedGraph.addWeightedEdge(0, 4, 20);
        weightedGraph.addWeightedEdge(1, 3, 30);
        weightedGraph.addWeightedEdge(1, 4, 40);
        weightedGraph.addWeightedEdge(2, 1, 50);
        weightedGraph.addWeightedEdge(3, 2, 60);
        weightedGraph.addWeightedEdge(4, 3, 70);

        weightedGraph.printWeightedGraph();
    }

    // Add edge for unweighted graph
    public void addEdge(int src, int dest) {
        adjList.get(src).add(dest);
        // For undirected graph, add the line below:
        // adjList.get(dest).add(src);
    }

    // Add edge for weighted graph
    public void addWeightedEdge(int src, int dest, int weight) {
        adjListWeighted.get(src).add(new Pair(dest, weight));
        // For undirected graph, add the line below:
        // adjListWeighted.get(dest).add(new Pair(src, weight));
    }

    // Print adjacency list
    public void printGraph() {
        for (int i = 0; i < adjList.size(); i++) {
            System.out.print(i + " -> ");
            for (Integer v : adjList.get(i)) {
                System.out.print(v + " ");
            }
            System.out.println();
        }
    }

    // Print weighted adjacency list
    public void printWeightedGraph() {
        for (int i = 0; i < adjListWeighted.size(); i++) {
            System.out.print(i + " -> ");
            for (Pair p : adjListWeighted.get(i)) {
                System.out.print("(" + p.vertex + ", " + p.weight + ") ");
            }
            System.out.println();
        }
    }

    // Pair class to handle weighted edges
    static class Pair {
        int vertex;
        int weight;

        Pair(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }
}
