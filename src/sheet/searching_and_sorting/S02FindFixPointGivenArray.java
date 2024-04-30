package sheet.searching_and_sorting;

public class S02FindFixPointGivenArray {

    public static int findFixedPoint(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == mid) {
                return mid;  // Fixed point found
            } else if (nums[mid] < mid) {
                start = mid + 1;  // Search in the right half
            } else {
                end = mid - 1;  // Search in the left half
            }
        }

        return -1;  // No fixed point found
    }

    public static void main(String[] args) {
        int[] nums = {-10, -5, 0, 3, 7};
        System.out.println("Fixed point index: " + findFixedPoint(nums));

        int[] nums2 = {-10, -5, 3, 4, 5, 9};
        System.out.println("Fixed point index: " + findFixedPoint(nums2));
    }
}
