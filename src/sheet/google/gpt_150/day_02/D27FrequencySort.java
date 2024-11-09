package sheet.google.gpt_150.day_02;


import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class D27FrequencySort {

    public static void main(String[] args) {
        D27FrequencySort solution = new D27FrequencySort();

        String s1 = "tree";
        System.out.println("Frequency sorted: " + solution.frequencySort(s1)); // Output: "eetr" or "eert"

        String s2 = "cccaaa";
        System.out.println("Frequency sorted: " + solution.frequencySort(s2)); // Output: "cccaaa" or "aaaccc"

        String s3 = "Aabb";
        System.out.println("Frequency sorted: " + solution.frequencySort(s3)); // Output: "bbAa" or "bbaA"
    }

    public String frequencySort(String s) {
        // Step 1: Count the frequency of each character
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        // Step 2: Use a max-heap (priority queue) to sort characters by frequency
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap =
                new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        maxHeap.addAll(frequencyMap.entrySet());

        // Step 3: Build the result string based on frequency
        StringBuilder result = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> entry = maxHeap.poll();
            char character = entry.getKey();
            int frequency = entry.getValue();
            // Append the character 'frequency' times to the result
            for (int i = 0; i < frequency; i++) {
                result.append(character);
            }
        }

        return result.toString();
    }
}

