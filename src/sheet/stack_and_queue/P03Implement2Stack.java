package sheet.stack_and_queue;

public class P03Implement2Stack {
    public static void main(String[] args) {
        TwoStacks ts = new TwoStacks(10);
        ts.push1(5);
        ts.push2(10);
        ts.push2(15);
        ts.push1(11);
        ts.push2(7);
        System.out.println("Popped element from stack1 is: " + ts.pop1());
        ts.push2(40);
        System.out.println("Popped element from stack2 is: " + ts.pop2());
    }

    // Main class to test the two stacks

    public static class TwoStacks {
        int[] arr;
        int size;
        int top1, top2;

        // Constructor to initialize the two stacks
        public TwoStacks(int n) {
            size = n;
            arr = new int[n];
            top1 = -1;
            top2 = size;
        }

        // Method to push an element x to the first stack
        public void push1(int x) {
            if (top1 < top2 - 1) {
                arr[++top1] = x;
            } else {
                System.out.println("Stack Overflow");
                System.exit(1);
            }
        }

        // Method to push an element x to the second stack
        public void push2(int x) {
            if (top1 < top2 - 1) {
                arr[--top2] = x;
            } else {
                System.out.println("Stack Overflow");
                System.exit(1);
            }
        }

        // Method to pop an element from the first stack
        public int pop1() {
            if (top1 >= 0) {
                return arr[top1--];
            } else {
                System.out.println("Stack Underflow");
                System.exit(1);
            }
            return 0;
        }

        // Method to pop an element from the second stack
        public int pop2() {
            if (top2 < size) {
                return arr[top2++];
            } else {
                System.out.println("Stack Underflow");
                System.exit(1);
            }
            return 0;
        }
    }
}
