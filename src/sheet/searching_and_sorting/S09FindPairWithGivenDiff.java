package sheet.searching_and_sorting;

import java.util.HashSet;
import java.util.Set;

public class S09FindPairWithGivenDiff {

    public static boolean findPair(int[] arr, int targetDiff) {
        Set<Integer> set = new HashSet<>();

        for (int num : arr) {
            // Check if the complement (targetDiff + num or num - targetDiff) exists in the set
            if (set.contains(targetDiff + num) || set.contains(num - targetDiff)) {
                return true; // Pair found
            }

            // Add current number to the set
            set.add(num);
        }

        return false; // Pair not found
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 4, 2};
        int targetDiff = 2;

        if (findPair(arr, targetDiff)) {
            System.out.println("Pair with the given difference found.");
        } else {
            System.out.println("Pair with the given difference not found.");
        }
    }
}

