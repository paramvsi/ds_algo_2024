package sheet.google.months_6._2;

//  https://leetcode.com/problems/jump-game-iv


import java.util.*;

public class F11JumpGame4 {

    public static void main(String[] args) {
        F11JumpGame4 solution = new F11JumpGame4();

        // Test cases
        System.out.println(solution.minJumps(new int[]{100, -23, -23, 404, 100, 23, 23, 23, 3, 404})); // Output: 3
        System.out.println(solution.minJumps(new int[]{7})); // Output: 0
        System.out.println(solution.minJumps(new int[]{7, 6, 9, 6, 9, 6, 9, 7})); // Output: 1
    }

    public int minJumps(int[] arr) {
        int n = arr.length;
        if (n == 1) return 0; // No jumps needed if there's only one element

        // Map to store indices of each value in the array
        Map<Integer, List<Integer>> valueToIndices = new HashMap<>();
        for (int i = 0; i < n; i++) {
            valueToIndices.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }

        // BFS setup
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        queue.add(0);
        visited[0] = true;

        int steps = 0;

        // BFS traversal
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int current = queue.poll();

                // If we've reached the last index, return the steps
                if (current == n - 1) {
                    return steps;
                }

                // Explore neighbors
                // 1. Left neighbor
                if (current - 1 >= 0 && !visited[current - 1]) {
                    queue.add(current - 1);
                    visited[current - 1] = true;
                }

                // 2. Right neighbor
                if (current + 1 < n && !visited[current + 1]) {
                    queue.add(current + 1);
                    visited[current + 1] = true;
                }

                // 3. Same value jumps
                if (valueToIndices.containsKey(arr[current])) {
                    for (int next : valueToIndices.get(arr[current])) {
                        if (!visited[next]) {
                            queue.add(next);
                            visited[next] = true;
                        }
                    }
                    // Clear the list to avoid redundant processing
                    valueToIndices.remove(arr[current]);
                }
            }

            steps++;
        }

        return -1; // Should never reach here
    }
}

