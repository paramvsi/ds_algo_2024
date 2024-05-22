package sheet.graphs.problems;

public class G29MColoringProblem {
    private final int V;  // Number of vertices
    private final int[][] graph;  // Graph represented as an adjacency matrix
    private final int[] color;  // Colors assigned to vertices

    public G29MColoringProblem(int[][] graph) {
        this.V = graph.length;
        this.graph = graph;
        this.color = new int[V];
    }

    public static void main(String[] args) {
        int graph[][] = {
                {0, 1, 1, 1},
                {1, 0, 1, 0},
                {1, 1, 0, 1},
                {1, 0, 1, 0},
        };
        G29MColoringProblem coloring = new G29MColoringProblem(graph);
        int m = 3;  // Number of colors
        coloring.solve(m);
    }

    // Check if the current color assignment is safe for vertex v
    private boolean isSafe(int v, int c) {
        for (int i = 0; i < V; i++) {
            if (graph[v][i] == 1 && color[i] == c) {
                return false;
            }
        }
        return true;
    }

    // Utility function to solve m Coloring problem
    private boolean graphColoringUtil(int m, int v) {
        // Base case: If all vertices are assigned a color then return true
        if (v == V) {
            return true;
        }

        // Try different colors for vertex v
        for (int c = 1; c <= m; c++) {
            // Check if assignment of color c to v is fine
            if (isSafe(v, c)) {
                color[v] = c;

                // Recur to assign colors to the rest of the vertices
                if (graphColoringUtil(m, v + 1)) {
                    return true;
                }

                // If there is no way to assign color c to vertex v then remove it (backtrack)
                color[v] = 0;
            }
        }

        // If no color can be assigned to this vertex then return false
        return false;
    }

    public boolean solve(int m) {
        // Initialize colors as 0 meaning no color is assigned
        for (int i = 0; i < V; i++) {
            color[i] = 0;
        }

        // Start solving the problem from vertex 0
        if (!graphColoringUtil(m, 0)) {
            System.out.println("Solution does not exist");
            return false;
        }

        // Print the solution
        printSolution();
        return true;
    }

    private void printSolution() {
        System.out.println("Solution Exists: Following are the assigned colors");
        for (int i = 0; i < V; i++)
            System.out.print("Vertex " + i + " --->  Color " + color[i] + "\n");
    }
}

