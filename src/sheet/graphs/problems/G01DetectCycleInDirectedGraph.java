package sheet.graphs.problems;


import java.util.ArrayList;
import java.util.List;

public class G01DetectCycleInDirectedGraph {
    private final int V;   // Number of vertices
    private final List<List<Integer>> adj; // Adjacency list

    public G01DetectCycleInDirectedGraph(int V) {
        this.V = V;
        adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());
    }

    public static void main(String[] args) {
        G01DetectCycleInDirectedGraph graph = new G01DetectCycleInDirectedGraph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        if (graph.isCyclic())
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't contain cycle");
    }

    // Function to add an edge into the graph
    public void addEdge(int v, int w) {
        adj.get(v).add(w);
    }

    // A recursive function that uses visited[] and recursionStack[]
    private boolean isCyclicUtil(int i, boolean[] visited, boolean[] recursionStack) {
        // Mark the current node as visited and part of recursion stack
        if (recursionStack[i])
            return true;

        if (visited[i])
            return false;

        visited[i] = true;
        recursionStack[i] = true;
        List<Integer> children = adj.get(i);

        for (Integer c : children)
            if (isCyclicUtil(c, visited, recursionStack))
                return true;

        recursionStack[i] = false;  // remove the vertex from recursion stack

        return false;
    }

    // Returns true if the graph contains a cycle, else false.
    public boolean isCyclic() {
        // Mark all the vertices as not visited and not part of recursion stack
        boolean[] visited = new boolean[V];
        boolean[] recursionStack = new boolean[V];

        // Call the recursive helper function to detect cycle in different DFS trees
        for (int i = 0; i < V; i++)
            if (isCyclicUtil(i, visited, recursionStack))
                return true;

        return false;
    }
}

