package sheet.recursion;

import java.util.Stack;

public class R05DeleteMiddleElemOfStack {
    // Function to delete the middle element of the stack
    public static void deleteMiddle(Stack<Integer> stack, int sizeOfStack) {
        // Base case: If the stack is empty, return immediately
        if (stack.isEmpty()) {
            return;
        }

        // Find the middle index
        int middle = sizeOfStack / 2;
        // Recursively remove the middle element
        solve(stack, middle);
    }

    // Helper function to remove the middle element using recursion
    private static void solve(Stack<Integer> stack, int middle) {
        // Base case: If we have reached the middle, remove the element and return
        if (middle == 0) {
            stack.pop();
            return;
        }

        // Remove the top element
        int top = stack.pop();
        // Recursively call solve to reach the middle
        solve(stack, middle - 1);
        // Push the top element back after the middle element is removed
        stack.push(top);
    }

    // Main method to test deleteMiddle function
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        // Example stack with 5 elements
        stack.push(1);
        stack.push(2);
        stack.push(3); // Middle element
        stack.push(4);
        stack.push(5);

        System.out.println("Original Stack: " + stack);
        deleteMiddle(stack, stack.size());
        System.out.println("Stack after deleting middle element: " + stack);
    }
}
