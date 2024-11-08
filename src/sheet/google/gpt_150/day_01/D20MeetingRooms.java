package sheet.google.gpt_150.day_01;


import java.util.Arrays;
import java.util.Comparator;

public class D20MeetingRooms {
    public static boolean canAttendMeetings(int[][] intervals) {
        // Sort intervals by start time
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        // Check for overlap
        for (int i = 1; i < intervals.length; i++) {
            // If the current meeting starts before the previous one ends, there's an overlap
            if (intervals[i][0] < intervals[i - 1][1]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[][] intervals1 = {{0, 30}, {5, 10}, {15, 20}};
        System.out.println("Can attend all meetings: " + canAttendMeetings(intervals1)); // Output: false

        int[][] intervals2 = {{7, 10}, {2, 4}};
        System.out.println("Can attend all meetings: " + canAttendMeetings(intervals2)); // Output: true
    }
}

