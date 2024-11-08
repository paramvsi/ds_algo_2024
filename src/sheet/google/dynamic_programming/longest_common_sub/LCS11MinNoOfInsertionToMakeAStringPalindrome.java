package sheet.google.dynamic_programming.longest_common_sub;

public class LCS11MinNoOfInsertionToMakeAStringPalindrome {

    // Helper function to find the LCS of two strings
    private static int longestCommonSubsequence(String a, String b) {
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

    // Function to find the minimum number of insertions to make a string palindrome
    public static int minInsertionsToMakePalindrome(String s) {
        // Reverse the string to find LPS using LCS
        String reverse_s = new StringBuilder(s).reverse().toString();

        // Find the LPS length (which is the LCS of s and reverse_s)
        int lpsLength = longestCommonSubsequence(s, reverse_s);

        // Minimum insertions needed to make the string a palindrome
        return s.length() - lpsLength;
    }

    public static void main(String[] args) {
        String s = "abcaa";
        System.out.println("Minimum insertions to make the string a palindrome: " + minInsertionsToMakePalindrome(s));  // Expected output: 2
    }
}

