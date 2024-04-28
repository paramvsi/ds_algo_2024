package sheet.searching_and_sorting;

public class S01FindFirstAndLastPositionOfElemInSortedArray {

    public static void main(String[] args) {
        S01FindFirstAndLastPositionOfElemInSortedArray solution = new S01FindFirstAndLastPositionOfElemInSortedArray();
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] positions = solution.searchRange(nums, target);
        System.out.println("First and last positions: [" + positions[0] + ", " + positions[1] + "]");
    }

    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        result[0] = findFirst(nums, target);
        result[1] = findLast(nums, target);
        return result;
    }

    private int findFirst(int[] nums, int target) {
        int idx = -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] >= target) {
                if (nums[mid] == target) idx = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return idx;
    }

    private int findLast(int[] nums, int target) {
        int idx = -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] <= target) {
                if (nums[mid] == target) idx = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return idx;
    }
}

