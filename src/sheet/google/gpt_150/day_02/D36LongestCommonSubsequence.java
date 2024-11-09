package sheet.google.gpt_150.day_02;


public class D36LongestCommonSubsequence {

    public static void main(String[] args) {
        D36LongestCommonSubsequence solution = new D36LongestCommonSubsequence();

        String text1 = "abcde";
        String text2 = "ace";
        System.out.println("LCS length: " + solution.longestCommonSubsequence(text1, text2)); // Output: 3

        text1 = "abc";
        text2 = "abc";
        System.out.println("LCS length: " + solution.longestCommonSubsequence(text1, text2)); // Output: 3

        text1 = "abc";
        text2 = "def";
        System.out.println("LCS length: " + solution.longestCommonSubsequence(text1, text2)); // Output: 0
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];

        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // The LCS length is in the bottom-right cell of the DP table
        return dp[m][n];
    }
}

