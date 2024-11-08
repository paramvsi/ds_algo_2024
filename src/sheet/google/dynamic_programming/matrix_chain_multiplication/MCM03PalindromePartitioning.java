package sheet.google.dynamic_programming.matrix_chain_multiplication;

/*
The Palindrome Partitioning problem is about partitioning a given string s such that each substring
in the partition is a palindrome. The goal is to find the minimum number of cuts needed to make
every substring a palindrome.

Problem Definition
Given a string s, return the minimum number of cuts needed for a palindrome partitioning of s.
*/

public class MCM03PalindromePartitioning {

    // Helper function to check if a substring s[start:end+1] is a palindrome
    private static boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // Recursive function to find the minimum cuts needed for a palindrome partitioning
    public static int minCuts(String s, int start, int end) {
        // Base case: if the substring is a palindrome, no cuts are needed
        if (isPalindrome(s, start, end) || start >= end) {
            return 0;
        }

        // Initialize the minimum cuts to a large number
        int minCuts = Integer.MAX_VALUE;

        // Try placing a cut at each possible position k
        for (int k = start; k < end; k++) {
            if (isPalindrome(s, start, k)) { // Only partition if s[start:k+1] is a palindrome
                int cuts = 1 + minCuts(s, k + 1, end); // 1 cut + minimum cuts for the right part
                minCuts = Math.min(minCuts, cuts); // Update the minimum cuts
            }
        }

        return minCuts;
    }

    public static void main(String[] args) {
        String s = "aab";
        System.out.println("Minimum cuts needed for palindrome partitioning: " + minCuts(s, 0, s.length() - 1));
        // Expected output: 1
    }
}

