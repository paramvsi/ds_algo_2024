package sheet.google.gpt_150.day_01;


import java.util.HashMap;
import java.util.Map;

public class D15LongestSubStringWithoutRepeatingChars {
    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> charIndexMap = new HashMap<>();
        int maxLength = 0;
        int start = 0;

        for (int end = 0; end < s.length(); end++) {
            char currentChar = s.charAt(end);

            // If the character is already in the map, move the start pointer
            // to one position after the last occurrence of this character
            if (charIndexMap.containsKey(currentChar)) {
                start = Math.max(start, charIndexMap.get(currentChar) + 1);
            }

            // Update the latest index of the character
            charIndexMap.put(currentChar, end);

            // Calculate the maximum length of the substring
            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String s1 = "abcabcbb";
        System.out.println("Length of Longest Substring: " + lengthOfLongestSubstring(s1)); // Output: 3

        String s2 = "bbbbb";
        System.out.println("Length of Longest Substring: " + lengthOfLongestSubstring(s2)); // Output: 1

        String s3 = "pwwkew";
        System.out.println("Length of Longest Substring: " + lengthOfLongestSubstring(s3)); // Output: 3
    }
}

