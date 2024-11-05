package sheet.google.dynamic_programming.longest_common_sub;


public class LCS04ShortestCommonSuperSequence {

    // Helper function to find the length of the Longest Common Subsequence (LCS)
    public static int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }

    // Function to find the length of the Shortest Common Supersequence (SCS)
    public static int shortestCommonSupersequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        // Find the LCS length
        int lcsLength = longestCommonSubsequence(text1, text2);

        // Calculate SCS length using the formula
        return m + n - lcsLength;
    }

    public static void main(String[] args) {
        String text1 = "abac";
        String text2 = "cab";
        System.out.println("Length of Shortest Common Supersequence: " + shortestCommonSupersequence(text1, text2));  // Expected output: 5
    }
}

