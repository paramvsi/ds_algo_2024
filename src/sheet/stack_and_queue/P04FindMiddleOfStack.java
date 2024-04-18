package sheet.stack_and_queue;

public class P04FindMiddleOfStack {
    public static void main(String[] args) {
        StackWithMiddle sm = new StackWithMiddle();
        sm.push(1);
        sm.push(2);
        sm.push(3);
        sm.push(4);
        sm.push(5);

        System.out.println("Middle Element: " + sm.findMiddle());
        sm.pop();
        System.out.println("Middle Element after one pop: " + sm.findMiddle());
        sm.deleteMiddle();
        System.out.println("Middle Element after deleting middle: " + sm.findMiddle());
    }

    static class DLLNode {
        int data;
        DLLNode prev;
        DLLNode next;

        DLLNode(int d) {
            data = d;
        }
    }

    static class StackWithMiddle {
        DLLNode head;
        DLLNode mid;
        int count;

        // Constructor
        public StackWithMiddle() {
            head = null;
            mid = null;
            count = 0;
        }

        // Function to push an element to the stack
        public void push(int data) {
            DLLNode newNode = new DLLNode(data);
            newNode.prev = null;
            newNode.next = head;
            count += 1;

            // Change mid pointer in two cases:
            // 1. Linked List is empty
            // 2. Number of nodes in linked list is odd
            if (count == 1) {
                mid = newNode;
            } else {
                head.prev = newNode;
                if (count % 2 != 0) { // Update mid if count is odd
                    mid = mid.prev;
                }
            }

            // Move head to point to the new DLLNode
            head = newNode;
        }

        // Function to pop an element from stack
        public int pop() {
            if (count == 0) {
                System.out.println("Stack is empty");
                return -1;
            }
            DLLNode headNode = head;
            int item = headNode.data;
            head = headNode.next;

            // If linked list doesn't become empty, update prev of new head as NULL
            if (head != null)
                head.prev = null;

            count -= 1;

            // Update the mid pointer when we have even number of elements in the stack, i.e., move down the mid pointer.
            if (count % 2 == 0)
                mid = mid.next;

            return item;
        }

        // Function to find middle element of stack
        public int findMiddle() {
            if (count == 0) {
                System.out.println("Stack is empty");
                return -1;
            }
            return mid.data;
        }

        // Function to delete middle element of stack
        public void deleteMiddle() {
            if (count == 0) {
                System.out.println("Stack is empty");
                return;
            }

            // If there's only one element, delete it
            if (count == 1) {
                head = null;
                mid = null;
            } else {
                // More than one element, link the neighbors
                DLLNode midPrev = mid.prev;
                DLLNode midNext = mid.next;

                if (midPrev != null)
                    midPrev.next = midNext;
                if (midNext != null)
                    midNext.prev = midPrev;

                // Move mid to the next element
                if (count % 2 == 0) // Even number of elements
                    mid = midNext;
                else // Odd number of elements
                    mid = midPrev;
            }
            count--;
        }
    }
}
