package sheet.arrays;

import java.util.Arrays;

//Sort an array of 0s, 1s and 2s | Dutch National Flag problem
public class Problem02DutchNationFlag {
    public static void main(String[] args) {
        int[] arr = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};

        System.out.println("Original Array :: " + Arrays.toString(arr));
        System.out.println("Sorted Array :: " + Arrays.toString(sort012(arr)));
    }

    private static int[] sort012(int[] arr) {
        int left = 0, right = arr.length - 1, mid = 0;

        while (mid <= right) {

            if (arr[mid] == 0) {
                swap(arr, left, mid);
                left++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            } else {
                swap(arr, mid, right);
                right--;
            }
        }

        return arr;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}
