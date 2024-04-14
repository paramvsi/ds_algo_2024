package sheet.linkedlist.problems;

public class P11RotateDLLByNNodes {
    public static DListNode rotate(DListNode head, int n) {
        if (head == null || head.next == null || n == 0) {
            return head;  // No rotation needed if the list is empty or has one element or n is 0
        }

        // First, find the length and the last node of the list
        int length = 0;
        DListNode last = head;
        while (last.next != null) {
            last = last.next;
            length++;
        }
        length++;  // Include last node in count

        // Find the effective number of rotations needed
        n = n % length;
        if (n == 0) {
            return head;  // No rotation needed if n is 0 after mod
        }
        if (n < 0) {
            n = n + length;  // Convert negative rotation to positive
        }

        // Find the new last node (length-n th node)
        int splitPoint = length - n;
        DListNode newLast = head;
        for (int i = 1; i < splitPoint; i++) {
            newLast = newLast.next;
        }

        // Set new head
        DListNode newHead = newLast.next;

        // Break and join the list
        newLast.next = null;
        newHead.prev = null;
        last.next = head;
        head.prev = last;

        return newHead;
    }

    // Method to print the list from given node
    public static void printList(DListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DListNode head = new DListNode(1);
        head.next = new DListNode(2);
        head.next.prev = head;
        head.next.next = new DListNode(3);
        head.next.next.prev = head.next;
        head.next.next.next = new DListNode(4);
        head.next.next.next.prev = head.next.next;
        head.next.next.next.next = new DListNode(5);
        head.next.next.next.next.prev = head.next.next.next;

        System.out.println("Original list:");
        printList(head);

        head = rotate(head, 2);  // Rotate by 2 nodes

        System.out.println("Rotated list:");
        printList(head);
    }
}
