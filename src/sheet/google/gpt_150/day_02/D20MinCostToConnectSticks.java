package sheet.google.gpt_150.day_02;


import java.util.PriorityQueue;

public class D20MinCostToConnectSticks {
    public static void main(String[] args) {
        D20MinCostToConnectSticks solution = new D20MinCostToConnectSticks();

        int[] sticks1 = {2, 4, 3};
        System.out.println("Minimum cost to connect sticks: " + solution.connectSticks(sticks1)); // Output: 14

        int[] sticks2 = {1, 8, 3, 5};
        System.out.println("Minimum cost to connect sticks: " + solution.connectSticks(sticks2)); // Output: 30

        int[] sticks3 = {5};
        System.out.println("Minimum cost to connect sticks: " + solution.connectSticks(sticks3)); // Output: 0
    }

    public int connectSticks(int[] sticks) {
        if (sticks == null || sticks.length == 0) return 0;

        // Min-heap to store stick lengths
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Add all sticks to the heap
        for (int stick : sticks) {
            minHeap.offer(stick);
        }

        int totalCost = 0;

        // Combine sticks until only one stick remains in the heap
        while (minHeap.size() > 1) {
            // Take two smallest sticks
            int first = minHeap.poll();
            int second = minHeap.poll();

            // Cost to connect these two sticks
            int cost = first + second;
            totalCost += cost;

            // Add the combined stick back to the heap
            minHeap.offer(cost);
        }

        return totalCost;
    }
}

