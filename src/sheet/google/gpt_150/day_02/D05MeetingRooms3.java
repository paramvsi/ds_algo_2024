package sheet.google.gpt_150.day_02;

/*
The "Meeting Rooms III" problem involves scheduling meetings in a set of rooms,
ensuring that each meeting is assigned to the lowest-numbered available room.
If all rooms are occupied, the meeting is delayed until a room becomes free, maintaining its original duration.
 The goal is to determine which room hosts the most meetings.

Approach:
To solve this problem efficiently, we can utilize two priority queues (min-heaps):
Available Rooms Heap: This heap keeps track of rooms that are currently free, ordered by their room numbers.
Occupied Rooms Heap: This heap manages rooms that are currently in use, ordered by their next available time.
*/


import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class D05MeetingRooms3 {
    public static void main(String[] args) {
        D05MeetingRooms3 solution = new D05MeetingRooms3();
        int n = 3;
        int[][] meetings = {{1, 20}, {2, 10}, {3, 5}, {4, 9}, {6, 8}};
        int result = solution.mostBooked(n, meetings);
        System.out.println("The room that held the most meetings is: " + result);
    }

    public int mostBooked(int n, int[][] meetings) {
        // Sort meetings by start time
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));

        // Priority queue for available rooms (min-heap based on room number)
        PriorityQueue<Integer> availableRooms = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            availableRooms.offer(i);
        }

        // Priority queue for occupied rooms (min-heap based on end time)
        PriorityQueue<int[]> occupiedRooms = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        // Array to count meetings held in each room
        int[] meetingCount = new int[n];

        for (int[] meeting : meetings) {
            int start = meeting[0];
            int end = meeting[1];

            // Release rooms that have become free by the start time
            while (!occupiedRooms.isEmpty() && occupiedRooms.peek()[0] <= start) {
                availableRooms.offer(occupiedRooms.poll()[1]);
            }

            if (!availableRooms.isEmpty()) {
                // Assign meeting to the lowest-numbered available room
                int room = availableRooms.poll();
                meetingCount[room]++;
                occupiedRooms.offer(new int[]{end, room});
            } else {
                // Delay the meeting until the earliest room becomes free
                int[] earliest = occupiedRooms.poll();
                int room = earliest[1];
                int newEnd = earliest[0] + (end - start);
                meetingCount[room]++;
                occupiedRooms.offer(new int[]{newEnd, room});
            }
        }

        // Find the room with the most meetings
        int maxMeetings = 0;
        int resultRoom = 0;
        for (int i = 0; i < n; i++) {
            if (meetingCount[i] > maxMeetings) {
                maxMeetings = meetingCount[i];
                resultRoom = i;
            }
        }

        return resultRoom;
    }
}

