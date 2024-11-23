package sheet.google.months_6;


import java.util.TreeMap;

public class F08HandOfStraights {
    public static void main(String[] args) {
        F08HandOfStraights solution = new F08HandOfStraights();

        // Test cases
        int[] hand1 = {1, 2, 3, 6, 2, 3, 4, 7, 8};
        int groupSize1 = 3;
        System.out.println(solution.isNStraightHand(hand1, groupSize1)); // Output: true

        int[] hand2 = {1, 2, 3, 4, 5};
        int groupSize2 = 4;
        System.out.println(solution.isNStraightHand(hand2, groupSize2)); // Output: false
    }

    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false; // Not divisible, cannot form groups
        }

        // Create a frequency map
        TreeMap<Integer, Integer> freqMap = new TreeMap<>();
        for (int card : hand) {
            freqMap.put(card, freqMap.getOrDefault(card, 0) + 1);
        }

        // Form groups greedily
        while (!freqMap.isEmpty()) {
            int firstCard = freqMap.firstKey(); // Get the smallest card
            for (int i = 0; i < groupSize; i++) {
                int currentCard = firstCard + i;
                if (!freqMap.containsKey(currentCard)) {
                    return false; // Missing a card in the group
                }

                // Decrease the frequency
                freqMap.put(currentCard, freqMap.get(currentCard) - 1);
                if (freqMap.get(currentCard) == 0) {
                    freqMap.remove(currentCard); // Remove if frequency is zero
                }
            }
        }

        return true; // Successfully formed all groups
    }
}
