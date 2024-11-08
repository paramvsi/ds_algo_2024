package sheet.google.dynamic_programming.matrix_chain_multiplication;

/*

The Scrambled String problem is a classic problem where we need to determine if one
string is a scrambled version of another.

Problem Definition
Given two strings s1 and s2, we say that s2 is a scrambled version of s1 if we can
transform s1 into s2 using the following operations:

Swap: Split s1 into two non-empty substrings at some index, and swap the two parts.
For example, "great" can be split into "gr" and "eat" and swapped to form "eatrg".

Recursion: Recursively apply the scrambling operation on each of the substrings.
The task is to determine if s2 is a scrambled version of s1.
*/

public class MCM05ScrambledStringRecursive {

    // Recursive function to check if s2 is a scrambled version of s1
    public static boolean isScramble(String s1, String s2) {
        // Base cases
        if (s1.equals(s2)) {
            return true;
        }
        if (s1.length() != s2.length()) {
            return false;
        }

        // Check if both strings have the same characters (frequency check)
        if (!hasSameCharacters(s1, s2)) {
            return false;
        }

        int n = s1.length();

        // Try splitting at every possible index
        for (int i = 1; i < n; i++) {
            // Case 1: No swap case
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) &&
                    isScramble(s1.substring(i), s2.substring(i))) {
                return true;
            }

            // Case 2: Swap case
            if (isScramble(s1.substring(0, i), s2.substring(n - i)) &&
                    isScramble(s1.substring(i), s2.substring(0, n - i))) {
                return true;
            }
        }

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

