package sheet.google.heap;


import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class H04FindKClosestNumbers {

    public static void main(String[] args) {
        H04FindKClosestNumbers finder = new H04FindKClosestNumbers();
        int[] nums = {1, 2, 3, 4, 5};
        int target = 3;
        int k = 2;
        List<Integer> result = finder.findKClosest(nums, target, k);
        System.out.println("The " + k + " closest numbers to " + target + " are: " + result);
    }

    public List<Integer> findKClosest(int[] nums, int target, int k) {
        // Max-Heap to store pairs of (absolute difference, number)
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        for (int num : nums) {
            int diff = Math.abs(num - target);
            maxHeap.offer(new int[]{diff, num}); // Store difference and number

            // If heap size exceeds k, remove the element with the largest difference
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        // Extract the k closest numbers from the heap
        List<Integer> result = new ArrayList<>();
        while (!maxHeap.isEmpty()) {
            result.add(maxHeap.poll()[1]);
        }
        return result;
    }
}

