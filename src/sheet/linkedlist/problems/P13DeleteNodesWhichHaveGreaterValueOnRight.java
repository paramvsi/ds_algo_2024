package sheet.linkedlist.problems;

/*

To solve the problem of deleting nodes from a singly linked list that have a greater value on the right side,
you can utilize a reverse traversal approach. By traversing the list from the end to the beginning
(which involves reversing the list first), you can keep track of the maximum value found so far,
and delete nodes that do not meet the criteria of having a greater or equal value compared to this maximum.

*/
public class P13DeleteNodesWhichHaveGreaterValueOnRight {
    private static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    // Method to delete nodes that have a greater value on the right
    public static ListNode deleteNodes(ListNode head) {
        // Reverse the list to traverse from right to left
        head = reverse(head);

        ListNode maxNode = head;
        ListNode current = head;

        while (current != null && current.next != null) {
            if (current.next.val < maxNode.val) {
                // Delete the current.next node
                current.next = current.next.next;
            } else {
                // Move the maxNode pointer to current.next
                current = current.next;
                maxNode = current;
            }
        }

        // Reverse the list again to restore original order
        return reverse(head);
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
        ListNode head = new ListNode(12);
        head.next = new ListNode(15);
        head.next.next = new ListNode(10);
        head.next.next.next = new ListNode(11);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next.next = new ListNode(3);

        System.out.println("Original list:");
        printList(head);

        head = deleteNodes(head);

        System.out.println("Modified list:");
        printList(head);
    }
}
