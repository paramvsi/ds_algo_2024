package sheet.google.sliding_window;
/*
The Minimum Window Substring problem is a popular problem where the goal is to find the smallest
substring of a given string s that contains all the characters of another string t
(including duplicates).
*/

import java.util.HashMap;
import java.util.Map;

public class SW08MinWindowSubstring {

    public static String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        // Frequency map for characters in t
        Map<Character, Integer> tFreq = new HashMap<>();
        for (char c : t.toCharArray()) {
            tFreq.put(c, tFreq.getOrDefault(c, 0) + 1);
        }

        // Sliding window variables
        Map<Character, Integer> windowFreq = new HashMap<>();
        int left = 0, right = 0;
        int minLength = Integer.MAX_VALUE;
        int minLeft = 0;  // Starting index of the minimum window
        int required = tFreq.size();  // Total unique characters in t to be satisfied
        int formed = 0;  // Tracks the number of unique characters fully satisfied in the current window

        // Expand the window with the right pointer
        while (right < s.length()) {
            char c = s.charAt(right);
            windowFreq.put(c, windowFreq.getOrDefault(c, 0) + 1);

            // Check if the current character's frequency matches the required frequency in t
            if (tFreq.containsKey(c) && windowFreq.get(c).intValue() == tFreq.get(c).intValue()) {
                formed++;
            }

            // Try to shrink the window until it's no longer valid
            while (left <= right && formed == required) {
                // Update minimum window if it's smaller than the previously found minimum
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    minLeft = left;
                }

                // Character to be removed from the window
                char leftChar = s.charAt(left);
                windowFreq.put(leftChar, windowFreq.get(leftChar) - 1);

                // Update the formed count if the window is no longer satisfying the required frequency
                if (tFreq.containsKey(leftChar) && windowFreq.get(leftChar).intValue() < tFreq.get(leftChar).intValue()) {
                    formed--;
                }

                // Move the left pointer to shrink the window
                left++;
            }

            // Expand the window
            right++;
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLength);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println("Minimum window substring: " + minWindow(s, t));
        // Expected output: "BANC"
    }
}


