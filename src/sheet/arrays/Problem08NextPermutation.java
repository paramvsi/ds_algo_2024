package sheet.arrays;

import java.util.Arrays;

// Find Next Permutation of the given array
public class Problem08NextPermutation {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 4, 6};
        nextPermutation(arr);
        System.out.println("Next permutation" + Arrays.toString(arr));
    }

    public static void nextPermutation(int[] nums) {
        if (nums.length <= 1) return;

        int i = nums.length - 2;

        while (i >= 0 && nums[i] >= nums[i + 1]) i--;

        if (i >= 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) j--;
            swap(nums, i, j);
        }

        reverse(nums, i + 1, nums.length - 1);
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static void reverse(int[] a, int i, int j) {
        while (i < j) {
            swap(a, i++, j--);
        }
    }
}
