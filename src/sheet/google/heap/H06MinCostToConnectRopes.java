package sheet.google.heap;


import java.util.PriorityQueue;

public class H06MinCostToConnectRopes {

    public static void main(String[] args) {
        H06MinCostToConnectRopes connector = new H06MinCostToConnectRopes();
        int[] ropes = {4, 3, 2, 6};
        int result = connector.minCost(ropes);

        System.out.println("Minimum cost to connect all ropes: " + result);
    }

    public int minCost(int[] ropes) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Add all ropes to the min-heap
        for (int rope : ropes) {
            minHeap.offer(rope);
        }

        int totalCost = 0;

        // Keep connecting ropes until only one remains
        while (minHeap.size() > 1) {
            int first = minHeap.poll();
            int second = minHeap.poll();

            int cost = first + second;
            totalCost += cost;

            // Add the new rope back to the heap
            minHeap.offer(cost);
        }

        return totalCost;
    }
}

