package sheet.google.gpt_150.day_01;

import java.util.*;

public class D12TopKFrequentWords {
    public static List<String> topKFrequent(String[] words, int k) {
        // Step 1: Count word frequencies
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // Step 2: Use a min-heap to keep the top k elements
        PriorityQueue<String> heap = new PriorityQueue<>(
                (w1, w2) -> wordCount.get(w1).equals(wordCount.get(w2)) ?
                        w2.compareTo(w1) : wordCount.get(w1) - wordCount.get(w2)
        );

        for (String word : wordCount.keySet()) {
            heap.offer(word);
            if (heap.size() > k) {
                heap.poll(); // Remove the least frequent element
            }
        }

        // Step 3: Extract words from heap and reverse to get correct order
        List<String> result = new ArrayList<>();
        while (!heap.isEmpty()) {
            result.add(heap.poll());
        }
        Collections.reverse(result); // Reverse to get most frequent words first

        return result;
    }

    public static void main(String[] args) {
        String[] words1 = {"i", "love", "leetcode", "i", "love", "coding"};
        int k1 = 2;
        System.out.println("Top " + k1 + " frequent words: " + topKFrequent(words1, k1));

        String[] words2 = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        int k2 = 4;
        System.out.println("Top " + k2 + " frequent words: " + topKFrequent(words2, k2));
    }
}
