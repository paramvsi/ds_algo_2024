package sheet.graphs.problems;

import java.util.*;

public class G26CheapestFlightWithKStops {
    public static int findCheapestPrice(int[][] flights, int src, int dst, int K) {
        // Map each node to a list of its neighbors (destination, cost)
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] flight : flights) {
            graph.putIfAbsent(flight[0], new ArrayList<>());
            graph.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }

        // Min-heap to store the current state (cost, current city, stops made)
        PriorityQueue<Flight> minHeap = new PriorityQueue<>(Comparator.comparingInt(f -> f.cost));
        minHeap.offer(new Flight(src, 0, -1)); // Starting with -1 stops because the src doesn't count as a stop

        while (!minHeap.isEmpty()) {
            Flight current = minHeap.poll();
            int currentCity = current.dest;
            int currentCost = current.cost;
            int stops = current.stops;

            // If the destination is reached within allowed stops
            if (currentCity == dst) {
                return currentCost;
            }

            // If there are stops left to make, explore the neighbors
            if (stops < K) {
                List<int[]> neighbors = graph.getOrDefault(currentCity, new ArrayList<>());
                for (int[] neighbor : neighbors) {
                    minHeap.offer(new Flight(neighbor[0], currentCost + neighbor[1], stops + 1));
                }
            }
        }

        return -1; // No valid route found
    }

    public static void main(String[] args) {
        int[][] flights = {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}, {2, 3, 100}, {1, 3, 600}};
        int src = 0;
        int dst = 3;
        int K = 1; // Maximum 1 stop allowed

        System.out.println("Cheapest price: " + findCheapestPrice(flights, src, dst, K));
    }

    static class Flight {
        int dest, cost, stops;

        Flight(int dest, int cost, int stops) {
            this.dest = dest;
            this.cost = cost;
            this.stops = stops;
        }
    }
}

