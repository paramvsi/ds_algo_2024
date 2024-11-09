package sheet.google.gpt_150.day_02;
/*
You are given an array intervals, where intervals[i] = [start, end] represents the start and end of the i-th interval,
 and an integer array queries. For each query in queries, find the size of the smallest interval that includes query.
  If no interval includes the query, return -1 for that query.
  */


import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class D19MinIntervalsQuery {
    public static void main(String[] args) {
        D19MinIntervalsQuery solution = new D19MinIntervalsQuery();

        int[][] intervals1 = {{1, 4}, {2, 4}, {3, 6}};
        int[] queries1 = {2, 3, 4, 5};
        System.out.println(Arrays.toString(solution.minInterval(intervals1, queries1))); // Output: [3, 3, 3, 4]

        int[][] intervals2 = {{2, 3}, {2, 5}, {1, 8}, {20, 25}};
        int[] queries2 = {2, 19, 5, 22};
        System.out.println(Arrays.toString(solution.minInterval(intervals2, queries2))); // Output: [2, -1, 4, 6]
    }

    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0])); // Sort intervals by start time

        int[][] queriesWithIndex = new int[queries.length][2];
        for (int i = 0; i < queries.length; i++) {
            queriesWithIndex[i][0] = queries[i];
            queriesWithIndex[i][1] = i; // Keep track of the original indices of the queries
        }
        Arrays.sort(queriesWithIndex, Comparator.comparingInt(a -> a[0])); // Sort queries by value

        int[] result = new int[queries.length];
        Arrays.fill(result, -1); // Initialize the result array with -1

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1] - a[0] + 1));
        int i = 0; // Pointer for intervals

        for (int[] query : queriesWithIndex) {
            int qValue = query[0];
            int qIndex = query[1];

            // Add all intervals that start before or at the current query
            while (i < intervals.length && intervals[i][0] <= qValue) {
                int start = intervals[i][0];
                int end = intervals[i][1];
                if (end >= qValue) { // Only add intervals that cover the current query
                    minHeap.offer(new int[]{start, end});
                }
                i++;
            }

            // Remove intervals from the heap that end before the current query
            while (!minHeap.isEmpty() && minHeap.peek()[1] < qValue) {
                minHeap.poll();
            }

            // If there's any interval that covers the current query, take the smallest one
            if (!minHeap.isEmpty()) {
                int[] smallestInterval = minHeap.peek();
                result[qIndex] = smallestInterval[1] - smallestInterval[0] + 1;
            }
        }

        return result;
    }
}

