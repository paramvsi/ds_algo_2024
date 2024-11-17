package sheet.google.practice.linked_list;


public class L02RemoveNthNodeFromLast {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;  // If the list is empty, return null.

        ListNode dummy = new ListNode(0); // Create a dummy node to simplify edge cases
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;

        // Move fast ahead by n+1 positions to ensure slow ends up at the node before the one to be removed
        for (int i = 0; i <= n; i++) {
            assert fast != null;
            fast = fast.next;
            if (fast == null && i != n) return head; // If n is greater than the number of nodes, return head
        }

        // Move both pointers until fast reaches the end of the list
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // Remove the nth node from the end
        slow.next = slow.next.next;

        return dummy.next; // Return the head of the modified list, which might not be the original head
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        head = removeNthFromEnd(head, 2);
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }
}

