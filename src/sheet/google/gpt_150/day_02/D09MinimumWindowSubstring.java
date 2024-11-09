package sheet.google.gpt_150.day_02;


import java.util.HashMap;
import java.util.Map;

public class D09MinimumWindowSubstring {
    public static String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        // Frequency map for characters in t
        Map<Character, Integer> targetCount = new HashMap<>();
        for (char c : t.toCharArray()) {
            targetCount.put(c, targetCount.getOrDefault(c, 0) + 1);
        }

        // Sliding window frequency map
        Map<Character, Integer> windowCount = new HashMap<>();
        int left = 0, right = 0, formed = 0;
        int required = targetCount.size(); // Number of unique characters to be matched
        int minLen = Integer.MAX_VALUE;
        int minLeft = 0; // Track start of minimum window

        while (right < s.length()) {
            // Include current character in the window
            char rightChar = s.charAt(right);
            windowCount.put(rightChar, windowCount.getOrDefault(rightChar, 0) + 1);

            // Check if the current character matches the frequency in target
            if (targetCount.containsKey(rightChar) &&
                    windowCount.get(rightChar).equals(targetCount.get(rightChar))) {
                formed++;
            }

            // Try to contract the window
            while (left <= right && formed == required) {
                // Update the minimum window
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minLeft = left;
                }

                // Remove the leftmost character
                char leftChar = s.charAt(left);
                windowCount.put(leftChar, windowCount.get(leftChar) - 1);
                if (targetCount.containsKey(leftChar) &&
                        windowCount.get(leftChar) < targetCount.get(leftChar)) {
                    formed--;
                }

                left++;
            }

            // Expand the window to the right
            right++;
        }

        // Return the minimum window or empty string if no valid window was found
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLen);
    }

    public static void main(String[] args) {
        String s1 = "ADOBECODEBANC";
        String t1 = "ABC";
        System.out.println("Minimum window substring: " + minWindow(s1, t1)); // Output: "BANC"

        String s2 = "a";
        String t2 = "a";
        System.out.println("Minimum window substring: " + minWindow(s2, t2)); // Output: "a"

        String s3 = "a";
        String t3 = "aa";
        System.out.println("Minimum window substring: " + minWindow(s3, t3)); // Output: ""
    }
}

