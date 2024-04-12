package sheet.linkedlist.problems;

public class Problem01ReverseLLInGroupOfGivenSize {
    public static ListNode reverseInGroups(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy, curr = head, next;
        int count = 0;

        // Count the number of nodes in the linked list
        while (curr != null) {
            count++;
            curr = curr.next;
        }

        // Iterate through the list and reverse each group
        curr = head;
        while (count >= k) {
            for (int i = 1; i < k; i++) {
                next = curr.next;
                curr.next = next.next;
                next.next = prev.next;
                prev.next = next;
            }
            prev = curr;
            curr = prev.next;
            count -= k;
        }

        return dummy.next;
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
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original list:");
        printList(head);

        ListNode reversed = reverseInGroups(head, 2);
        System.out.println("Reversed list in groups of 2:");
        printList(reversed);
    }
}
