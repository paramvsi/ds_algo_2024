package sheet.google.gpt_150.day_03;
/*
Suppose you have n integers from 1 to n.
We define a beautiful arrangement as an arrangement of the integers such that for every index i (1-indexed),
either:
arr[i] is divisible by i, or
i is divisible by arr[i].*/

public class D04BeautifulArrangement {

    private int count = 0;

    public static void main(String[] args) {
        D04BeautifulArrangement solution = new D04BeautifulArrangement();

        System.out.println("Number of beautiful arrangements for n = 2: " + solution.countArrangement(2)); // Output: 2
        System.out.println("Number of beautiful arrangements for n = 1: " + solution.countArrangement(1)); // Output: 1
        System.out.println("Number of beautiful arrangements for n = 3: " + solution.countArrangement(3)); // Example additional test
    }

    public int countArrangement(int n) {
        boolean[] visited = new boolean[n + 1]; // To keep track of used numbers
        backtrack(n, 1, visited);
        return count;
    }

    private void backtrack(int n, int pos, boolean[] visited) {
        // Base case: If all positions are filled, we found a valid arrangement
        if (pos > n) {
            count++;
            return;
        }

        // Try placing each number at the current position
        for (int num = 1; num <= n; num++) {
            if (!visited[num] && (num % pos == 0 || pos % num == 0)) {
                // Mark as visited and place num at pos
                visited[num] = true;
                backtrack(n, pos + 1, visited);
                visited[num] = false; // Backtrack
            }
        }
    }
}




