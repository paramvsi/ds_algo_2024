package sheet.recursion;

import java.util.Stack;

public class R04SortAStack {
    // Method to sort the stack
    public static void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            // Remove the top element
            int top = stack.pop();

            // Sort the remaining stack
            sortStack(stack);

            // Insert the top element back in sorted order
            sortedInsert(stack, top);
        }
    }

    // Method to insert elements into the stack in sorted order
    private static void sortedInsert(Stack<Integer> stack, int element) {
        // If stack is empty or the element to be inserted is greater than the top element
        if (stack.isEmpty() || element > stack.peek()) {
            stack.push(element);
        } else {
            // Remove the top element
            int top = stack.pop();

            // Recursively call to insert the element
            sortedInsert(stack, element);

            // Insert the top element back
            stack.push(top);
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(34);
        stack.push(3);
        stack.push(31);
        stack.push(98);
        stack.push(92);
        stack.push(23);

        System.out.println("Original Stack: " + stack);
        sortStack(stack);
        System.out.println("Sorted Stack: " + stack);
    }
}

