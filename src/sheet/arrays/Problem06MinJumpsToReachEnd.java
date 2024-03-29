package sheet.arrays;

public class Problem06MinJumpsToReachEnd {

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};

        System.out.println("Min Jumps Required:  " + findMinJumps(arr));
    }

    private static int findMinJumps(int[] arr) {
        int totalJumps = 0;
        int destination = arr.length - 1;
        int coverage = 0;
        int lastIdx = 0;

        if (arr.length == 1) return 0;

        for (int i = 0; i <= arr.length - 1; i++) {
            coverage = Math.max(coverage, i + arr[i]);

            if (i == lastIdx) {
                lastIdx = coverage;
                totalJumps++;

                if (coverage >= destination) {
                    return totalJumps;
                }
            }
        }

        return totalJumps;
    }
}
