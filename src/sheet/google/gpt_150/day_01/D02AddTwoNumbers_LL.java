package sheet.google.gpt_150.day_01;


public class D02AddTwoNumbers_LL {

    public static void main(String[] args) {
        D02AddTwoNumbers_LL solution = new D02AddTwoNumbers_LL();

        // Test Case 1
        Node l1 = solution.createLinkedList(new int[]{2, 4, 3});
        Node l2 = solution.createLinkedList(new int[]{5, 6, 4});
        System.out.println("Test Case 1:");
        System.out.println("Expected Output: 7 -> 0 -> 8");
        System.out.print("Actual Output: ");
        printLinkedList(solution.addTwoNumbers(l1, l2));
        System.out.println();

        // Test Case 2 (One list is shorter)
        l1 = solution.createLinkedList(new int[]{9, 9});
        l2 = solution.createLinkedList(new int[]{1});
        System.out.println("Test Case 2:");
        System.out.println("Expected Output: 0 -> 0 -> 1");
        System.out.print("Actual Output: ");
        printLinkedList(solution.addTwoNumbers(l1, l2));
        System.out.println();

        // Test Case 3 (Both lists are null)
        l1 = solution.createLinkedList(new int[]{0});
        l2 = solution.createLinkedList(new int[]{0});
        System.out.println("Test Case 3:");
        System.out.println("Expected Output: 0");
        System.out.print("Actual Output: ");
        printLinkedList(solution.addTwoNumbers(l1, l2));
        System.out.println();
    }

    // Helper function to print the linked list
    private static void printLinkedList(Node head) {
        while (head != null) {
            System.out.print(head.value);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }

    // Helper function to create a linked list from an array
    private Node createLinkedList(int[] values) {
        Node dummy = new Node(0, null);
        Node current = dummy;
        for (int value : values) {
            current.next = new Node(value, null);
            current = current.next;
        }
        return dummy.next;
    }

    public Node addTwoNumbers(Node l1, Node l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        int carry = 0;
        Node dummy = new Node(0, null);
        Node current = dummy;

        // Traverse both lists
        while (l1 != null || l2 != null) {
            int val1 = (l1 != null) ? l1.value : 0;
            int val2 = (l2 != null) ? l2.value : 0;
            int sum = val1 + val2 + carry;

            carry = sum / 10;
            current.next = new Node(sum % 10, null);
            current = current.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        // Check if there is a remaining carry
        if (carry > 0) {
            current.next = new Node(carry, null);
        }

        return dummy.next;
    }

    class Node {
        int value;
        Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
