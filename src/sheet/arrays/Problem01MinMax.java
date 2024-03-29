package sheet.arrays;

import java.util.Arrays;

// Find the minimum and maximum element in the array
public class Problem01MinMax {
    public static void main(String[] args) {
        int[] arr =  {3, 5, 4, 1, 9};

        System.out.println("Array is::" + Arrays.toString(arr));
        int[] res = minMax(arr);

        System.out.println("Min element is: "+res[0]);
        System.out.println("Max element is: "+res[1]);
    }

    private static int[] minMax(int[] arr) {
        int[] res = {Integer.MAX_VALUE, Integer.MIN_VALUE};

        for(int item: arr){
            res[0] = Math.min(res[0], item);
            res[1] = Math.max(res[1], item);
        }

        return res;
    }
}
