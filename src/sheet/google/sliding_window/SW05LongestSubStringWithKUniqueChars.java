package sheet.google.sliding_window;

import java.util.HashMap;
import java.util.Map;

public class SW05LongestSubStringWithKUniqueChars {

    public static int longestSubstringWithKUniqueChars(String s, int K) {
        int maxLength = 0;
        int start = 0;
        Map<Character, Integer> charCount = new HashMap<>();

        for (int end = 0; end < s.length(); end++) {
            // Add the current character to the map and update its frequency
            char endChar = s.charAt(end);
            charCount.put(endChar, charCount.getOrDefault(endChar, 0) + 1);

            // If the number of unique characters exceeds K, shrink the window
            while (charCount.size() > K) {
                char startChar = s.charAt(start);
                charCount.put(startChar, charCount.get(startChar) - 1);

                // Remove the character from the map if its count becomes zero
                if (charCount.get(startChar) == 0) {
                    charCount.remove(startChar);
                }
                start++; // Shrink the window from the left
            }

            // Check if the current window has exactly K unique characters
            if (charCount.size() == K) {
                maxLength = Math.max(maxLength, end - start + 1);
            }
        }

        return maxLength == 0 ? -1 : maxLength; // If no such substring exists, return -1
    }

    public static void main(String[] args) {
        String s = "aabacbebebe";
        int K = 3;
        System.out.println("Length of the longest substring with K unique characters: " + longestSubstringWithKUniqueChars(s, K));
        // Expected output: 7, corresponding to the substring "cbebebe"
    }
}

