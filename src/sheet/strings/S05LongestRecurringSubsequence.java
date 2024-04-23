package sheet.strings;

public class S05LongestRecurringSubsequence {
    // Function to find the longest recurring subsequence
    public static String findLRS(String str) {
        int n = str.length();
        int[][] dp = new int[n + 1][n + 1];

        // Build the dp array
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                // If characters match and are not the same index
                if (str.charAt(i - 1) == str.charAt(j - 1) && i != j) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // Reconstruct the longest recurring subsequence from the dp table
        int i = n, j = n;
        StringBuilder lrs = new StringBuilder();
        while (i > 0 && j > 0) {
            if (dp[i][j] == dp[i - 1][j - 1] + 1) {
                lrs.append(str.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i][j] == dp[i - 1][j]) {
                i--;
            } else {
                j--;
            }
        }

        return lrs.reverse().toString();
    }

    public static void main(String[] args) {
        String str = "AABEBCDD";
        System.out.println("The longest recurring subsequence is: " + findLRS(str));
    }
}
