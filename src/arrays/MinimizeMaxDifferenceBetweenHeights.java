package arrays;

import java.util.Arrays;

/* Given the heights of N towers and a value of K, Either increase or decrease the height of every tower
by K (only once) where K > 0. After modifications, the task is to minimize the difference between
the heights of the longest and the shortest tower and output its difference.*/
public class MinimizeMaxDifferenceBetweenHeights {
    public static void main(String[] args) {
        int[] arr = {1, 5, 15, 10};
        int k = 3;

        System.out.println("Max Difference between heights is ::" + solve(arr, k));
    }

    private static int solve(int[] arr, int k) {
        int n = arr.length;
        Arrays.sort(arr);
        // Maximum possible height difference
        int ans = arr[n - 1] - arr[0];

        int tempmin, tempmax;

        for (int i = 1; i < n; i++) {

            // if on subtracting k we got negative then
            // continue
            if (arr[i] - k < 0)
                continue;

            // Minimum element when we add k to whole array
            tempmin = Math.min(arr[0] + k, arr[i] - k);
            tempmax = Math.max(arr[i - 1] + k, arr[n - 1] - k);
            ans = Math.min(ans, tempmax - tempmin);
        }
        return ans;

    }
}
