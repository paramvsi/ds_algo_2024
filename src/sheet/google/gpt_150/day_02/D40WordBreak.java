package sheet.google.gpt_150.day_02;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class D40WordBreak {

    public static void main(String[] args) {
        D40WordBreak solution = new D40WordBreak();

        String s1 = "leetcode";
        List<String> wordDict1 = List.of("leet", "code");
        System.out.println("Can be segmented: " + solution.wordBreak(s1, wordDict1)); // Output: true

        String s2 = "applepenapple";
        List<String> wordDict2 = List.of("apple", "pen");
        System.out.println("Can be segmented: " + solution.wordBreak(s2, wordDict2)); // Output: true

        String s3 = "catsandog";
        List<String> wordDict3 = List.of("cats", "dog", "sand", "and", "cat");
        System.out.println("Can be segmented: " + solution.wordBreak(s3, wordDict3)); // Output: false
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict); // Convert wordDict to a HashSet for fast lookups
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true; // Base case: empty string is segmentable

        // Fill the DP array
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                // If s[0:j] is segmentable and s[j:i] is in the dictionary, mark s[0:i] as segmentable
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break; // No need to check further if dp[i] is already true
                }
            }
        }

        return dp[s.length()];
    }
}

