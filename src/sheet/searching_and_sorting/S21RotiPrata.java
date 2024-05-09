package sheet.searching_and_sorting;


public class S21RotiPrata {
    // Function to check if `P` pratas can be cooked in `mid` time
    public static boolean isPossible(int[] ranks, int P, int mid) {
        int count = 0;
        for (int rank : ranks) {
            int time = 0;
            int i = 1;
            while (time + i * rank <= mid) {
                time += i * rank;
                count++;
                if (count >= P) return true;
                i++;
            }
        }
        return count >= P;
    }

    // Function to find the minimum time needed to cook `P` pratas
    public static int minTime(int[] ranks, int P) {
        int low = 0, high = 10000000;
        int result = high;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (isPossible(ranks, P, mid)) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int P = 10; // Number of pratas to make
        int[] ranks = {1, 2, 3, 4}; // Ranks of cooks

        System.out.println("Minimum time required: " + minTime(ranks, P) + " minutes");
    }
}

