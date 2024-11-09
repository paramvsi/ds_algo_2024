package sheet.google.gpt_150.day_02;


import java.util.ArrayList;
import java.util.List;

public class D33PalindromePartitioning {

    public static void main(String[] args) {
        D33PalindromePartitioning solution = new D33PalindromePartitioning();

        String s1 = "aab";
        System.out.println("Partitions for 'aab': " + solution.partition(s1));

        String s2 = "a";
        System.out.println("Partitions for 'a': " + solution.partition(s2));
    }

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(String s, int start, List<String> currentPartition, List<List<String>> result) {
        // Base case: if we've reached the end of the string
        if (start == s.length()) {
            result.add(new ArrayList<>(currentPartition));
            return;
        }

        // Explore all possible partitions
        for (int end = start; end < s.length(); end++) {
            // Check if the substring s[start:end+1] is a palindrome
            if (isPalindrome(s, start, end)) {
                // If it's a palindrome, add it to the current partition
                currentPartition.add(s.substring(start, end + 1));

                // Recur for the remaining substring
                backtrack(s, end + 1, currentPartition, result);

                // Backtrack: remove the last added substring to try other partitions
                currentPartition.remove(currentPartition.size() - 1);
            }
        }
    }

    // Helper function to check if a substring is a palindrome
    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

