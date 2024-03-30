package sheet.arrays;

// Given an array arr[] of integers and a number x,
// the task is to find the smallest subarray with a sum greater than the given value.
public class Problem18SmallestSubArrayWithSumGreaterThanK {
    public static void main(String[] args) {
        int[] arr = {1, 4, 45, 6, 0, 19};
        int k = 51;

        System.out.println(smallestSubWithSum(arr, arr.length, k));
    }

    static int smallestSubWithSum(int[] arr, int n, int x) {
        // Initialize current sum and minimum length
        int curr_sum = 0, min_len = n + 1;

        // Initialize starting and ending indexes
        int start = 0, end = 0;
        while (end < n) {
            // Keep adding array elements while current sum
            // is smaller than or equal to x
            while (curr_sum <= x && end < n) curr_sum += arr[end++];

            // If current sum becomes greater than x.
            while (curr_sum > x && start < n) {
                // Update minimum length if needed
                if (end - start < min_len) min_len = end - start;

                // remove starting elements
                curr_sum -= arr[start++];
            }
        }
        return min_len;
    }

}
