package sheet.google.gpt_150.day_03;
/*
Given a list of non-overlapping intervals sorted by their start time, and an interval newInterval,
insert newInterval into intervals such that the list remains sorted and non-overlapping.
You may need to merge the new interval with any overlapping intervals.*/

import java.util.ArrayList;
import java.util.List;

public class D13InsertInterval {

    public static void main(String[] args) {
        D13InsertInterval solution = new D13InsertInterval();

        int[][] intervals1 = {{1, 3}, {6, 9}};
        int[] newInterval1 = {2, 5};
        System.out.println("Merged intervals: " + java.util.Arrays.deepToString(solution.insert(intervals1, newInterval1)));
        // Output: [[1, 5], [6, 9]]

        int[][] intervals2 = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval2 = {4, 8};
        System.out.println("Merged intervals: " + java.util.Arrays.deepToString(solution.insert(intervals2, newInterval2)));
        // Output: [[1, 2], [3, 10], [12, 16]]
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;
        int n = intervals.length;

        // Add all intervals that end before newInterval starts
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // Merge overlapping intervals with newInterval
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        // Add the merged interval
        result.add(newInterval);

        // Add all intervals that start after newInterval ends
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        // Convert the result list to a 2D array
        return result.toArray(new int[result.size()][]);
    }
}

