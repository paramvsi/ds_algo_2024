package sheet.linkedlist.problems;

public class P14SegregateEvenOddNodes {
    public static ListNode segregateEvenOdd(ListNode head) {
        if (head == null) return null;

        // Pointers for even and odd lists
        ListNode evenStart = null;
        ListNode evenEnd = null;
        ListNode oddStart = null;
        ListNode oddEnd = null;

        // Current node for iteration
        ListNode current = head;

        while (current != null) {
            int element = current.val;

            if (element % 2 == 0) {  // Check if even
                if (evenStart == null) {
                    evenStart = current;
                    evenEnd = evenStart;
                } else {
                    evenEnd.next = current;
                    evenEnd = evenEnd.next;
                }
            } else {  // Check if odd
                if (oddStart == null) {
                    oddStart = current;
                    oddEnd = oddStart;
                } else {
                    oddEnd.next = current;
                    oddEnd = oddEnd.next;
                }
            }
            current = current.next;
        }

        // End the lists properly to avoid cycles
        if (evenEnd != null) {
            evenEnd.next = oddStart; // Connect even list to the start of the odd list
        }
        if (oddEnd != null) {
            oddEnd.next = null; // End the odd list
        }

        return evenStart != null ? evenStart : oddStart; // Return even list head if not empty, else odd list head
    }

    // Method to print the linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(17);
        head.next = new ListNode(15);
        head.next.next = new ListNode(8);
        head.next.next.next = new ListNode(12);
        head.next.next.next.next = new ListNode(10);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(4);

        System.out.println("Original list:");
        printList(head);

        head = segregateEvenOdd(head);

        System.out.println("List after segregating even and odd nodes:");
        printList(head);
    }
}
