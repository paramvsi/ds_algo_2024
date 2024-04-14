package sheet.linkedlist.problems;

public class P12RotateDLLInGroupOfK {
    private static DListNode rotateGroup(DListNode start, int k) {
        DListNode current = start;
        DListNode prev = null;
        DListNode next = null;
        int count = 0;

        // Perform rotation within the group if enough nodes are available
        while (current != null && count < k) {
            next = current.next;
            current.next = prev;
            current.prev = next;
            prev = current;
            current = next;
            count++;
        }

        // Set the correct next for the original start node (which becomes the end)
        if (next != null) {
            start.next = next;
            next.prev = start;
        }

        // Return the new start of this group
        return prev;
    }

    public static DListNode rotateByGroups(DListNode head, int k) {
        if (head == null || k == 1) {
            return head;  // No need to rotate if the list is empty or k is 1
        }

        DListNode current = head;
        DListNode newHead = null;
        DListNode lastTail = null;

        // Process each group
        while (current != null) {
            DListNode groupHead = current;
            DListNode newGroupHead = rotateGroup(groupHead, k);

            if (newHead == null) {
                newHead = newGroupHead;
            }

            if (lastTail != null) {
                lastTail.next = newGroupHead;
                newGroupHead.prev = lastTail;
            }

            // Move the current pointer to the start of the next group
            lastTail = groupHead;
            current = groupHead.next;
        }

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

        head = rotateByGroups(head, 2);  // Rotate groups of size 2

        System.out.println("List after rotating in groups:");
        printList(head);
    }
}
