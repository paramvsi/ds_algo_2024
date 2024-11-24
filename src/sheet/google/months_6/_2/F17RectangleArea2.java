package sheet.google.months_6._2;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class F17RectangleArea2 {

    public static void main(String[] args) {
        F17RectangleArea2 solution = new F17RectangleArea2();

        // Test case 1
        int[][] rectangles1 = {{0, 0, 2, 2}, {1, 1, 3, 3}};
        System.out.println(solution.rectangleArea(rectangles1)); // Output: 6

        // Test case 2
        int[][] rectangles2 = {{0, 0, 1000000000, 1000000000}};
        System.out.println(solution.rectangleArea(rectangles2)); // Output: 49 (modulo 1_000_000_007)
    }

    public int rectangleArea(int[][] rectangles) {
        final int MOD = 1_000_000_007;

        // List of all events
        List<int[]> events = new ArrayList<>();
        for (int[] rect : rectangles) {
            int x1 = rect[0], y1 = rect[1], x2 = rect[2], y2 = rect[3];
            events.add(new int[]{x1, y1, y2, 1}); // Opening event
            events.add(new int[]{x2, y1, y2, -1}); // Closing event
        }

        // Sort events by x-coordinate; for ties, opening events come before closing events
        events.sort((a, b) -> a[0] == b[0] ? b[3] - a[3] : a[0] - b[0]);

        // Active intervals
        List<int[]> active = new ArrayList<>();
        long prevX = 0, totalArea = 0;

        for (int i = 0; i < events.size(); i++) {
            int[] event = events.get(i);
            int currX = event[0], y1 = event[1], y2 = event[2], type = event[3];

            // Calculate the total active area before processing the current event
            long activeArea = computeActiveArea(active);
            totalArea = (totalArea + activeArea * (currX - prevX)) % MOD;

            // Update active intervals based on the current event
            if (type == 1) {
                // Add interval
                active.add(new int[]{y1, y2});
            } else {
                // Remove interval
                active.removeIf(interval -> interval[0] == y1 && interval[1] == y2);
            }

            // Update the previous x-coordinate
            prevX = currX;
        }

        return (int) totalArea;
    }

    // Function to compute the total area covered by active intervals
    private long computeActiveArea(List<int[]> active) {
        // Sort active intervals by their start points
        active.sort(Comparator.comparingInt(a -> a[0]));

        long area = 0, prevY1 = -1, prevY2 = -1;
        for (int[] interval : active) {
            int y1 = interval[0], y2 = interval[1];
            // If the interval overlaps or is adjacent to the previous one, merge them
            if (y1 <= prevY2) {
                prevY2 = Math.max(prevY2, y2);
            } else {
                // Add the previous interval's area to the total
                area += prevY2 - prevY1;
                prevY1 = y1;
                prevY2 = y2;
            }
        }
        // Add the last interval's area
        area += prevY2 - prevY1;
        return area;
    }
}

