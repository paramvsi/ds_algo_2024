package sheet.google.practice.arrays;

public class A04RotateArray {
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;  // Normalize k to be within the bounds of nums length
        int[] temp = new int[k];  // Temporary array to hold the last k elements

        // Store the last k elements into temp
        for (int i = 0; i < k; i++) {
            temp[i] = nums[n - k + i];
        }

        // Shift the remaining elements to the right
        for (int i = n - 1; i >= k; i--) {
            nums[i] = nums[i - k];
        }

        // Move the k elements from temp to the beginning of nums
        for (int i = 0; i < k; i++) {
            nums[i] = temp[i];
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7}; // Example input
        int k = 3; // Number of rotation steps
        rotate(nums, k);
        System.out.print("Array after rotation: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}

