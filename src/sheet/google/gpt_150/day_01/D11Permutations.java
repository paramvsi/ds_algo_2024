package sheet.google.gpt_150.day_01;

import java.util.ArrayList;
import java.util.List;

public class D11Permutations {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int[] nums, List<Integer> tempList, List<List<Integer>> result) {
        // If the temporary list is the same length as nums, we have a complete permutation
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
            return;
        }

        // Loop through each number in nums
        for (int num : nums) {
            // Skip if number is already used in the current permutation
            if (tempList.contains(num)) continue;

            tempList.add(num);           // Choose the number
            backtrack(nums, tempList, result);  // Explore further
            tempList.remove(tempList.size() - 1); // Un-choose (backtrack)
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println("Permutations of " + java.util.Arrays.toString(nums) + ":");
        System.out.println(permute(nums));
    }
}



