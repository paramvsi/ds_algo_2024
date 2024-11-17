package sheet.google.practice.linked_list;

public class L01ReverseLinkedList {
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode nextTemp = current.next; // Store next node
            current.next = prev; // Reverse the current node's pointer
            prev = current; // Move pointers one position ahead.
            current = nextTemp;
        }
        return prev; // prev is the new head of the reversed list
    }
    public static void main(String[] args) {
        // Example to use in main method
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode reversed = reverseList(head);
        System.out.print("Reversed List: ");
        while (reversed != null) {
            System.out.print(reversed.val + " ");
            reversed = reversed.next;
        }
    }
}

