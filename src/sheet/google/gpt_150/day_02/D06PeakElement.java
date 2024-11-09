package sheet.google.gpt_150.day_02;

public class D06PeakElement {

    public static int peakElement(int[] nums) {
        int n = nums.length;

        int start = 0;
        int end = n - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            // Check if mid is a peak
            if ((mid == 0 || nums[mid] > nums[mid - 1]) &&
                    (mid == n - 1 || nums[mid] > nums[mid + 1])) {
                return mid;
            }
            // If the left neighbor is greater, move to the left half
            else if (mid > 0 && nums[mid] < nums[mid - 1]) {
                end = mid - 1;
            }
            // Otherwise, move to the right half
            else {
                start = mid + 1;
            }
        }

        return start;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 1};
        int[] nums2 = {1, 2, 1, 3, 5, 6, 4};
        int[] nums3 = {10, 20, 15};
        int[] nums4 = {1};
        int[] nums5 = {5, 10, 20, 15};

        System.out.println("Peak in nums1: " + peakElement(nums1)); // Output: 2 (index of 3)
        System.out.println("Peak in nums2: " + peakElement(nums2)); // Output: 1 or 5 (index of 2 or 6)
        System.out.println("Peak in nums3: " + peakElement(nums3)); // Output: 1 (index of 20)
        System.out.println("Peak in nums4: " + peakElement(nums4)); // Output: 0 (only element)
        System.out.println("Peak in nums5: " + peakElement(nums5)); // Output: 2 (index of 20)
    }

}
