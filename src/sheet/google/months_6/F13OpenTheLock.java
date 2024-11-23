package sheet.google.months_6;

//  https://leetcode.com/problems/open-the-lock


import java.util.*;

public class F13OpenTheLock {
    public static void main(String[] args) {
        F13OpenTheLock solution = new F13OpenTheLock();

        // Test case 1
        String[] deadends1 = {"0201", "0101", "0102", "1212", "2002"};
        String target1 = "0202";
        System.out.println(solution.openLock(deadends1, target1)); // Output: 6

        // Test case 2
        String[] deadends2 = {"8888"};
        String target2 = "0009";
        System.out.println(solution.openLock(deadends2, target2)); // Output: 1

        // Test case 3
        String[] deadends3 = {"8888"};
        String target3 = "8888";
        System.out.println(solution.openLock(deadends3, target3)); // Output: -1
    }

    public int openLock(String[] deadends, String target) {
        Set<String> deadSet = new HashSet<>(Arrays.asList(deadends));
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        // Start from "0000"
        queue.add("0000");
        visited.add("0000");

        // If "0000" is a deadend, return -1
        if (deadSet.contains("0000")) {
            return -1;
        }

        int steps = 0;

        // BFS
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String current = queue.poll();

                // If we reach the target, return the number of steps
                if (current.equals(target)) {
                    return steps;
                }

                // Generate all possible neighbors
                for (String neighbor : getNeighbors(current)) {
                    if (!visited.contains(neighbor) && !deadSet.contains(neighbor)) {
                        queue.add(neighbor);
                        visited.add(neighbor);
                    }
                }
            }

            steps++;
        }

        // If target is not reachable
        return -1;
    }

    // Helper function to generate neighbors
    private List<String> getNeighbors(String current) {
        List<String> neighbors = new ArrayList<>();
        char[] chars = current.toCharArray();

        for (int i = 0; i < 4; i++) {
            char original = chars[i];

            // Turn the wheel up
            chars[i] = original == '9' ? '0' : (char) (original + 1);
            neighbors.add(new String(chars));

            // Turn the wheel down
            chars[i] = original == '0' ? '9' : (char) (original - 1);
            neighbors.add(new String(chars));

            // Reset to original
            chars[i] = original;
        }

        return neighbors;
    }
}

