package sheet.google.months_6;

// Design Search Autocomplete System

import java.util.*;

public class F12DesignAutoCompleteSearch {

    // Root of the Trie
    private TrieNode root;
    private StringBuilder currentInput;
    private TrieNode currentNode;

    public F12DesignAutoCompleteSearch(String[] sentences, int[] times) {
        root = new TrieNode();
        currentInput = new StringBuilder();
        currentNode = root;

        // Add all initial sentences to the Trie
        for (int i = 0; i < sentences.length; i++) {
            addSentence(sentences[i], times[i]);
        }
    }

    public static void main(String[] args) {
        String[] sentences = {"i love you", "island", "iroman", "i love leetcode"};
        int[] times = {5, 3, 2, 2};

        F12DesignAutoCompleteSearch system = new F12DesignAutoCompleteSearch(sentences, times);

        System.out.println(system.input('i'));   // Output: ["i love you", "island", "i love leetcode"]
        System.out.println(system.input(' '));  // Output: ["i love you", "i love leetcode"]
        System.out.println(system.input('a'));  // Output: []
        System.out.println(system.input('#'));  // Reset state
    }

    // Add a sentence to the Trie
    private void addSentence(String sentence, int frequency) {
        TrieNode node = root;
        for (char c : sentence.toCharArray()) {
            node.children.putIfAbsent(c, new TrieNode());
            node = node.children.get(c);

            // Update frequency map for the sentence at each node
            node.frequencyMap.put(sentence, node.frequencyMap.getOrDefault(sentence, 0) + frequency);
        }
    }

    // Get top-k sentences with the current prefix
    private List<String> getTopSuggestions(TrieNode node) {
        // Create a PriorityQueue to rank sentences
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> {
            int freqA = node.frequencyMap.get(a);
            int freqB = node.frequencyMap.get(b);
            if (freqA == freqB) {
                return a.compareTo(b); // Lexicographical order
            }
            return freqB - freqA; // Higher frequency first
        });

        pq.addAll(node.frequencyMap.keySet());

        List<String> suggestions = new ArrayList<>();
        for (int i = 0; i < 3 && !pq.isEmpty(); i++) {
            suggestions.add(pq.poll());
        }

        return suggestions;
    }

    public List<String> input(char c) {
        if (c == '#') {
            // End of input, add the sentence to the Trie
            String sentence = currentInput.toString();
            addSentence(sentence, 1);

            // Reset state
            currentInput = new StringBuilder();
            currentNode = root;

            return new ArrayList<>();
        }

        // Add character to the current input
        currentInput.append(c);

        // Move to the next node in the Trie
        if (currentNode != null && currentNode.children.containsKey(c)) {
            currentNode = currentNode.children.get(c);
            return getTopSuggestions(currentNode);
        }

        // If the prefix is not found, return an empty list
        currentNode = null;
        return new ArrayList<>();
    }

    // Define TrieNode class
    class TrieNode {
        Map<Character, TrieNode> children;
        Map<String, Integer> frequencyMap;

        public TrieNode() {
            children = new HashMap<>();
            frequencyMap = new HashMap<>();
        }
    }
}

