package sheet.google.dynamic_programming.longest_common_sub;


public class LCS06MinNumberOfInsAndDel {

    // Helper function to find the length of the Longest Common Subsequence (LCS)
    public static int longestCommonSubsequence(String a, String b) {
        int m = a.length();
        int n = b.length();

        int[][] dp = new int[m + 1][n + 1];

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

    // Function to find the minimum number of deletions and insertions
    public static int minDeletionsInsertions(String a, String b) {
        int m = a.length();
        int n = b.length();

        // Find the LCS length
        int lcsLength = longestCommonSubsequence(a, b);

        // Calculate the total operations (deletions + insertions)
        int deletions = m - lcsLength;
        int insertions = n - lcsLength;

        return deletions + insertions;
    }

    public static void main(String[] args) {
        String a = "heap";
        String b = "pea";
        System.out.println("Minimum number of deletions and insertions: " + minDeletionsInsertions(a, b));  // Expected output: 3
    }
}
