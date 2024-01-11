package arrays;

import java.util.Arrays;

// Given two sorted arrays, the task is to merge them in a sorted manner.
public class MergeSortedArrayInPlace {
    public static void main(String[] args) {
        int[] arr1 = {1, 3, 4, 5};
        int[] arr2 = {2, 4, 6, 8};

        System.out.println("Merged Array" + mergeArray(arr1, arr2));
    }

    private static String mergeArray(int[] arr1, int[] arr2) {
        int[] arr3 = new int[arr1.length + arr2.length];
        int i = 0, j = 0, k = 0;

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                arr3[k++] = arr1[i];
                i++;
            } else {
                arr3[k++] = arr2[j];
                j++;
            }
        }

        while (i < arr1.length) {
            arr3[k++] = arr1[i++];
        }

        while (j < arr2.length) {
            arr3[k++] = arr2[j++];
        }

        return Arrays.toString(arr3);
    }
}
