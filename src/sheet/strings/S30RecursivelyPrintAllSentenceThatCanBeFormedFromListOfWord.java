package sheet.strings;


import java.util.ArrayList;
import java.util.List;

public class S30RecursivelyPrintAllSentenceThatCanBeFormedFromListOfWord {

    public static void printSentences(List<List<String>> wordLists, int currentListIndex, List<String> currentSentence) {
        if (currentListIndex == wordLists.size()) {
            // Base case: If the current list index reaches the end of the list of lists, print the sentence
            System.out.println(String.join(" ", currentSentence));
            return;
        }

        // Recursive case: Traverse each word in the current list
        for (String word : wordLists.get(currentListIndex)) {
            currentSentence.add(word);  // Add the word to the current sentence path
            printSentences(wordLists, currentListIndex + 1, currentSentence);  // Recurse with the next list index
            currentSentence.removeLast();  // Backtrack
        }
    }

    public static void main(String[] args) {
        List<List<String>> wordLists = new ArrayList<>();
        wordLists.add(List.of("you", "we"));
        wordLists.add(List.of("have", "are"));
        wordLists.add(List.of("sleep", "eat", "drink"));

        printSentences(wordLists, 0, new ArrayList<>());
    }
}

