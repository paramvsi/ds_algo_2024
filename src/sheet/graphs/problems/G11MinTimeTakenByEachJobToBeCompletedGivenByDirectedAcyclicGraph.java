package sheet.graphs.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

class Graph {
    private final int V; // Number of vertices
    private final ArrayList<ArrayList<Integer>> adj; // Adjacency list for storing the graph
    private final int[] jobDuration; // Duration of each job

    public Graph(int v) {
        V = v;
        adj = new ArrayList<>(v);
        jobDuration = new int[v];
        for (int i = 0; i < v; ++i) {
            adj.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v) {
        adj.get(u).add(v);
    }

    public void addJobDuration(int[] durations) {
        System.arraycopy(durations, 0, jobDuration, 0, V);
    }

    public void minimumCompletionTime() {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];
        Arrays.fill(visited, false);

        // Topological Sort
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                topologicalSort(i, visited, stack);
            }
        }

        // Initialize distances to the duration of each job
        int[] earliestCompletion = new int[V];
        Arrays.fill(earliestCompletion, Integer.MIN_VALUE);
        while (!stack.isEmpty()) {
            int u = stack.pop();
            if (earliestCompletion[u] == Integer.MIN_VALUE)
                earliestCompletion[u] = jobDuration[u];
            for (int i : adj.get(u)) {
                if (earliestCompletion[i] < earliestCompletion[u] + jobDuration[i])
                    earliestCompletion[i] = earliestCompletion[u] + jobDuration[i];
            }
        }

        // Print the calculated earliest completion times
        for (int i = 0; i < V; i++) {
            System.out.println("Job " + i + " completed by: " + earliestCompletion[i]);
        }
    }

    private void topologicalSort(int v, boolean[] visited, Stack<Integer> stack) {
        visited[v] = true;
        for (int i : adj.get(v)) {
            if (!visited[i]) {
                topologicalSort(i, visited, stack);
            }
        }
        stack.push(v);
    }
}

public class G11MinTimeTakenByEachJobToBeCompletedGivenByDirectedAcyclicGraph {
    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.addEdge(2, 4);
        g.addEdge(3, 5);
        g.addEdge(4, 5);

        int[] durations = {1, 2, 3, 4, 2, 1};
        g.addJobDuration(durations);

        System.out.println("Minimum time to complete each job:");
        g.minimumCompletionTime();
    }
}

