package sheet.stack_and_queue;


import java.util.Stack;

public class P11SortStackUsingRecursion {

    // Recursive method to insert an element in sorted way
    private static void sortedInsert(Stack<Integer> stack, int element) {
        if (stack.isEmpty() || element > stack.peek()) {
            stack.push(element);
        } else {
            // Remove all elements smaller than the element to be inserted
            int temp = stack.pop();
            sortedInsert(stack, element);

            // Place the popped item back on the stack
            stack.push(temp);
        }
    }

    // Function to sort stack
    public static void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            // Remove the top element
            int x = stack.pop();

            // Sort the remaining stack recursively
            sortStack(stack);

            // Insert the top item removed earlier into the sorted stack
            sortedInsert(stack, x);
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(30);
        stack.push(-5);
        stack.push(18);
        stack.push(14);
        stack.push(-3);

        System.out.println("Stack elements before sorting: " + stack);
        sortStack(stack);
        System.out.println("Stack elements after sorting: " + stack);
    }
}

