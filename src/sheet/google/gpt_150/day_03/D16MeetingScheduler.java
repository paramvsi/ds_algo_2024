package sheet.google.gpt_150.day_03;


import java.util.Arrays;
import java.util.List;

public class D16MeetingScheduler {

    public static void main(String[] args) {
        D16MeetingScheduler scheduler = new D16MeetingScheduler();

        int[][] slots1 = {{10, 50}, {60, 120}, {140, 210}};
        int[][] slots2 = {{0, 15}, {60, 70}};
        int duration = 8;
        System.out.println("Earliest meeting slot: " + scheduler.minAvailableDuration(slots1, slots2, duration)); // Output: [60, 68]

        int[][] slots3 = {{10, 50}, {60, 120}, {140, 210}};
        int[][] slots4 = {{0, 15}, {60, 70}};
        int duration2 = 12;
        System.out.println("Earliest meeting slot: " + scheduler.minAvailableDuration(slots3, slots4, duration2)); // Output: []
    }

    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        // Sort both slots by start times
        Arrays.sort(slots1, (a, b) -> Integer.compare(a[0], b[0]));
        Arrays.sort(slots2, (a, b) -> Integer.compare(a[0], b[0]));

        int i = 0, j = 0;

        // Use two pointers to find an overlapping interval of the required duration
        while (i < slots1.length && j < slots2.length) {
            int startOverlap = Math.max(slots1[i][0], slots2[j][0]);
            int endOverlap = Math.min(slots1[i][1], slots2[j][1]);

            // Check if the overlap duration is sufficient
            if (endOverlap - startOverlap >= duration) {
                return List.of(startOverlap, startOverlap + duration);
            }

            // Move the pointer of the interval that ends earlier
            if (slots1[i][1] < slots2[j][1]) {
                i++;
            } else {
                j++;
            }
        }

        // No suitable slot found
        return List.of();
    }
}
