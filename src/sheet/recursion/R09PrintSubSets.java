package sheet.recursion;

import java.util.ArrayList;
import java.util.List;

public class R09PrintSubSets {
    public static void generateSubsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        backtrack(subsets, new ArrayList<>(), nums, 0);
        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }
    }

    private static void backtrack(List<List<Integer>> subsets, List<Integer> tempList, int[] nums, int start) {
        subsets.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]); // include the current element
            backtrack(subsets, tempList, nums, i + 1); // move on to the next element
            tempList.removeLast(); // exclude the current element and backtrack
        }
    }

    public static void generateSubsetsMyCode(String input, String output){
        if(input.isEmpty()){
            System.out.println(output);
            return;
        }

        String op2 = output;

        op2 = op2 + input.charAt(0);
        input = input.substring(1);

        generateSubsetsMyCode(input, output);
        generateSubsetsMyCode(input, op2);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        generateSubsets(nums);
        System.out.println("-------------------------------------------");
        String input = "ABC";
        generateSubsetsMyCode(input, "");
    }
}
