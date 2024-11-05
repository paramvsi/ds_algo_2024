package sheet.google.stack;

import java.util.Stack;

public class S06MinStackWithConstantSpace {
    private final Stack<Integer> stack;      // Main stack to store all elements
    private int minElement;

    // Initialize the stack
    public S06MinStackWithConstantSpace() {
        stack = new Stack<>();
    }

    public static void main(String[] args) {
        S06MinStackWithConstantSpace minStack = new S06MinStackWithConstantSpace();

        // Helper function to test and display operations
        testMinStack(minStack);
    }

    public static void testMinStack(S06MinStackWithConstantSpace minStack) {
        System.out.println("Testing MinStack Operations:");

        // Test push operations
        minStack.push(5);
        System.out.println("Pushed 5 -> Min: " + minStack.getMin()); // Min should be 5

        minStack.push(3);
        System.out.println("Pushed 3 -> Min: " + minStack.getMin()); // Min should be 3

        minStack.push(7);
        System.out.println("Pushed 7 -> Min: " + minStack.getMin()); // Min should still be 3

        minStack.push(2);
        System.out.println("Pushed 2 -> Min: " + minStack.getMin()); // Min should be 2

        // Test top operation
        System.out.println("Top element: " + minStack.top()); // Top should be 2

        // Test pop operation and min
        minStack.pop();
        System.out.println("Popped -> Min: " + minStack.getMin()); // Min should return to 3

        minStack.pop();
        System.out.println("Popped -> Min: " + minStack.getMin()); // Min should still be 3

        // Test push operation to check minimum tracking
        minStack.push(1);
        System.out.println("Pushed 1 -> Min: " + minStack.getMin()); // Min should be 1

        // Final top and minimum
        System.out.println("Top element: " + minStack.top());       // Top should be 1
        System.out.println("Current Min: " + minStack.getMin());     // Min should be 1
    }

    // Push a value onto the stack
    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(x);
            minElement = x;
        } else {
            // Push a modified value if x is the new minimum
            if (x < minElement) {
                stack.push(2 * x - minElement);
                minElement = x;
            } else {
                stack.push(x);
            }
        }
    }

    // Pop a value from the stack
    public void pop() {
        if (stack.isEmpty()) {
            return;
        }

        int top = stack.pop();

        // If top is less than minElement, it means minElement is stored in encoded form
        if (top < minElement) {
            minElement = 2 * minElement - top;
        }
    }

    // Get the top value from the stack
    public int top() {
        if (stack.isEmpty()) return -1;
        if (stack.peek() < minElement) {
            return minElement;
        } else {
            return stack.peek();
        }
    }

    // Get the minimum value in the stack
    public int getMin() {
        return minElement;
    }
}
