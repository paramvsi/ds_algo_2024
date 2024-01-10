package arrays;


import java.util.ArrayList;
import java.util.List;

// Given an array of n elements that contains elements from 0 to n-1, with any of these
// numbers appearing any number of times.
// Find these repeating numbers in O(n) and use only constant memory space.
public class FindDuplicatesInNPlusOneInteger {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 6, 3, 6, 1};

        System.out.println("Duplicates are : " + findDuplicates(arr));
    }

    private static String findDuplicates(int[] arr) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            int index = Math.abs(arr[i]);

            if (arr[index] < 0) {
                result.add(Math.abs(index));
            }

            arr[index] = arr[index] * -1;
        }

        return result.toString();
    }
}
