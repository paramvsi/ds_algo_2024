package sheet.google.gpt_150.day_02;

public class D34RotationCount {

    public static void main(String[] args) {
        D34RotationCount solution = new D34RotationCount();

        int[] nums1 = {15, 18, 2, 3, 6, 12};
        System.out.println("Rotation count: " + solution.findRotationCount(nums1)); // Output: 2

        int[] nums2 = {7, 9, 11, 12, 5};
        System.out.println("Rotation count: " + solution.findRotationCount(nums2)); // Output: 4

        int[] nums3 = {3, 4, 5, 1, 2};
        System.out.println("Rotation count: " + solution.findRotationCount(nums3)); // Output: 3
    }

    public int findRotationCount(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        // Binary search to find the index of the minimum element
        while (left < right) {
            int mid = left + (right - left) / 2;

            // If mid element is greater than the right element, the minimum is in the right half
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            }
            // If mid element is less than or equal to the right element, the minimum is in the left half
            else {
                right = mid;
            }
        }

        // The left (or right) will be pointing to the smallest element, which is the rotation count
        return left;
    }
}

