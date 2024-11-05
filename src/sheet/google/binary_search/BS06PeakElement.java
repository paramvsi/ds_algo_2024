package sheet.google.binary_search;

// Find a peak element which is not smaller than its neighbours
public class BS06PeakElement {
    public static int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[mid + 1]) {
                // Peak is in the left half
                right = mid;
            } else {
                // Peak is in the right half
                left = mid + 1;
            }
        }

        // left == right is the peak element
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int peakIndex = findPeakElement(nums);
        System.out.println("Peak element is at index: " + peakIndex);
    }
}
