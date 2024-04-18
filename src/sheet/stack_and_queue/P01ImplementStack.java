package sheet.stack_and_queue;

public class P01ImplementStack {
    public static void main(String[] args) {
        Stack stack = new Stack(3);

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("The top element is " + stack.peek());
        stack.pop();
        System.out.println("The top element is " + stack.peek());

        stack.pop();
        stack.pop();

        if (stack.isEmpty()) {
            System.out.println("The stack is empty");
        } else {
            System.out.println("The stack is not empty");
        }
    }

    // Main class to test the stack implementation

    public static class Stack {
        private final int[] arr;
        private int top;
        private final int capacity;

        // Constructor to initialize the stack
        public Stack(int size) {
            arr = new int[size];
            capacity = size;
            top = -1;
        }

        // Add an element to the top of the stack
        public void push(int x) {
            if (isFull()) {
                System.out.println("Stack OverFlow");
                System.exit(1);
            }
            System.out.println("Inserting " + x);
            arr[++top] = x;
        }

        // Remove the top element from the stack
        public int pop() {
            if (isEmpty()) {
                System.out.println("STACK EMPTY");
                System.exit(1);
            }
            return arr[top--];
        }

        // Return the top element of the stack
        public int peek() {
            if (!isEmpty()) {
                return arr[top];
            } else {
                System.exit(1);
            }
            return -1;
        }

        // Return the size of the stack
        public int size() {
            return top + 1;
        }

        // Check if the stack is empty
        public Boolean isEmpty() {
            return top == -1;
        }

        // Check if the stack is full
        public Boolean isFull() {
            return top == capacity - 1;
        }
    }
}
