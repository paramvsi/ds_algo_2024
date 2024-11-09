package sheet.google.gpt_150.day_02;


import java.util.ArrayList;
import java.util.List;

public class D16FindDuplicatesInAArray {
    public static void main(String[] args) {
        D16FindDuplicatesInAArray solution = new D16FindDuplicatesInAArray();

        int[] nums1 = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println("Duplicates: " + solution.findDuplicates(nums1)); // Output: [2, 3]

        int[] nums2 = {1, 1, 2};
        System.out.println("Duplicates: " + solution.findDuplicates(nums2)); // Output: [1]

        int[] nums3 = {1};
        System.out.println("Duplicates: " + solution.findDuplicates(nums3)); // Output: []
    }

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();

        // Iterate through each number in the array
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1; // Get the index based on the current number

            // If the value at this index is negative, it means we've seen this number before
            if (nums[index] < 0) {
                result.add(index + 1);
            } else {
                // Otherwise, mark this number as seen by making it negative
                nums[index] = -nums[index];
            }
        }

        // (Optional) Restore the original array by making all numbers positive again
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Math.abs(nums[i]);
        }

        return result;
    }
}

