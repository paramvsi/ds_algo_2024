package sheet.stack_and_queue;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class P24QueueBasedFirstNonRepeatingCharacterInAStream {

    public static void findFirstNonRepeating() {
        // Stream of characters
        char[] stream = {'a', 'b', 'c', 'a', 'c', 'b', 'd', 'e', 'f', 'e', 'g', 'd', 'h', 'h'};
        Map<Character, Integer> charCount = new HashMap<>();
        Queue<Character> queue = new LinkedList<>();

        for (char ch : stream) {
            // Count the character
            charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);

            // Only add to queue if it's the first occurrence
            if (charCount.get(ch) == 1) {
                queue.offer(ch);
            }

            // Remove elements from the queue while they have a count greater than 1
            while (!queue.isEmpty() && charCount.get(queue.peek()) > 1) {
                queue.poll();
            }

            // The first non-repeating character
            char firstNonRepeating = queue.isEmpty() ? '#' : queue.peek();
            System.out.println("First non-repeating character: " + firstNonRepeating);
        }
    }

    public static void main(String[] args) {
        findFirstNonRepeating();
    }
}

