package sheet.google.dynamic_programming.longest_common_sub;


public class LCS08PrintSCS {

    // Helper function to find the Longest Common Subsequence (LCS) of two strings
    private static int[][] longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];

        // Fill the dp table for LCS length calculation
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp;
    }

    // Function to print the Shortest Common Supersequence (SCS)
    public static String shortestCommonSupersequence(String text1, String text2) {
        int[][] dp = longestCommonSubsequence(text1, text2);
        int i = text1.length();
        int j = text2.length();

        StringBuilder result = new StringBuilder();

        // Backtrack to build the SCS using the dp table
        while (i > 0 && j > 0) {
            if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                // Character from both strings is part of the LCS
                result.append(text1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                // Character from text1 is not in LCS, add it to the result
                result.append(text1.charAt(i - 1));
                i--;
            } else {
                // Character from text2 is not in LCS, add it to the result
                result.append(text2.charAt(j - 1));
                j--;
            }
        }

        // Add remaining characters of text1 or text2
        while (i > 0) {
            result.append(text1.charAt(i - 1));
            i--;
        }
        while (j > 0) {
            result.append(text2.charAt(j - 1));
            j--;
        }

        // Reverse the result to get the correct order
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        String text1 = "abac";
        String text2 = "cab";
        System.out.println("Shortest Common Supersequence: " + shortestCommonSupersequence(text1, text2));  // Expected output: "cabac"
    }
}

