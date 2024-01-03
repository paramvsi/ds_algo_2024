package arrays;

import java.util.Arrays;

// Given an array (or string), the task is to reverse the array/string.
public class ArrayReverse {
    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 1, 0};
        System.out.println("Original Array :" + Arrays.toString(arr));
        System.out.println("Reversed Array :" + Arrays.toString(reverseArray(arr)));
    }

    private static int[] reverseArray(int[] arr) {
        int i = 0, j = arr.length - 1;
        while (i <= j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        return arr;
    }
}
