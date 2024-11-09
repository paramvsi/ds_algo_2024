package sheet.google.gpt_150.day_02;


public class D07RotatedSortedArray3 {
    public static boolean search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            // If the target is found at mid, return true
            if (nums[mid] == target) {
                return true;
            }

            // Handle duplicates: if start, mid, and end are all equal, skip duplicates
            if (nums[start] == nums[mid] && nums[mid] == nums[end]) {
                start++;
                end--;
            }
            // Check if the left half is sorted
            else if (nums[start] <= nums[mid]) {
                // If target is within the range of the sorted left half, search left
                if (nums[start] <= target && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    // Otherwise, search right
                    start = mid + 1;
                }
            }
            // Right half is sorted
            else {
                // If target is within the range of the sorted right half, search right
                if (nums[mid] < target && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    // Otherwise, search left
                    end = mid - 1;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 5, 6, 0, 0, 1, 2};
        int target1 = 0;
        System.out.println("Found target in nums1: " + search(nums1, target1)); // Output: true

        int[] nums2 = {2, 5, 6, 0, 0, 1, 2};
        int target2 = 3;
        System.out.println("Found target in nums2: " + search(nums2, target2)); // Output: false

        int[] nums3 = {1, 0, 1, 1, 1};
        int target3 = 0;
        System.out.println("Found target in nums3: " + search(nums3, target3)); // Output: true
    }
}

