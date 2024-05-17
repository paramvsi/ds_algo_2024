package sheet.trees.problems;

import java.util.Stack;

public class T38CheckPreorderIsValidOrNot {
    public static boolean isValidPreorder(int[] preorder) {
        // Stack to hold the roots
        Stack<Integer> roots = new Stack<>();
        // Initialize the lower bound of the next node must be greater than this value
        int lowerBound = Integer.MIN_VALUE;

        for (int value : preorder) {
            // If we find a value which is on the right side and smaller than expected minimum, return false
            if (value < lowerBound) {
                return false;
            }

            // If the current value is greater than the stack's top, it means we are done with the left subtree
            // and we need to pop from stack until we find the correct parent for this value
            while (!roots.isEmpty() && value > roots.peek()) {
                lowerBound = roots.pop();  // This value becomes the new lower bound
            }

            // Push the current value onto the stack, it may be a root for the next values
            roots.push(value);
        }

        return true;  // If we didn't find any invalid case, return true
    }

    public static void main(String[] args) {
        int[] preorder = {5, 2, 1, 3, 6};
        if (isValidPreorder(preorder)) {
            System.out.println("The given preorder sequence is valid.");
        } else {
            System.out.println("The given preorder sequence is not valid.");
        }
    }
}

