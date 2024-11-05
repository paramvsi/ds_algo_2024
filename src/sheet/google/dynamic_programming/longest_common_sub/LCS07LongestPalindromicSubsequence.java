package sheet.google.dynamic_programming.longest_common_sub;

public class LCS07LongestPalindromicSubsequence {

    // Helper function to find the LCS of two strings
    private static int longestCommonSubsequence(String a, String b) {
        int m = a.length();
        int n = b.length();

        // Initialize the dp array
        int[][] dp = new int[m + 1][n + 1];

        // Fill the dp table based on LCS logic
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }

    // Function to find the longest palindromic subsequence in string s
    public static int longestPalindromicSubsequence(String s) {
        // Reverse the string
        String reverse_s = new StringBuilder(s).reverse().toString();

        // Find the LCS between the string and its reverse
        return longestCommonSubsequence(s, reverse_s);
    }

    public static void main(String[] args) {
        String s = "bbbaba";
        System.out.println("Length of Longest Palindromic Subsequence: " + longestPalindromicSubsequence(s));  // Expected output: 4
    }
}

