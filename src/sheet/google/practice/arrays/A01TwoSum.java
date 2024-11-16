package sheet.google.practice.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class A01TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        // Implement your logic here
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            } else {
                map.put(nums[i], i);
            }
        }

        return new int[]{}; // Return the array with indices
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15}; // Example input
        int target = 9;
        System.out.println("Indices of numbers that add up to the target: " + Arrays.toString(twoSum(nums, target)));
    }
}
