package sheet.google.dynamic_programming.longest_common_sub;
/*
Sequence Pattern Matching is a problem that checks if a given string s1 (pattern) is
 a subsequence of another string s2. This is commonly used to determine if all characters in
 s1 appear in s2 in the same order, though not necessarily consecutively.
 */

// Find LCS and check if string length is same as S1 or shortest one.
public class LCS10SequencePatternMatching {

    // Helper function to find the length of the Longest Common Subsequence (LCS)
    private static int longestCommonSubsequence(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }

    // Function to check if s1 is a subsequence of s2
    public static boolean isSubsequence(String s1, String s2) {
        int lcsLength = longestCommonSubsequence(s1, s2);

        // Check if the length of LCS is equal to the length of s1
        return lcsLength == s1.length();
    }

    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "ahbgdc";
        System.out.println("Is s1 a subsequence of s2? " + isSubsequence(s1, s2));  // Expected output: true
    }
}

