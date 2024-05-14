package sheet.trees.problems;


import java.util.ArrayList;
import java.util.List;

public class T23CheckIfGivenGraphIsTreeOrNot {

    // Function to add an edge to the graph
    static void addEdge(List<List<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    // Function to check if the graph contains a cycle using DFS
    static boolean hasCycle(List<List<Integer>> adj, boolean[] visited, int v, int parent) {
        visited[v] = true;

        for (Integer neighbor : adj.get(v)) {
            if (!visited[neighbor]) {
                if (hasCycle(adj, visited, neighbor, v)) {
                    return true;
                }
            } else if (neighbor != parent) {
                return true;
            }
        }

        return false;
    }

    // Function to check if the graph is connected using DFS
    static void dfs(List<List<Integer>> adj, boolean[] visited, int v) {
        visited[v] = true;

        for (Integer neighbor : adj.get(v)) {
            if (!visited[neighbor]) {
                dfs(adj, visited, neighbor);
            }
        }
    }

    // Function to check if the given graph is a tree or not
    static boolean isTree(List<List<Integer>> adj, int V) {
        boolean[] visited = new boolean[V];

        // Check for cycle in the graph
        if (hasCycle(adj, visited, 0, -1)) {
            return false;
        }

        // Reset visited array
        visited = new boolean[V];

        // Check if the graph is connected
        dfs(adj, visited, 0);
        for (boolean v : visited) {
            if (!v) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int V = 5;
        List<List<Integer>> adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        addEdge(adj, 0, 1);
        addEdge(adj, 0, 2);
        addEdge(adj, 1, 3);
        addEdge(adj, 1, 4);

        if (isTree(adj, V)) {
            System.out.println("The graph is a tree.");
        } else {
            System.out.println("The graph is not a tree.");
        }
    }
}

