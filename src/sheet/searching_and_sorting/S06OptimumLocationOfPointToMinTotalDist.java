package sheet.searching_and_sorting;

//Weber problem

import java.util.ArrayList;
import java.util.List;

class Point {
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class S06OptimumLocationOfPointToMinTotalDist {

    // Function to calculate Euclidean distance between two points
    static double distance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
    }

    // Function to calculate total distance from a point to a list of points
    static double totalDistance(Point point, List<Point> points) {
        double total = 0;
        for (Point p : points) {
            total += distance(point, p);
        }
        return total;
    }

    // Function to find optimum location of point to minimize total distance
    static Point findOptimumLocation(List<Point> points) {
        // Brute-force approach: Try all possible points and find the one with minimum total distance
        Point optimumPoint = null;
        double minDistance = Double.MAX_VALUE;

        for (int x = 0; x <= 100; x++) { // Assuming coordinates range from 0 to 100
            for (int y = 0; y <= 100; y++) {
                Point currentPoint = new Point(x, y);
                double currentDistance = totalDistance(currentPoint, points);
                if (currentDistance < minDistance) {
                    minDistance = currentDistance;
                    optimumPoint = currentPoint;
                }
            }
        }
        return optimumPoint;
    }

    public static void main(String[] args) {
        List<Point> points = new ArrayList<>();
        points.add(new Point(1, 2));
        points.add(new Point(3, 4));
        points.add(new Point(5, 6));

        Point optimumPoint = findOptimumLocation(points);
        System.out.println("Optimum location of point: (" + optimumPoint.x + ", " + optimumPoint.y + ")");
    }
}
