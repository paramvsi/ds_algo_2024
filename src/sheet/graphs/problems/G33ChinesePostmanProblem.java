package sheet.graphs.problems;

import java.util.LinkedList;

public class G33ChinesePostmanProblem {
    private final int V;  // Number of vertices
    private final LinkedList<Integer>[] adj;  // Adjacency list

    public G33ChinesePostmanProblem(int V) {
        this.V = V;
        adj = new LinkedList[V];
        for (int i = 0; i < V; ++i)
            adj[i] = new LinkedList<>();
    }

    public static void main(String[] args) {
        G33ChinesePostmanProblem graph = new G33ChinesePostmanProblem(4);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 0);
        graph.addEdge(0, 2);

        graph.findEulerianCircuit();
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    // Check if the graph contains Eulerian Circuit
    private boolean isEulerianCircuit() {
        int odd = 0;
        for (int i = 0; i < V; i++) {
            if (adj[i].size() % 2 != 0)
                odd++;
        }
        return odd == 0;
    }

    // Assuming the graph has been made Eulerian by adding necessary edges
    // Finding Eulerian circuit after making the graph Eulerian
    public void findEulerianCircuit() {
        if (!isEulerianCircuit()) {
            System.out.println("Graph is not Eulerian. Additional steps required to make it Eulerian.");
            // Here you would implement the procedure to add edges (or duplicate edges) to make the graph Eulerian
            return;
        }

        System.out.println("Graph has an Eulerian Circuit.");
        // Use Hierholzer's algorithm to find the Eulerian circuit if the graph is Eulerian
    }
}

