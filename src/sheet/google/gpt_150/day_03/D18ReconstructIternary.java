package sheet.google.gpt_150.day_03;


import java.util.*;

public class D18ReconstructIternary {

    private Map<String, PriorityQueue<String>> adjList = new HashMap<>();
    private LinkedList<String> itinerary = new LinkedList<>();

    public static void main(String[] args) {
        D18ReconstructIternary solution = new D18ReconstructIternary();

        List<List<String>> tickets1 = Arrays.asList(
                Arrays.asList("MUC", "LHR"),
                Arrays.asList("JFK", "MUC"),
                Arrays.asList("SFO", "SJC"),
                Arrays.asList("LHR", "SFO")
        );
        System.out.println("Itinerary: " + solution.findItinerary(tickets1));
        // Output: [JFK, MUC, LHR, SFO, SJC]

        List<List<String>> tickets2 = Arrays.asList(
                Arrays.asList("JFK", "SFO"),
                Arrays.asList("JFK", "ATL"),
                Arrays.asList("SFO", "ATL"),
                Arrays.asList("ATL", "JFK"),
                Arrays.asList("ATL", "SFO")
        );
        System.out.println("Itinerary: " + solution.findItinerary(tickets2));
        // Output: [JFK, ATL, JFK, SFO, ATL, SFO]
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        // Step 1: Build the adjacency list
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            adjList.computeIfAbsent(from, k -> new PriorityQueue<>()).add(to);
        }

        // Step 2: Start DFS from "JFK"
        dfs("JFK");

        // Step 3: Return the constructed itinerary
        return itinerary;
    }

    private void dfs(String airport) {
        // Get the destinations for the current airport in lexicographical order
        PriorityQueue<String> destinations = adjList.get(airport);

        // Visit each destination
        while (destinations != null && !destinations.isEmpty()) {
            String nextAirport = destinations.poll();
            dfs(nextAirport);
        }

        // Backtrack: Add airport to the itinerary after visiting all its destinations
        itinerary.addFirst(airport);
    }
}

