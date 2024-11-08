package sheet.google.dynamic_programming.matrix_chain_multiplication;

public class MCM04PalindromePartitioningMemo {

    // Memoization table to store minimum cuts for substrings
    private static int[][] dp;

    // Helper function to check if a substring s[start:end+1] is a palindrome
    private static boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // Recursive function with memoization to find the minimum cuts needed for a palindrome partitioning
    public static int minCuts(String s, int start, int end) {
        // Base case: if the substring is a palindrome or has one character, no cuts are needed
        if (start >= end || isPalindrome(s, start, end)) {
            return 0;
        }

        // If the result is already computed, return it
        if (dp[start][end] != -1) {
            return dp[start][end];
        }

        // Initialize the minimum cuts to a large number
        int minCuts = Integer.MAX_VALUE;

        // Try placing a cut at each possible position k
        for (int k = start; k < end; k++) {
            if (isPalindrome(s, start, k)) { // Only partition if s[start:k+1] is a palindrome
                int cuts = 1 + minCuts(s, k + 1, end); // 1 cut + minimum cuts for the right part
                minCuts = Math.min(minCuts, cuts); // Update the minimum cuts
            }
        }

        // Store the computed result in dp table
        dp[start][end] = minCuts;

        return minCuts;
    }

    public static void main(String[] args) {
        String s = "aab";
        int n = s.length();

        // Initialize the memoization table with -1
        dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }

        // Calculate the minimum cuts needed for palindrome partitioning
        System.out.println("Minimum cuts needed for palindrome partitioning: " + minCuts(s, 0, n - 1));
        // Expected output: 1
    }
}

