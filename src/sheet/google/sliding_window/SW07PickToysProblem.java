package sheet.google.sliding_window;
/*
The Pick Toys Problem is a sliding window problem similar to finding the
Longest Substring with K Unique Characters. In this problem, you are given a string representing
different types of toys (using different characters), and the task is to find the longest substring that
contains at most two unique types of toys.
*/

import java.util.HashMap;
import java.util.Map;

public class SW07PickToysProblem {

    public static int longestSubstringWithTwoUniqueToys(String s) {
        int maxLength = 0;
        int start = 0;
        Map<Character, Integer> toyCount = new HashMap<>();

        for (int end = 0; end < s.length(); end++) {
            char endChar = s.charAt(end);
            toyCount.put(endChar, toyCount.getOrDefault(endChar, 0) + 1);

            // If the number of unique toys exceeds 2, shrink the window
            while (toyCount.size() > 2) {
                char startChar = s.charAt(start);
                toyCount.put(startChar, toyCount.get(startChar) - 1);

                // Remove the toy type if its count becomes zero
                if (toyCount.get(startChar) == 0) {
                    toyCount.remove(startChar);
                }
                start++; // Move the start pointer to the right
            }

            // Update maxLength if the current window has at most 2 unique toys
            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String s = "abaccab";
        System.out.println("Length of the longest substring with at most two unique toys: " + longestSubstringWithTwoUniqueToys(s));
        // Expected output: 4, corresponding to the substring "acca"
    }
}

