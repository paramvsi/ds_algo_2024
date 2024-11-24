package sheet.google.months_6._2;

//  https://leetcode.com/problems/cracking-the-safe

import java.util.HashSet;
import java.util.Set;

public class F07CrackingTheSafe {

    public static void main(String[] args) {
        F07CrackingTheSafe solution = new F07CrackingTheSafe();

        // Test cases
        System.out.println(solution.crackSafe(2, 2)); // Output: "00110" or other valid De Bruijn sequence
        System.out.println(solution.crackSafe(2, 1)); // Output: "01"
        System.out.println(solution.crackSafe(3, 2)); // Output: "001122..." (depending on valid sequence)
    }

    public String crackSafe(int n, int k) {
        // Start with a string of k '0's
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < k; i++) {
            result.append("0");
        }

        // Visited set to track edges
        Set<String> visited = new HashSet<>();
        visited.add(result.toString());

        // Total combinations to generate
        int totalCombinations = (int) Math.pow(n, k);

        // Perform DFS to find the shortest sequence
        dfs(result, visited, totalCombinations, n, k);

        return result.toString();
    }

    private boolean dfs(StringBuilder result, Set<String> visited, int totalCombinations, int n, int k) {
        if (visited.size() == totalCombinations) {
            return true; // All combinations are included
        }

        // Get the last k-1 characters of the current sequence
        String prev = result.substring(result.length() - k + 1);

        // Try all possible digits
        for (int i = 0; i < n; i++) {
            String next = prev + i; // Form the next edge

            if (!visited.contains(next)) {
                // Visit the edge
                visited.add(next);
                result.append(i);

                // Recurse
                if (dfs(result, visited, totalCombinations, n, k)) {
                    return true;
                }

                // Backtrack
                visited.remove(next);
                result.deleteCharAt(result.length() - 1);
            }
        }

        return false;
    }
}

