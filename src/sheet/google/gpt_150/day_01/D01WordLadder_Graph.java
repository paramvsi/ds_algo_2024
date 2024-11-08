package sheet.google.gpt_150.day_01;

import java.util.*;


public class D01WordLadder_Graph {
    // Overall time complexity is O(M * N) where M is length of word and N is wordlist length
    // Same is space complexity
    public static void main(String[] args) {

        D01WordLadder_Graph wordLadder = new D01WordLadder_Graph();

        // Test Case 1
        String beginWord1 = "hit";
        String endWord1 = "cog";
        List<String> wordList1 = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        System.out.println("Test Case 1:");
        System.out.println("Expected Output: 5");
        System.out.println("Actual Output: " + wordLadder.ladderLength(beginWord1, endWord1, wordList1));
        System.out.println();

        // Test Case 2 (endWord not reachable)
        String beginWord2 = "hit";
        String endWord2 = "cog";
        List<String> wordList2 = Arrays.asList("hot", "dot", "dog", "lot", "log");
        System.out.println("Test Case 2:");
        System.out.println("Expected Output: 0");
        System.out.println("Actual Output: " + wordLadder.ladderLength(beginWord2, endWord2, wordList2));
        System.out.println();

        // Test Case 3 (beginWord equals endWord)
        String beginWord3 = "same";
        String endWord3 = "same";
        List<String> wordList3 = Arrays.asList("same", "came", "lame", "tame");
        System.out.println("Test Case 3:");
        System.out.println("Expected Output: 0");
        System.out.println("Actual Output: " + wordLadder.ladderLength(beginWord3, endWord3, wordList3));
        System.out.println();

        // Test Case 4 (minimum transformation path)
        String beginWord4 = "abc";
        String endWord4 = "def";
        List<String> wordList4 = Arrays.asList("abc", "dbc", "dbc", "dec", "def");
        System.out.println("Test Case 4:");
        System.out.println("Expected Output: 4");
        System.out.println("Actual Output: " + wordLadder.ladderLength(beginWord4, endWord4, wordList4));
        System.out.println();

        // Test Case 5 (large wordList with no transformation possible)
        String beginWord5 = "start";
        String endWord5 = "end";
        List<String> wordList5 = Arrays.asList("smart", "dart", "cart", "ward", "bark");
        System.out.println("Test Case 5:");
        System.out.println("Expected Output: 0");
        System.out.println("Actual Output: " + wordLadder.ladderLength(beginWord5, endWord5, wordList5));
        System.out.println();
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // Step 1: Create a set for faster lookup of words
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0; // endWord not in wordList, no possible transformation
        }

        // Step 2: Create a dictionary to hold all generic forms of each word
        Map<String, List<String>> transformations = new HashMap<>();
        wordSet.add(beginWord); // Include beginWord in transformations

        for (String word : wordSet) {
            for (int i = 0; i < word.length(); i++) {
                String genericForm = word.substring(0, i) + "*" + word.substring(i + 1);
                transformations.computeIfAbsent(genericForm, k -> new ArrayList<>()).add(word);
            }
        }

        // Step 3: Initialize BFS
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(beginWord, 1)); // Starting point
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        // Step 4: Perform BFS
        while (!queue.isEmpty()) {
            Pair<String, Integer> current = queue.poll();
            String currentWord = current.getKey();
            int level = current.getValue();

            for (int i = 0; i < currentWord.length(); i++) {
                String genericForm = currentWord.substring(0, i) + "*" + currentWord.substring(i + 1);

                for (String nextWord : transformations.getOrDefault(genericForm, new ArrayList<>())) {
                    if (nextWord.equals(endWord)) {
                        return level + 1; // Found the shortest path
                    }

                    if (!visited.contains(nextWord)) {
                        visited.add(nextWord);
                        queue.add(new Pair<>(nextWord, level + 1));
                    }
                }
            }
        }

        return 0; // No transformation sequence found
    }

    // Pair class to hold word and its level (distance from beginWord)
    static class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}


