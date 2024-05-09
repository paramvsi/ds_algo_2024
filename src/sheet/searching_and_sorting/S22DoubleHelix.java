package sheet.searching_and_sorting;

public class S22DoubleHelix {

    public static int maxSumPath(int[] A, int[] B) {
        int i = 0, j = 0;
        int result = 0, sum1 = 0, sum2 = 0;

        while (i < A.length && j < B.length) {
            if (A[i] < B[j]) {
                sum1 += A[i++];
            } else if (A[i] > B[j]) {
                sum2 += B[j++];
            } else {
                // Common element found, take the max sum path up to this point
                result += Math.max(sum1, sum2) + A[i];
                sum1 = 0;
                sum2 = 0;
                i++;
                j++;
            }
        }

        // Add remaining elements of array A
        while (i < A.length) {
            sum1 += A[i++];
        }

        // Add remaining elements of array B
        while (j < B.length) {
            sum2 += B[j++];
        }

        // Add maximum of remaining sums to result
        result += Math.max(sum1, sum2);

        return result;
    }

    public static void main(String[] args) {
        int[] A = {2, 3, 7, 10, 12};
        int[] B = {1, 5, 7, 8};
        System.out.println("Maximum sum path: " + maxSumPath(A, B));
    }
}

