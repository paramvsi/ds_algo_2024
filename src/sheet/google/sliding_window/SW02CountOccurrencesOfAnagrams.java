package sheet.google.sliding_window;


import java.util.HashMap;
import java.util.Map;

public class SW02CountOccurrencesOfAnagrams {

    public static int countAnagrams(String s, String p) {
        int n = s.length();
        int m = p.length();

        if (m > n) {
            return 0; // If pattern length is greater than text length, no anagrams are possible
        }

        // Frequency map for pattern `p`
        Map<Character, Integer> patternMap = new HashMap<>();
        for (char c : p.toCharArray()) {
            patternMap.put(c, patternMap.getOrDefault(c, 0) + 1);
        }

        // Frequency map for the current window in `s`
        Map<Character, Integer> windowMap = new HashMap<>();
        int count = 0; // To store the number of anagram occurrences

        // Initialize the first window
        for (int i = 0; i < m; i++) {
            char c = s.charAt(i);
            windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);
        }

        // Check if the first window is an anagram
        if (windowMap.equals(patternMap)) {
            count++;
        }

        // Slide the window over `s`
        for (int i = m; i < n; i++) {
            char newChar = s.charAt(i);
            char oldChar = s.charAt(i - m);

            // Add the new character to the window
            windowMap.put(newChar, windowMap.getOrDefault(newChar, 0) + 1);

            // Remove the old character from the window
            if (windowMap.get(oldChar) == 1) {
                windowMap.remove(oldChar);
            } else {
                windowMap.put(oldChar, windowMap.get(oldChar) - 1);
            }

            // Compare the current window map with the pattern map
            if (windowMap.equals(patternMap)) {
                count++;
            }
        }

        return count;
    }

    public static int countAnagrams2(String s, String p) {
        int n = s.length();
        int m = p.length();

        if (m > n) {
            return 0; // If pattern length is greater than text length, no anagrams are possible
        }

        int[] charCount = new int[26];
        int count = 0; // Tracks the number of characters with matching frequencies
        int anagramCount = 0; // Counts the number of anagram occurrences

        // Initialize charCount with the frequencies of the pattern `p`
        for (char c : p.toCharArray()) {
            charCount[c - 'a']++;
        }

        // Adjust charCount for the first window of size `m` in `s`
        for (int i = 0; i < m; i++) {
            char c = s.charAt(i);
            charCount[c - 'a']--;
        }

        // Calculate initial count for the first window
        for (int i = 0; i < 26; i++) {
            if (charCount[i] == 0) {
                count++;
            }
        }

        // Check if the first window is an anagram
        if (count == 26) {
            anagramCount++;
        }

        // Slide the window over `s`
        for (int i = m; i < n; i++) {
            char newChar = s.charAt(i);        // New character entering the window
            char oldChar = s.charAt(i - m);    // Old character leaving the window

            // Update charCount for the oldChar going out of the window
            if (charCount[oldChar - 'a'] == 0) count--; // Going from 0 to non-zero
            charCount[oldChar - 'a']++;
            if (charCount[oldChar - 'a'] == 0) count++; // Back to zero, increment count

            // Update charCount for the newChar coming into the window
            if (charCount[newChar - 'a'] == 0) count--; // Going from 0 to non-zero
            charCount[newChar - 'a']--;
            if (charCount[newChar - 'a'] == 0) count++; // Back to zero, increment count

            // If count == 26, all characters match
            if (count == 26) {
                anagramCount++;
            }
        }

        return anagramCount;
    }


    public static void main(String[] args) {
        String s = "forxxorfxdofr";
        String p = "for";
        System.out.println("Number of anagram occurrences: " + countAnagrams(s, p));
        System.out.println("Number of anagram occurrences: " + countAnagrams2(s, p));
        // Expected output: 3, since "for", "orf", and "ofr" are anagrams of "for"
    }
}

