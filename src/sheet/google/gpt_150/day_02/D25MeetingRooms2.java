package sheet.google.gpt_150.day_02;


import java.util.Arrays;

public class D25MeetingRooms2 {
    public static void main(String[] args) {
        D25MeetingRooms2 solution = new D25MeetingRooms2();

        int[][] intervals1 = {{0, 30}, {5, 10}, {15, 20}};
        System.out.println("Minimum rooms required: " + solution.minMeetingRooms(intervals1)); // Output: 2

        int[][] intervals2 = {{7, 10}, {2, 4}};
        System.out.println("Minimum rooms required: " + solution.minMeetingRooms(intervals2)); // Output: 1
    }

    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        // Extract start and end times into separate arrays
        int[] startTimes = new int[intervals.length];
        int[] endTimes = new int[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            startTimes[i] = intervals[i][0];
            endTimes[i] = intervals[i][1];
        }

        // Sort both arrays
        Arrays.sort(startTimes);
        Arrays.sort(endTimes);

        int startPointer = 0, endPointer = 0;
        int roomsNeeded = 0, maxRooms = 0;

        // Iterate through each meeting's start time
        while (startPointer < intervals.length) {
            // A new meeting starts before the previous one ends, so we need a new room
            if (startTimes[startPointer] < endTimes[endPointer]) {
                roomsNeeded++;
                startPointer++;
            } else {
                // Otherwise, a room is freed up (move the endPointer)
                roomsNeeded--;
                endPointer++;
            }

            // Track the maximum number of rooms needed
            maxRooms = Math.max(maxRooms, roomsNeeded);
        }

        return maxRooms;
    }
}

