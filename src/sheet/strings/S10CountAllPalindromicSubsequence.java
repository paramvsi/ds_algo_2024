package sheet.strings;

public class S10CountAllPalindromicSubsequence {
    public static int countPalindromicSubsequences(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        // Base case: Single characters are palindromes
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        // Fill the dp array for substrings of length 2 to n
        for (int cl = 2; cl <= n; cl++) {
            for (int i = 0; i < n - cl + 1; i++) {
                int j = i + cl - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j] + dp[i][j - 1] + 1;
                } else {
                    dp[i][j] = dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1];
                }
            }
        }

        return dp[0][n - 1]; // The result for the whole string
    }

    public static void main(String[] args) {
        String s = "aba";
        System.out.println("Count of Palindromic Subsequences: " + countPalindromicSubsequences(s));
    }
}

