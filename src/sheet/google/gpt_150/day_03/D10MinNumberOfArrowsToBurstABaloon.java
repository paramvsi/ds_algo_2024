package sheet.google.gpt_150.day_03;


import java.util.Arrays;

public class D10MinNumberOfArrowsToBurstABaloon {

    public static void main(String[] args) {
        D10MinNumberOfArrowsToBurstABaloon solution = new D10MinNumberOfArrowsToBurstABaloon();

        int[][] points1 = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        System.out.println("Minimum arrows needed: " + solution.findMinArrowShots(points1)); // Output: 2

        int[][] points2 = {{1, 2}, {3, 4}, {5, 6}, {7, 8}};
        System.out.println("Minimum arrows needed: " + solution.findMinArrowShots(points2)); // Output: 4

        int[][] points3 = {{1, 2}, {2, 3}, {3, 4}, {4, 5}};
        System.out.println("Minimum arrows needed: " + solution.findMinArrowShots(points3)); // Output: 2
    }

    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;

        // Sort the intervals by their end positions
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        // Initialize the number of arrows needed and the position of the last arrow
        int arrows = 1;
        int lastArrowPos = points[0][1];

        // Iterate through the sorted intervals
        for (int i = 1; i < points.length; i++) {
            // If the current balloon's start is beyond the last arrow's position, shoot a new arrow
            if (points[i][0] > lastArrowPos) {
                arrows++;
                lastArrowPos = points[i][1]; // Update the position of the last arrow
            }
            // If current balloon's start <= lastArrowPos, it's already burst by the last arrow
        }

        return arrows;
    }
}

