package sheet.searching_and_sorting;


import java.util.HashMap;
import java.util.Map;

public class S07FindMinAndRepeatingElem {

    public static void findMinAndRepeating(int[] arr) {
        int min = Integer.MAX_VALUE;
        int repeatingElement = 0;

        Map<Integer, Integer> countMap = new HashMap<>();

        for (int num : arr) {
            // Update minimum element
            if (num < min) {
                min = num;
            }

            // Update count of current element
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);

            // Check if current element is repeating
            if (countMap.get(num) > 1) {
                repeatingElement = num;
            }
        }

        System.out.println("Minimum element: " + min);
        System.out.println("Repeating element: " + repeatingElement);
    }

    public static void findMinAndRepeatingConstantSpace(int[] arr) {
        int min = Integer.MAX_VALUE;
        int repeatingElement = 0;

        // Traverse the array
        for (int i = 0; i < arr.length; i++) {
            // Update minimum element
            if (arr[i] < min) {
                min = arr[i];
            }

            // Check for repeating element
            if (arr[Math.abs(arr[i])] >= 0) {
                arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
            } else {
                repeatingElement = Math.abs(arr[i]);
            }
        }

        System.out.println("Minimum element: " + min);
        System.out.println("Repeating element: " + repeatingElement);
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 5, 2, 5, 4};
        findMinAndRepeating(arr);
        findMinAndRepeatingConstantSpace(arr);
    }
}

