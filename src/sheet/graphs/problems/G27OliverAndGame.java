package sheet.graphs.problems;


import java.util.ArrayList;
import java.util.List;

public class G27OliverAndGame {
    static int timer;
    static int[] startTime;
    static int[] endTime;
    static List<List<Integer>> graph;

    public static void dfs(int node, int parent) {
        startTime[node] = ++timer; // Entry time
        for (int child : graph.get(node)) {
            if (child != parent) {
                dfs(child, node);
            }
        }
        endTime[node] = timer; // Exit time
    }

    public static boolean canMove(int x, int y, int type) {
        // Type 0 for moving up, type 1 for moving down
        if (type == 1) { // Check if y is a descendant of x
            return startTime[x] <= startTime[y] && endTime[y] <= endTime[x];
        } else { // Check if y is not a descendant of x
            return startTime[y] < startTime[x] || endTime[y] > endTime[x];
        }
    }

    public static void main(String[] args) {
        int n = 5; // Number of nodes
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // Construct the tree
        graph.get(1).add(2);
        graph.get(1).add(3);
        graph.get(3).add(4);
        graph.get(3).add(5);

        // Inverse connections since it's an undirected tree
        graph.get(2).add(1);
        graph.get(3).add(1);
        graph.get(4).add(3);
        graph.get(5).add(3);

        startTime = new int[n + 1];
        endTime = new int[n + 1];
        timer = 0;

        // Running DFS from node 1 (considered as root)
        dfs(1, -1);

        // Queries
        System.out.println("Can move from 1 to 5 downwards: " + canMove(1, 5, 1)); // true
        System.out.println("Can move from 5 to 1 upwards: " + canMove(5, 1, 0)); // true
        System.out.println("Can move from 2 to 5 downwards: " + canMove(2, 5, 1)); // false
    }
}

