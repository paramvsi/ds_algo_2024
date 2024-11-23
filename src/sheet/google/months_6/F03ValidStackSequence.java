package sheet.google.months_6;

//  https://leetcode.com/problems/validate-stack-sequences
import java.util.Stack;

public class F03ValidStackSequence {
    public static void main(String[] args) {
        F03ValidStackSequence solution = new F03ValidStackSequence();

        int[] pushed = {1, 2, 3, 4, 5};
        int[] popped = {4, 5, 3, 2, 1};

        System.out.println(solution.validateStackSequences(pushed, popped)); // Output: true

        int[] pushed2 = {1, 2, 3, 4, 5};
        int[] popped2 = {4, 3, 5, 1, 2};

        System.out.println(solution.validateStackSequences(pushed2, popped2)); // Output: false
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int j = 0; // Pointer for popped array

        // Simulate the push and pop operations
        for (int value : pushed) {
            stack.push(value); // Push current value onto the stack

            // Check if the top of the stack matches popped[j]
            while (!stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop(); // Pop the stack
                j++;         // Move to the next element in popped
            }
        }

        // If j matches the length of popped, all elements were successfully matched
        return j == popped.length;
    }
}

