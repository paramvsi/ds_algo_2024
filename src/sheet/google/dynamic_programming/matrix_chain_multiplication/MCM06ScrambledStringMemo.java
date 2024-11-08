package sheet.google.dynamic_programming.matrix_chain_multiplication;


import java.util.HashMap;
import java.util.Map;

public class MCM06ScrambledStringMemo {

    // Memoization map to store previously computed results
    private static Map<String, Boolean> memo = new HashMap<>();

    // Recursive function with memoization to check if s2 is a scrambled version of s1
    public static boolean isScramble(String s1, String s2) {
        // Base case: if the strings are equal, they're scrambled versions of each other
        if (s1.equals(s2)) {
            return true;
        }

        // If lengths differ, they cannot be scrambled versions
        if (s1.length() != s2.length()) {
            return false;
        }

        // Check the memoization map to avoid redundant calculations
        String key = s1 + "|" + s2;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        // Check if both strings have the same characters
        if (!hasSameCharacters(s1, s2)) {
            memo.put(key, false);
            return false;
        }

        int n = s1.length();
        // Try splitting at every possible index
        for (int i = 1; i < n; i++) {
            // Case 1: No swap case
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) &&
                    isScramble(s1.substring(i), s2.substring(i))) {
                memo.put(key, true);
                return true;
            }

            // Case 2: Swap case
            if (isScramble(s1.substring(0, i), s2.substring(n - i)) &&
                    isScramble(s1.substring(i), s2.substring(0, n - i))) {
                memo.put(key, true);
                return true;
            }
        }

        // If neither case works, store the result as false
        memo.put(key, false);
        return false;
    }

    // Helper function to check if two strings have the same characters
    private static boolean hasSameCharacters(String s1, String s2) {
        int[] count = new int[26];
        for (char c : s1.toCharArray()) {
            count[c - 'a']++;
        }
        for (char c : s2.toCharArray()) {
            count[c - 'a']--;
        }
        for (int i : count) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "great";
        String s2 = "rgeat";
        System.out.println("Is Scramble: " + isScramble(s1, s2));  // Expected output: true

        s1 = "abcde";
        s2 = "caebd";
        System.out.println("Is Scramble: " + isScramble(s1, s2));  // Expected output: false
    }
}

