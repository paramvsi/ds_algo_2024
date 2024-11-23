package sheet.google.months_6;

// https://leetcode.com/problems/moving-average-from-data-stream/description/

import java.util.LinkedList;
import java.util.Queue;

public class F20MovingAverageFromDataStream {
    private final Queue<Integer> queue; // To store the last 'size' elements
    private final int maxSize; // The maximum size of the moving window
    private double sum; // Running sum of elements in the window

    public F20MovingAverageFromDataStream(int size) {
        this.queue = new LinkedList<>();
        this.maxSize = size;
        this.sum = 0.0;
    }

    public static void main(String[] args) {
        F20MovingAverageFromDataStream movingAverage = new F20MovingAverageFromDataStream(3);

        System.out.println(movingAverage.next(1)); // Output: 1.0
        System.out.println(movingAverage.next(10)); // Output: 5.5
        System.out.println(movingAverage.next(3)); // Output: 4.66667
        System.out.println(movingAverage.next(5)); // Output: 6.0
    }

    public double next(int val) {
        // Add the new value to the queue and update the sum
        queue.add(val);
        sum += val;

        // If the queue exceeds the allowed size, remove the oldest element
        if (queue.size() > maxSize) {
            sum -= queue.poll();
        }

        // Return the moving average
        return sum / queue.size();
    }
}
