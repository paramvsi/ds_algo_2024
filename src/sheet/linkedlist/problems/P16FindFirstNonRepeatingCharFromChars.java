package sheet.linkedlist.problems;

import java.util.HashMap;
import java.util.Map;

public class P16FindFirstNonRepeatingCharFromChars {
    public static void main(String[] args) {
        StreamChecker streamChecker = new StreamChecker();
        String stream = "geeksforgeeksandgeeksquizfor";
        for (char ch : stream.toCharArray()) {
            streamChecker.addToStream(ch);
            System.out.println("First non-repeating character: " + streamChecker.getFirstNonRepeating());
        }
    }

    static class StreamChecker {
        private final DListNode head;
        private final DListNode tail;
        private final Map<Character, DListNode> charMap;

        public StreamChecker() {
            this.head = new DListNode(Character.MIN_VALUE); // Dummy head
            this.tail = new DListNode(Character.MAX_VALUE); // Dummy tail
            head.next = tail;
            tail.prev = head;
            this.charMap = new HashMap<>();
        }

        public void addToStream(char ch) {
            if (charMap.containsKey(ch)) {
                DListNode node = charMap.get(ch);
                if (node != null) {
                    // Remove the node from DLL, it's repeating now
                    removeNode(node);
                    charMap.put(ch, null); // Mark as repeated
                }
            } else {
                // New character, add to DLL
                DListNode newNode = new DListNode(ch);
                addNode(newNode);
                charMap.put(ch, newNode);
            }
        }

        public char getFirstNonRepeating() {
            if (head.next == tail) {
                return '#'; // Indicate no non-repeating character
            }
            return (char) head.next.val;
        }

        private void addNode(DListNode node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }

        private void removeNode(DListNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }
}
