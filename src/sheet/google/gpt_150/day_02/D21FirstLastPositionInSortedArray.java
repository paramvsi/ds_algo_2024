package sheet.google.gpt_150.day_02;


public class D21FirstLastPositionInSortedArray {

    public static void main(String[] args) {
        D21FirstLastPositionInSortedArray solution = new D21FirstLastPositionInSortedArray();

        int[] nums1 = {5, 7, 7, 8, 8, 10};
        int target1 = 8;
        int[] result1 = solution.searchRange(nums1, target1);
        System.out.println("First and Last Position: [" + result1[0] + ", " + result1[1] + "]"); // Output: [3, 4]

        int[] nums2 = {5, 7, 7, 8, 8, 10};
        int target2 = 6;
        int[] result2 = solution.searchRange(nums2, target2);
        System.out.println("First and Last Position: [" + result2[0] + ", " + result2[1] + "]"); // Output: [-1, -1]

        int[] nums3 = {};
        int target3 = 0;
        int[] result3 = solution.searchRange(nums3, target3);
        System.out.println("First and Last Position: [" + result3[0] + ", " + result3[1] + "]"); // Output: [-1, -1]
    }

    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};

        // Find the first position of the target
        result[0] = findFirstPosition(nums, target);
        // Find the last position of the target
        result[1] = findLastPosition(nums, target);

        return result;
    }

    private int findFirstPosition(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int firstPosition = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                firstPosition = mid;
                right = mid - 1;  // Continue searching to the left
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return firstPosition;
    }

    private int findLastPosition(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int lastPosition = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                lastPosition = mid;
                left = mid + 1;  // Continue searching to the right
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return lastPosition;
    }
}

