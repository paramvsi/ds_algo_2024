package sheet.google.gpt_150.day_03;


import java.util.ArrayList;
import java.util.List;

public class D03CombinationSum3 {

    public static void main(String[] args) {
        D03CombinationSum3 solution = new D03CombinationSum3();

        System.out.println("Combinations for k=3, n=7: " + solution.combinationSum3(3, 7)); // Output: [[1, 2, 4]]
        System.out.println("Combinations for k=3, n=9: " + solution.combinationSum3(3, 9)); // Output: [[1, 2, 6], [1, 3, 5], [2, 3, 4]]
        System.out.println("Combinations for k=4, n=1: " + solution.combinationSum3(4, 1)); // Output: []
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), k, n, 1);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> currentCombination, int k, int n, int start) {
        // Base case: If the combination has k numbers and the sum is n
        if (currentCombination.size() == k && n == 0) {
            result.add(new ArrayList<>(currentCombination));
            return;
        }

        // If the combination has more than k numbers or the sum goes negative
        if (currentCombination.size() > k || n < 0) {
            return;
        }

        // Explore numbers from start to 9
        for (int i = start; i <= 9; i++) {
            currentCombination.add(i);
            backtrack(result, currentCombination, k, n - i, i + 1);
            currentCombination.remove(currentCombination.size() - 1); // Backtrack
        }
    }
}

