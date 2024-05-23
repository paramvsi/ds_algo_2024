package sheet.graphs.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class G31SevenBridgeProblem {
    public static void main(String[] args) {
        // Representing the graph as an adjacency list
        Map<String, List<String>> graph = new HashMap<>();
        graph.put("Northern Bank", Arrays.asList("Eastern Island", "Western Island", "Southern Bank"));
        graph.put("Southern Bank", Arrays.asList("Eastern Island", "Western Island", "Northern Bank"));
        graph.put("Eastern Island", Arrays.asList("Northern Bank", "Southern Bank", "Western Island", "Western Island", "Western Island"));
        graph.put("Western Island", Arrays.asList("Northern Bank", "Southern Bank", "Eastern Island", "Eastern Island", "Eastern Island"));

        if (isEulerianPathPossible(graph)) {
            System.out.println("An Eulerian path or circuit is possible.");
        } else {
            System.out.println("No Eulerian path or circuit is possible.");
        }
    }

    private static boolean isEulerianPathPossible(Map<String, List<String>> graph) {
        int oddDegreeVertices = 0;

        // Count vertices with odd degree
        for (String key : graph.keySet()) {
            if (graph.get(key).size() % 2 != 0) {
                oddDegreeVertices++;
            }
        }

        // For Eulerian Path, exactly 0 or 2 vertices should have an odd degree
        return oddDegreeVertices == 0 || oddDegreeVertices == 2;
    }
}
