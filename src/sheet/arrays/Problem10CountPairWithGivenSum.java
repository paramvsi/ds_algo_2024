package sheet.arrays;

import java.util.HashMap;
import java.util.Map;

//Given an array of N integers, and an integer K,
// the task is to find the number of pairs of integers in the array whose sum is equal to K.
public class Problem10CountPairWithGivenSum {
    public static void main(String[] args) {
        int[] arr = {1, 5, 7, -1, 5};
        int k = 6;

        System.out.println("No. of Pairs with sum equal to K " + countPairs(arr, k));
    }

    private static int countPairs(int[] arr, int K) {
        int count = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for (int j : arr) {
            if (map.containsKey(K - j)) {
                count += map.get(K - j);
            } else if (map.containsKey(j)) {
                map.put(j, map.get(j) + 1);
            } else {
                map.put(j, 1);
            }
        }

        return count;
    }
}
