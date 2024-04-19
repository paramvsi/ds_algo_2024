package sheet.stack_and_queue;


import java.util.Stack;

public class P10ReverseStackUsingRecursion {

    // Utility function to insert an element at the bottom of a stack
    private static void insertAtBottom(Stack<Integer> stack, int item) {
        if (stack.isEmpty()) {
            stack.push(item);
        } else {
            // Hold all items in Function Call Stack until we reach end of the stack
            int top = stack.pop();
            insertAtBottom(stack, item);

            // Once the item is inserted at the bottom, push all the items held in Function Call Stack
            stack.push(top);
        }
    }

    // Function to reverse the stack using recursion
    public static void reverse(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            // Hold all items in Function Call Stack until we reach end of the stack
            int item = stack.pop();
            reverse(stack);

            // Insert all the items (held in Function Call Stack) one by one from the bottom to top. Every item is inserted at the bottom
            insertAtBottom(stack, item);
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println("Original Stack: " + stack);
        reverse(stack);
        System.out.println("Reversed Stack: " + stack);
    }
}


