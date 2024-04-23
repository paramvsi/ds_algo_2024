package sheet.strings;

/*
Manacher’s algorithm uses a clever trick to avoid redundant checks and effectively handles both even and odd length
palindromes by inserting a unique character (often #) between every two characters of the string
 (and at the beginning and end). This transformation turns the string into a form where every palindrome is of odd length,
 simplifying the process.*/

// Below is both solution in N2 and N
public class S04LongestPalindromicSubstring {

    public static String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);       // Odd length palindromes
            int len2 = expandAroundCenter(s, i, i + 1);   // Even length palindromes
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    public static String longestPalindromicSubstring(String s) {
        if (s == null || s.isEmpty()) return "";

        // Transform S
        StringBuilder sb = new StringBuilder("$#");
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i)).append('#');
        }
        sb.append('@');

        // Process the transformed string
        int[] p = new int[sb.length()];
        int center = 0, right = 0;
        int maxLen = 0, centerIndex = 0;
        for (int i = 1; i < sb.length() - 1; i++) {
            p[i] = (right > i) ? Math.min(right - i, p[2 * center - i]) : 0;
            while (sb.charAt(i + 1 + p[i]) == sb.charAt(i - 1 - p[i]))
                p[i]++;
            if (i + p[i] > right) {
                center = i;
                right = i + p[i];
            }
            if (p[i] > maxLen) {
                maxLen = p[i];
                centerIndex = i;
            }
        }

        return s.substring((centerIndex - maxLen) / 2, (centerIndex + maxLen) / 2);
    }


    public static void main(String[] args) {
        String input = "babad";
        System.out.println("Longest Palindromic Substring of '" + input + "' is: " + longestPalindrome(input));
        System.out.println("Longest Palindromic Substring of '" + input + "' is: " + longestPalindromicSubstring(input));
    }
}
