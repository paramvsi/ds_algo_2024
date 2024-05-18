package sheet.graphs.problems;


import java.util.ArrayList;
import java.util.List;

public class G07MakingWiredConnections {
    private final List<List<Integer>> adjList; // Adjacency list for graph representation
    private final boolean[] visited; // Track visited nodes

    public G07MakingWiredConnections(int n) {
        adjList = new ArrayList<>(n);
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public static void main(String[] args) {
        G07MakingWiredConnections network = new G07MakingWiredConnections(6);
        network.addConnection(1, 2);
        network.addConnection(2, 3);
        network.addConnection(4, 5);

        System.out.println("Minimum new connections needed: " + network.makeConnections());
    }

    public void addConnection(int u, int v) {
        adjList.get(u - 1).add(v - 1);
        adjList.get(v - 1).add(u - 1);
    }

    private void dfs(int node) {
        visited[node] = true;
        for (int neighbor : adjList.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor);
            }
        }
    }

    public int makeConnections() {
        int numComponents = 0;
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                dfs(i);
                numComponents++;
            }
        }
        return numComponents - 1; // Need (numComponents - 1) edges to connect all components
    }
}

