package sheet.google.dynamic_programming.longest_common_sub;

public class LCS03PrintLCS {
    public static String longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        // Initialize the dp array with size (m+1) x (n+1)
        String[][] dp = new String[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            dp[i][0] = "";
        }

        for (int j = 0; j <= n; j++) {
            dp[0][j] = "";
        }

        // Fill the dp table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + text1.charAt(i - 1);
                } else {
                    dp[i][j] = dp[i - 1][j].length() > dp[i][j - 1].length() ? dp[i - 1][j] : dp[i][j - 1];
                }
            }
        }

        // The result is in dp[m][n]
        return dp[m][n];
    }

    public static void main(String[] args) {
        String text1 = "acdef";
        String text2 = "abcef";
        System.out.println("Length of LCS: " + longestCommonSubsequence(text1, text2));  // Expected output: 3
    }
}
