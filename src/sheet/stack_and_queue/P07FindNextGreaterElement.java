package sheet.stack_and_queue;

import java.util.Arrays;
import java.util.Stack;

public class P07FindNextGreaterElement {
    public static int[] findNextGreaterElements(int[] nums) {
        int[] result = new int[nums.length]; // Array to store the result
        Stack<Integer> stack = new Stack<>(); // Stack to keep indexes of nums array

        // Initialize result array with -1
        Arrays.fill(result, -1);

        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                result[stack.pop()] = nums[i];
            }
            stack.push(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 5, 6, 2, 3};
        int[] result = findNextGreaterElements(nums);
        System.out.println("Next Greater Elements: " + Arrays.toString(result));
    }
}


