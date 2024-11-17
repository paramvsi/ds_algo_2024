package sheet.google.practice.strings;


import java.util.HashMap;
import java.util.Map;

public class S01LongestSubWORepeatingCharacter {
    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>(); // Store characters and their latest positions
        int start = 0;
        int maxWindow = 0;

        for (int end = 0; end < s.length(); end++) {
            char current = s.charAt(end);

            if (map.containsKey(current)) {
                // Move the start point of the window right past the last occurrence of 'current'
                start = Math.max(start, map.get(current) + 1);
            }

            map.put(current, end); // Update or add the current character's position
            maxWindow = Math.max(maxWindow, end - start + 1); // Calculate the window size
        }

        return maxWindow; // Return the length of the longest substring
    }

    public static void main(String[] args) {
        String s = "abcabcbb"; // Example input
        System.out.println("Length of the longest substring without repeating characters: " + lengthOfLongestSubstring(s));
    }
}

