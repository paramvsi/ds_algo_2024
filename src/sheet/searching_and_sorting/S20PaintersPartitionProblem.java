package sheet.searching_and_sorting;

// The "Painters Partition Problem" involves dividing a given length into the
// minimum number of contiguous segments such that the maximum sum of each segment is minimized.
// This problem can be solved using binary search.

public class S20PaintersPartitionProblem {

    public static int paintersPartition(int[] boards, int painters) {
        int low = getMax(boards);
        int high = getSum(boards);

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (isFeasible(boards, painters, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low; // Minimum maximum segment sum found
    }

    private static int getMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int num : arr) {
            max = Math.max(max, num);
        }
        return max;
    }

    private static int getSum(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }

    private static boolean isFeasible(int[] arr, int painters, int maxSegmentSum) {
        int paintersRequired = 1;
        int currentSum = 0;

        for (int length : arr) {
            currentSum += length;
            if (currentSum > maxSegmentSum) {
                paintersRequired++;
                currentSum = length;
            }
            if (paintersRequired > painters) {
                return false; // Painters required exceeds the limit
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] boards = {10, 20, 30, 40}; // Example input array
        int painters = 2; // Example number of painters
        System.out.println("Minimum maximum segment sum: " + paintersPartition(boards, painters));
    }
}
