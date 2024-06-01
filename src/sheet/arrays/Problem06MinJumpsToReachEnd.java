package sheet.arrays;

public class Problem06MinJumpsToReachEnd {

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};

        System.out.println("Min Jumps Required:  " + findMinJumps(arr));
    }

    private static int findMinJumps(int[] arr) {
        if (arr.length <= 1) return 0;

        if (arr[0] >= arr.length - 1) return 1;

        if (arr[0] == 0) return -1;

        int maxReach = arr[0];
        int step = arr[0];
        int jump = 1;

        for (int i = 1; i < arr.length; i++) {
            if (i == arr.length - 1) return jump;

            if (arr[i] >= (arr.length - 1) - i) return jump + 1;

            maxReach = Math.max(maxReach, i + arr[i]);

            step--;

            if (step == 0) {
                jump++;

                if (i >= maxReach) return -1;

                step = maxReach - i;
            }
        }

        return -1;
    }
}
