package sheet.google.gpt_150.day_01;

public class D18SortColors {
    public static void sortColors(int[] nums) {
        int i = 0, j = 0, k = nums.length - 1;

        while (j <= k) {
            if (nums[j] == 0) {
                // Swap nums[i] and nums[j]
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j++;
            } else if (nums[j] == 1) {
                // Just move j forward
                j++;
            } else if (nums[j] == 2) {
                // Swap nums[j] and nums[k]
                int temp = nums[k];
                nums[k] = nums[j];
                nums[j] = temp;
                k--;
                // Do not increment j because we need to check the swapped value at j
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 0, 2, 1, 1, 0};
        sortColors(nums1);
        System.out.println("Sorted Colors: " + java.util.Arrays.toString(nums1)); // Output: [0, 0, 1, 1, 2, 2]

        int[] nums2 = {2, 0, 1};
        sortColors(nums2);
        System.out.println("Sorted Colors: " + java.util.Arrays.toString(nums2)); // Output: [0, 1, 2]
    }
}


