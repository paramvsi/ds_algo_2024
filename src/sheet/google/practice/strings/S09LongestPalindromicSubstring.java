package sheet.google.practice.strings;


public class S09LongestPalindromicSubstring {

    public static String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) return "";

        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i); // Assume odd length, try to extend Palindrome as centered at i
            int len2 = expandAroundCenter(s, i, i + 1); // Assume even length.
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

    public static void main(String[] args) {
        String s = "babad"; // Example input
        System.out.println("Longest palindromic substring: " + longestPalindrome(s));
    }
}

