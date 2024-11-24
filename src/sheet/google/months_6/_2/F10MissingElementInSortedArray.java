package sheet.google.months_6._2;

// https://leetcode.com/problems/missing-element-in-sorted-array

public class F10MissingElementInSortedArray {

    public static void main(String[] args) {
        F10MissingElementInSortedArray solution = new F10MissingElementInSortedArray();

        // Test cases
        int[] nums1 = {4, 7, 9, 10};
        System.out.println(solution.missingElement(nums1, 1)); // Output: 5
        System.out.println(solution.missingElement(nums1, 3)); // Output: 8

        int[] nums2 = {1, 2, 4};
        System.out.println(solution.missingElement(nums2, 3)); // Output: 6
    }

    public int missingElement(int[] nums, int k) {
        int n = nums.length;

        // Calculate the total number of missing elements
        int totalMissing = missingCount(nums, n - 1);

        // If k-th missing number is beyond the array
        if (k > totalMissing) {
            return nums[n - 1] + (k - totalMissing);
        }

        // Binary search to find the smallest index where missingCount >= k
        int left = 0, right = n - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (missingCount(nums, mid) < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        // Calculate the k-th missing number
        return nums[left - 1] + (k - missingCount(nums, left - 1));
    }

    // Function to calculate the number of missing elements up to index i
    private int missingCount(int[] nums, int i) {
        return nums[i] - nums[0] - i;
    }
}




