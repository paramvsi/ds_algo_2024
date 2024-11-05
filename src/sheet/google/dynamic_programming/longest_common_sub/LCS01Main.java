package sheet.google.dynamic_programming.longest_common_sub;

/*
The Longest Common Subsequence (LCS) problem is a classic dynamic programming problem.
Given two strings text1 and text2, the goal is to find the length of the longest subsequence that appears
in both strings in the same order (but not necessarily consecutively).
*/

// How to identify?


import java.util.Arrays;

public class LCS01Main {

    public static int longestCommonSubsequence(String text1, String text2) {
        int[][] memo = new int[text1.length() + 1][text2.length() + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1); // Initialize memo array with -1 (uncomputed)
        }
        return lcsHelper(text1, text2, text1.length(), text2.length(), memo);
    }

    private static int lcsHelper(String text1, String text2, int i, int j, int[][] memo) {
        if (i == 0 || j == 0) {
            return 0;
        }

        if (memo[i][j] != -1) {
            return memo[i][j]; // Return previously computed value
        }

        if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
            memo[i][j] = 1 + lcsHelper(text1, text2, i - 1, j - 1, memo);
        } else {
            memo[i][j] = Math.max(lcsHelper(text1, text2, i - 1, j, memo), lcsHelper(text1, text2, i, j - 1, memo));
        }

        return memo[i][j];
    }

    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";
        System.out.println("Length of LCS: " + longestCommonSubsequence(text1, text2));
    }
}

