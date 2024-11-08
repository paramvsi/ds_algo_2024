package sheet.google.sliding_window;

import java.util.HashMap;
import java.util.Map;

public class SW06LongestSubStringWithoutRepeatingChars {

    public static int longestSubstringWithoutRepeatingChars(String s) {
        int maxLength = 0;
        int start = 0;
        Map<Character, Integer> charIndexMap = new HashMap<>();

        for (int end = 0; end < s.length(); end++) {
            char currentChar = s.charAt(end);

            // If the character is already in the map and within the current window, update the start pointer
            if (charIndexMap.containsKey(currentChar) && charIndexMap.get(currentChar) >= start) {
                start = charIndexMap.get(currentChar) + 1;
            }

            // Update the character's last seen index
            charIndexMap.put(currentChar, end);

            // Update maxLength if we have a longer substring
            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println("Length of the longest substring without repeating characters: " + longestSubstringWithoutRepeatingChars(s));
        // Expected output: 3, corresponding to the substring "abc"
    }
}

