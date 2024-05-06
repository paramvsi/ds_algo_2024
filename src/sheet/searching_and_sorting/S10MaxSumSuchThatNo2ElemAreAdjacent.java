package sheet.searching_and_sorting;

public class S10MaxSumSuchThatNo2ElemAreAdjacent {

    public static int findMaxSum(int[] arr) {
        int n = arr.length;

        if (n == 0) return 0;
        if (n == 1) return arr[0];
        if (n == 2) return Math.max(arr[0], arr[1]);

        // Create an array to store the maximum sum up to index i
        int[] maxSum = new int[n];

        // Base cases
        maxSum[0] = arr[0];
        maxSum[1] = Math.max(arr[0], arr[1]);

        // Calculate maximum sum using dynamic programming
        for (int i = 2; i < n; i++) {
            maxSum[i] = Math.max(arr[i] + maxSum[i - 2], maxSum[i - 1]);
        }

        return maxSum[n - 1];
    }

    public static void main(String[] args) {
        int[] arr = {5, 10, 10, 100, 5, 6};
        System.out.println("Maximum sum such that no two elements are adjacent: " + findMaxSum(arr));
    }
}

