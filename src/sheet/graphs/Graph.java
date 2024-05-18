package sheet.graphs;

public class Graph {
    private final int[][] adjMatrix;
    private final int numVertices;

    // Constructor
    public Graph(int numVertices) {
        this.numVertices = numVertices;
        adjMatrix = new int[numVertices][numVertices];
    }

    // Example usage
    public static void main(String[] args) {
        Graph graph = new Graph(4); // Example for 4 vertices
        graph.addEdge(0, 1, 1); // Add edge with weight 1 (unweighted would just use 1)
        graph.addEdge(0, 2, 1);
        graph.addEdge(1, 3, 1);
        graph.addEdge(2, 3, 1);
        graph.addEdge(3, 0, 1);

        graph.printMatrix();
    }

    // Add edges
    public void addEdge(int i, int j, int weight) {
        adjMatrix[i][j] = weight;
    }

    // Print the matrix
    public void printMatrix() {
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}

