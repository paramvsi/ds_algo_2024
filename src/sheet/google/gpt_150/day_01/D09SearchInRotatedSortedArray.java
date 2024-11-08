package sheet.google.gpt_150.day_01;

public class D09SearchInRotatedSortedArray {

    private static int searchInRotatedArray(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            // Check if mid is the target
            if (nums[mid] == target) {
                return mid;
            }

            // Check if the left half is sorted
            if (nums[start] <= nums[mid]) {
                // Target lies in the left sorted portion
                if (nums[start] <= target && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            // Right half must be sorted
            else {
                // Target lies in the right sorted portion
                if (nums[mid] < target && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return -1; // Target not found
    }

    public static void main(String[] args) {
        int[] nums1 = {4, 5, 6, 7, 0, 1, 2};
        int[] nums2 = {1};
        int[] nums3 = {1, 3};
        int[] nums4 = {5, 6, 7, 8, 9, 1, 2, 3, 4};

        System.out.println("Test Case 1: Expected 4, Actual: " + searchInRotatedArray(nums1, 0));
        System.out.println("Test Case 2: Expected -1, Actual: " + searchInRotatedArray(nums1, 3));
        System.out.println("Test Case 3: Expected -1, Actual: " + searchInRotatedArray(nums2, 0));
        System.out.println("Test Case 4: Expected 1, Actual: " + searchInRotatedArray(nums3, 3));
        System.out.println("Test Case 5: Expected 6, Actual: " + searchInRotatedArray(nums4, 2));
    }
}
