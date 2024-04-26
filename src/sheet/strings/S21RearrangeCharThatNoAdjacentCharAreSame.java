package sheet.strings;

import java.util.*;

public class S21RearrangeCharThatNoAdjacentCharAreSame {

    public static String rearrangeString(String s) {
        Map<Character, Integer> counts = new HashMap<>();
        for (char c : s.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> counts.get(b) - counts.get(a));
        maxHeap.addAll(counts.keySet());

        StringBuilder result = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();

        while (!maxHeap.isEmpty()) {
            char current = maxHeap.poll();
            result.append(current);
            counts.put(current, counts.get(current) - 1);
            queue.offer(current);

            if (queue.size() >= 2) {  // Check if the waiting queue has enough characters
                char toAddBack = queue.poll();
                if (counts.get(toAddBack) > 0) {
                    maxHeap.offer(toAddBack);
                }
            }
        }

        return result.length() == s.length() ? result.toString() : "";
    }

    public static void main(String[] args) {
        String input = "aaabc";
        System.out.println("Rearranged string: " + rearrangeString(input));
    }
}

