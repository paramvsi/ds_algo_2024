package sheet.google.stack;

import java.util.Stack;

class S05MinStackWithExtraSpace {
    private final Stack<Integer> stack;      // Main stack to store all elements
    private final Stack<Integer> minStack;   // Stack to store minimum elements

    // Initialize the stacks
    public S05MinStackWithExtraSpace() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public static void main(String[] args) {
        S05MinStackWithExtraSpace minStack = new S05MinStackWithExtraSpace();

        // Helper function to test and display operations
        testMinStack(minStack);
    }

    public static void testMinStack(S05MinStackWithExtraSpace minStack) {
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
        stack.push(x);

        // If minStack is empty or the new value is <= the current min, push it to minStack
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    // Pop a value from the stack
    public void pop() {
        if (stack.isEmpty()) {
            return;
        }

        int top = stack.pop();

        // If the popped value is the current minimum, pop it from minStack as well
        if (top == minStack.peek()) {
            minStack.pop();
        }
    }

    // Get the top value from the stack
    public int top() {
        return stack.peek();
    }

    // Get the minimum value in the stack
    public int getMin() {
        return minStack.peek();
    }
}


