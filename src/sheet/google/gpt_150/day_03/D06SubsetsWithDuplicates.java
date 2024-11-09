package sheet.google.gpt_150.day_03;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class D06SubsetsWithDuplicates {

    public static void main(String[] args) {
        D06SubsetsWithDuplicates solution = new D06SubsetsWithDuplicates();

        int[] nums1 = {1, 2, 2};
        System.out.println("Subsets for [1, 2, 2]: " + solution.subsetsWithDup(nums1));
        // Output: [[], [1], [1, 2], [1, 2, 2], [2], [2, 2]]

        int[] nums2 = {1, 2, 3};
        System.out.println("Subsets for [1, 2, 3]: " + solution.subsetsWithDup(nums2));
        // Output: [[], [1], [1, 2], [1, 2, 3], [1, 3], [2], [2, 3], [3]]
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Sort the array to handle duplicates
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, int start) {
        result.add(new ArrayList<>(tempList)); // Add the current subset to the result

        for (int i = start; i < nums.length; i++) {
            // If this element is a duplicate and not the start of a new subset, skip it
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            // Include nums[i] in the subset and recurse
            tempList.add(nums[i]);
            backtrack(result, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1); // Backtrack: remove nums[i] and try other possibilities
        }
    }
}

