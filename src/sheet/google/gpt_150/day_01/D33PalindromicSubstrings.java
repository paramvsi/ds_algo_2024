package sheet.google.gpt_150.day_01;


public class D33PalindromicSubstrings {
    public static int countSubstrings(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            // Count odd-length palindromes centered at i
            count += expandAroundCenter(s, i, i);

            // Count even-length palindromes centered at i and i+1
            count += expandAroundCenter(s, i, i + 1);
        }

        return count;
    }

    // Helper function to count palindromic substrings centered around left and right
    private static int expandAroundCenter(String s, int left, int right) {
        int count = 0;

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++; // Found a palindromic substring
            left--;  // Expand to the left
            right++; // Expand to the right
        }

        return count;
    }

    public static void main(String[] args) {
        String s1 = "abc";
        System.out.println("Number of palindromic substrings in '" + s1 + "': " + countSubstrings(s1)); // Output: 3

        String s2 = "aaa";
        System.out.println("Number of palindromic substrings in '" + s2 + "': " + countSubstrings(s2)); // Output: 6
    }
}

