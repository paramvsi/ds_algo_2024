package sheet.google.gpt_150.day_02;

// Given an array of strings arr, find the maximum length of a concatenated string with
// unique characters that can be formed by choosing some of the strings from arr.


import java.util.List;

public class D11MaxLenOfConcatStringWithUniqueChars {
    public static void main(String[] args) {
        D11MaxLenOfConcatStringWithUniqueChars solution = new D11MaxLenOfConcatStringWithUniqueChars();

        List<String> arr1 = List.of("un", "iq", "ue");
        System.out.println("Maximum length of unique characters: " + solution.maxLength(arr1)); // Output: 4

        List<String> arr2 = List.of("cha", "r", "act", "ers");
        System.out.println("Maximum length of unique characters: " + solution.maxLength(arr2)); // Output: 6

        List<String> arr3 = List.of("abcdefghijklmnopqrstuvwxyz");
        System.out.println("Maximum length of unique characters: " + solution.maxLength(arr3)); // Output: 26
    }

    public int maxLength(List<String> arr) {
        return backtrack(arr, 0, "");
    }

    private int backtrack(List<String> arr, int index, String current) {
        // If the current string has duplicate characters, it's invalid, return 0
        if (!isUnique(current)) return 0;

        // Keep track of the maximum length
        int maxLength = current.length();

        // Try adding each string in the list to the current concatenation
        for (int i = index; i < arr.size(); i++) {
            maxLength = Math.max(maxLength, backtrack(arr, i + 1, current + arr.get(i)));
        }

        return maxLength;
    }

    // Helper function to check if all characters in a string are unique
    private boolean isUnique(String s) {
        int[] charCount = new int[26];
        for (char c : s.toCharArray()) {
            if (charCount[c - 'a']++ > 0) {
                return false;
            }
        }
        return true;
    }
}

