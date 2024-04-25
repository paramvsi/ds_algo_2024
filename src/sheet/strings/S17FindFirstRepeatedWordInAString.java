package sheet.strings;

import java.util.HashSet;
import java.util.Set;

public class S17FindFirstRepeatedWordInAString {

    public static String findFirstRepeatedWord(String s) {
        // Normalize the input string and split by non-word characters (spaces, punctuation, etc.)
        String[] words = s.toLowerCase().split("\\W+");

        Set<String> seenWords = new HashSet<>();

        for (String word : words) {
            if (seenWords.contains(word)) {
                return word;  // Return the first repeated word
            }
            seenWords.add(word);
        }

        return "No repeated word";  // Return if no repeated word is found
    }

    public static void main(String[] args) {
        String text = "He had been in strange towns before, but towns which are none quite as odd as this.";
        System.out.println("First repeated word: " + findFirstRepeatedWord(text));
    }
}

