package sheet.strings;

public class S22MinCharAddedToMakeStringPalindrome {

    public static int minAdditionsForPalindrome(String s) {
        StringBuilder reverse = new StringBuilder(s).reverse();
        String temp = s + "#" + reverse;  // Concatenate with a separator
        int n = temp.length();

        // Compute LPS (Longest Prefix Suffix) array
        int[] lps = new int[n];
        for (int i = 1; i < n; i++) {
            int j = lps[i - 1];
            while (j > 0 && temp.charAt(i) != temp.charAt(j)) {
                j = lps[j - 1];
            }
            if (temp.charAt(i) == temp.charAt(j)) {
                j++;
            }
            lps[i] = j;
        }

        // The length of the longest palindromic suffix
        int longestPalindromicSuffix = lps[n - 1];
        return s.length() - longestPalindromicSuffix;
    }

    public static void main(String[] args) {
        String input = "abca";
        System.out.println("Minimum characters to add to make palindrome: " + minAdditionsForPalindrome(input));
    }
}

