package sheet.google.dynamic_programming.longest_common_sub;

public class LCS09LongestRepeatingSubsequence {

    // Function to find the length of the longest repeating subsequence
    public static int longestRepeatingSubsequence(String s) {
        int n = s.length();

        // Initialize the dp array
        int[][] dp = new int[n + 1][n + 1];

        // Fill the dp table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == s.charAt(j - 1) && i != j) {
                    // Characters match and indices are different
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // Take the maximum excluding one character
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // The result is in dp[n][n]
        return dp[n][n];
    }

    public static void main(String[] args) {
        String s = "aabb";
        System.out.println("Length of Longest Repeating Subsequence: " + longestRepeatingSubsequence(s));  // Expected output: 2
    }
}

