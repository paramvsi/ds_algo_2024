package sheet.stack_and_queue;

import java.util.Stack;

public class P06SupportGetMInInConstantTimeAndSpace {
    private final Stack<Long> stack;
    private long min;

    public P06SupportGetMInInConstantTimeAndSpace() {
        stack = new Stack<>();
        min = 0;
    }

    public static void main(String[] args) {
        P06SupportGetMInInConstantTimeAndSpace minStack = new P06SupportGetMInInConstantTimeAndSpace();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println("Current Minimum: " + minStack.getMin());   // Returns -3
        minStack.pop();
        System.out.println("Top element: " + minStack.top());          // Returns 0
        System.out.println("Current Minimum: " + minStack.getMin());   // Returns -2
    }

    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(0L);
            min = x;
        } else {
            // Calculate the difference and adjust min if necessary
            stack.push((long) x - min);
            if (x < min) {
                min = x;
            }
        }
    }

    public void pop() {
        if (stack.isEmpty()) {
            return;
        }

        long pop = stack.pop();

        // If pop is negative, the min needs to be adjusted
        if (pop < 0) {
            min = min - pop; // Adjusting the previous min
        }
    }

    public int top() {
        long top = stack.peek();
        if (top > 0) {
            return (int) (top + min);
        } else {
            return (int) (min);
        }
    }

    public int getMin() {
        return (int) min;
    }
}

