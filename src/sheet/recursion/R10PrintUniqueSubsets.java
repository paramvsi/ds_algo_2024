package sheet.recursion;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class R10PrintUniqueSubsets {
    public static void generateUniqueSubsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        Arrays.sort(nums);  // Sort the array to handle duplicates
        backtrack(subsets, new ArrayList<>(), nums, 0);
        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }
    }

    private static void backtrack(List<List<Integer>> subsets, List<Integer> tempList, int[] nums, int start) {
        subsets.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            // If the current element is the same as the one before, skip it
            if (i > start && nums[i] == nums[i - 1]) continue;
            tempList.add(nums[i]);  // include the current element
            backtrack(subsets, tempList, nums, i + 1);  // move on to the next element
            tempList.removeLast();  // exclude the current element and backtrack
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3};  // Example input with duplicates
        generateUniqueSubsets(nums);
    }
}

