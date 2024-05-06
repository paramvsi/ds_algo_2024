package sheet.searching_and_sorting;


import java.util.Arrays;

public class S15AggresiveCows {

    public static int maxMinDistance(int[] stalls, int cows) {
        Arrays.sort(stalls); // Sort the stalls in ascending order
        int low = 1; // Minimum possible distance between any two cows
        int high = stalls[stalls.length - 1] - stalls[0]; // Maximum possible distance between any two cows
        int maxMinDistance = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isValid(stalls, cows, mid)) {
                maxMinDistance = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return maxMinDistance;
    }

    private static boolean isValid(int[] stalls, int cows, int distance) {
        int placedCows = 1; // At least one cow can always be placed
        int prevPosition = stalls[0];

        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - prevPosition >= distance) {
                placedCows++;
                prevPosition = stalls[i];
            }
            if (placedCows == cows) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] stalls = {1, 2, 4, 8, 9};
        int cows = 3;
        System.out.println("Maximum minimum distance between any two cows: " + maxMinDistance(stalls, cows));
    }
}


