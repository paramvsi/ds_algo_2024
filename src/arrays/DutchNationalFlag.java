package arrays;

import java.util.Arrays;

//Sort an array of 0s, 1s and 2s | Dutch National Flag problem
public class DutchNationalFlag {
    public static void main(String[] args) {
        int[] arr = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};

        System.out.println("Original Array :: "+ Arrays.toString(arr));
        System.out.println("Sorted Array :: "+ Arrays.toString(sort012(arr)));

    }

    private static int[] sort012(int[] arr) {
        int i =0, j = 0, k = arr.length-1;

        while(j <=k){
            if(arr[j] == 0){
                swap(arr, i, j);
                i++;
                j++;
            } else if(arr[j] == 1){
                j++;
            } else {
                swap(arr, j, k);
                k--;
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
