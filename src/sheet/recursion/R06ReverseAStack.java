package sheet.recursion;


import java.util.Stack;

public class R06ReverseAStack {
    // Function to reverse the stack
    public static void reverse(Stack<Integer> stack) {

        if (stack.size() == 1) {
            return;
        }

        int item = stack.pop();
        reverse(stack);

        // Insert the items back in reverse order
        insertAtBottom(stack, item);
    }

    // Function to insert an element at the bottom of the stack
    private static void insertAtBottom(Stack<Integer> stack, int item) {
        if (stack.isEmpty()) {
            stack.push(item);
        } else {
            int top = stack.pop();
            insertAtBottom(stack, item);
            stack.push(top);
        }
    }

    // Main method to test the reverse function
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println("Original Stack: " + stack);
        reverse(stack);
        System.out.println("Reversed Stack: " + stack);
    }
}

