package sheet.linkedlist.problems;



public class P09ReverseDLL {


    public static DListNode reverse(DListNode head) {
        DListNode temp = null;
        DListNode current = head;

        // Swap next and prev for all nodes of the list
        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev; // Move to the next node which is now in prev due to swap
        }

        // Before changing the head, check for the cases like empty list and single node list
        if (temp != null) {
            head = temp.prev;
        }

        return head;
    }

    // Method to print the list from head to tail
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

        System.out.println("Original Doubly Linked List:");
        printList(head);

        head = reverse(head);

        System.out.println("Reversed Doubly Linked List:");
        printList(head);
    }
}
