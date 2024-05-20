package sheet.graphs.problems;
import java.util.*;

public class G13GivenSortedDicOfAlienCharsFindOrderOfChars {
    public static void main(String[] args) {
        G13GivenSortedDicOfAlienCharsFindOrderOfChars ad = new G13GivenSortedDicOfAlienCharsFindOrderOfChars();
        String[] words = {"wrt", "wrf", "er", "ett", "rftt"};
        System.out.println("The order of characters: " + ad.alienOrder(words));
    }

    public String alienOrder(String[] words) {
        // Build graph and a map to count in-degrees
        Map<Character, List<Character>> graph = new HashMap<>();
        Map<Character, Integer> degree = new HashMap<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                graph.putIfAbsent(c, new ArrayList<>());
                degree.putIfAbsent(c, 0);
            }
        }

        // Find all edges
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i], word2 = words[i + 1];
            int len = Math.min(word1.length(), word2.length());
            for (int j = 0; j < len; j++) {
                char parent = word1.charAt(j), child = word2.charAt(j);
                if (parent != child) {
                    graph.get(parent).add(child);
                    degree.put(child, degree.get(child) + 1);
                    break;
                }
                if (j + 1 == len && word1.length() > word2.length()) {
                    // Case where the second word is a prefix of the first, and the first is longer (invalid case)
                    return "";
                }
            }
        }

        // Topological sort using BFS (Kahn's Algorithm)
        StringBuilder order = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();
        for (char c : degree.keySet()) {
            if (degree.get(c) == 0) {
                queue.add(c);
            }
        }

        while (!queue.isEmpty()) {
            char c = queue.poll();
            order.append(c);
            for (char next : graph.get(c)) {
                degree.put(next, degree.get(next) - 1);
                if (degree.get(next) == 0) {
                    queue.add(next);
                }
            }
        }

        if (order.length() < degree.size()) {
            return ""; // There is a cycle
        }
        return order.toString();
    }
}

