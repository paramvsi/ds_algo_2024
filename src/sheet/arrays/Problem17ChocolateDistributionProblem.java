package sheet.arrays;

import java.util.Arrays;

public class Problem17ChocolateDistributionProblem {
    public static void main(String[] args) {
        int[] arr = {7, 3, 2, 4, 9, 12, 56};
        int m = 3;System.out.println(findMinDiff(arr, arr.length, m));
    }

    public static int findMinDiff(int[] a, int n, int m) {
        Arrays.sort(a);

        int start = 0, end = 0;
        // Largest number of chocolates
        int mind = Integer.MAX_VALUE;

        // Find the subarray of size m such that
        // difference between last (maximum in case
        // of sorted) and first (minimum in case of
        // sorted) elements of subarray is minimum.
        for (int i = 0; i + m - 1 < n; i++) {
            int diff = a[i + m - 1] - a[i];
            if (mind > diff) {
                mind = diff;
                start = i;
                end = i + m - 1;
            }
        }
        return a[end] - a[start];
    }
}
