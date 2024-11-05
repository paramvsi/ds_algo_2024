package sheet.google.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class H05FindKClosestPointToOrigin {

    public static void main(String[] args) {
        H05FindKClosestPointToOrigin finder = new H05FindKClosestPointToOrigin();
        int[][] points = {{1, 3}, {-2, 2}, {5, 8}, {0, 1}};
        int k = 2;
        int[][] result = finder.kClosest(points, k);

        System.out.println("The " + k + " closest points to the origin are:");
        for (int[] point : result) {
            System.out.println(Arrays.toString(point));
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        // Max-Heap to store points based on their distance to the origin
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));

        for (int[] point : points) {
            int x = point[0];
            int y = point[1];
            int distance = x * x + y * y; // We use squared distance for comparison

            maxHeap.offer(new int[]{distance, x, y});

            // If heap size exceeds k, remove the farthest point
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        // Extract the k closest points from the heap
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            int[] closest = maxHeap.poll();
            assert closest != null;
            result[i][0] = closest[1];
            result[i][1] = closest[2];
        }

        return result;
    }
}

