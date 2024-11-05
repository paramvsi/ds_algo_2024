package sheet.google.dynamic_programming.longest_common_sub;

public class LCS03LongestCommonSubstring {
    public static int longestCommonSubstring(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int maxLength = Integer.MIN_VALUE;

        // Initialize the dp array with size (m+1) x (n+1)
        int[][] dp = new int[m + 1][n + 1];

        // Fill the dp table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    maxLength = Math.max(maxLength, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }


        return maxLength;
    }

    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "abce";
        System.out.println("Length of LCS: " + longestCommonSubstring(text1, text2));  // Expected output: 3
    }
}


