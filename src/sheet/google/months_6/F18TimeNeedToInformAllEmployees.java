package sheet.google.months_6;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//   https://leetcode.com/problems/time-needed-to-inform-all-employees
public class F18TimeNeedToInformAllEmployees {
    public static void main(String[] args) {
        F18TimeNeedToInformAllEmployees solution = new F18TimeNeedToInformAllEmployees();

        // Example 1
        int n1 = 6, headID1 = 2;
        int[] manager1 = {2, 2, -1, 2, 2, 2};
        int[] informTime1 = {0, 0, 1, 0, 0, 0};
        System.out.println(solution.numOfMinutes(n1, headID1, manager1, informTime1)); // Output: 1

        // Example 2
        int n2 = 7, headID2 = 6;
        int[] manager2 = {1, 2, 3, 4, 5, 6, -1};
        int[] informTime2 = {0, 6, 5, 4, 3, 2, 1};
        System.out.println(solution.numOfMinutes(n2, headID2, manager2, informTime2)); // Output: 21
    }

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        // Step 1: Build adjacency list
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.putIfAbsent(manager[i], new ArrayList<>());
            graph.get(manager[i]).add(i);
        }

        // Step 2: DFS to calculate maximum inform time
        return dfs(headID, graph, informTime);
    }

    private int dfs(int current, Map<Integer, List<Integer>> graph, int[] informTime) {
        int maxTime = 0;

        // Traverse all subordinates
        for (int subordinate : graph.getOrDefault(current, new ArrayList<>())) {
            maxTime = Math.max(maxTime, dfs(subordinate, graph, informTime));
        }

        // Add the current employee's inform time
        return maxTime + informTime[current];
    }
}
