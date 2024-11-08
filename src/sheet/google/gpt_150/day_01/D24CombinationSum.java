package sheet.google.gpt_150.day_01;
/*
Given an array of distinct integers candidates and a target integer target,
find all unique combinations in candidates where the chosen numbers sum to target.
Each number in candidates may be used an unlimited number of times in the combination.
Return a list of all unique combinations. The combinations may be returned in any order.
*/


import java.util.ArrayList;
import java.util.List;

public class D24CombinationSum {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] candidates, int remain, int start) {
        if (remain < 0) {
            return; // If the sum exceeds the target, stop the current path
        } else if (remain == 0) {
            result.add(new ArrayList<>(tempList)); // Found a valid combination
        } else {
            for (int i = start; i < candidates.length; i++) {
                tempList.add(candidates[i]); // Choose the candidate
                backtrack(result, tempList, candidates, remain - candidates[i], i); // Recurse with the same candidate
                tempList.remove(tempList.size() - 1); // Undo the choice (backtrack)
            }
        }
    }

    public static void main(String[] args) {
        int[] candidates1 = {2, 3, 6, 7};
        int target1 = 7;
        System.out.println("Combinations for target " + target1 + ": " + combinationSum(candidates1, target1));
        // Output: [[2, 2, 3], [7]]

        int[] candidates2 = {2, 3, 5};
        int target2 = 8;
        System.out.println("Combinations for target " + target2 + ": " + combinationSum(candidates2, target2));
        // Output: [[2, 2, 2, 2], [2, 3, 3], [3, 5]]
    }
}



