package sheet.google.gpt_150.day_02;


public class D10SingleElementInSortedArray {
    public static int singleNonDuplicate(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            // Ensure mid is even to check pairs more easily
            if (mid % 2 == 1) {
                mid--; // Move mid to the left if it's odd
            }

            // Check if the pair starting at mid is valid
            if (nums[mid] == nums[mid + 1]) {
                start = mid + 2; // Move right if the pair is intact
            } else {
                end = mid; // Move left otherwise
            }
        }

        // Start will eventually point to the single element
        return nums[start];
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 1, 2, 3, 3, 4, 4, 8, 8};
        int[] nums2 = {3, 3, 7, 7, 10, 11, 11};

        System.out.println("Single element in nums1: " + singleNonDuplicate(nums1)); // Output: 2
        System.out.println("Single element in nums2: " + singleNonDuplicate(nums2)); // Output: 10
    }
}

