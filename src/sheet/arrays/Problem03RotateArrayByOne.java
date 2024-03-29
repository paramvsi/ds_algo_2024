package sheet.arrays;

import java.util.Arrays;

// Cyclically rotate array by one
public class Problem03RotateArrayByOne {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};

        System.out.println(Arrays.toString(rotatedArray(arr)));
    }

    private static int[] rotatedArray(int[] arr) {
        int lastElem = arr[arr.length - 1];

        for (int i = arr.length - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }

        arr[0] = lastElem;

        return arr;
    }


}
