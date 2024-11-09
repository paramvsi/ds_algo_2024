package sheet.google.gpt_150.day_02;


public class D35RemoveNthNodeFromEndOfList {

    public static void main(String[] args) {
        D35RemoveNthNodeFromEndOfList solution = new D35RemoveNthNodeFromEndOfList();

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode modifiedHead = solution.removeNthFromEnd(head, 2);
        while (modifiedHead != null) {
            System.out.print(modifiedHead.val + " ");
            modifiedHead = modifiedHead.next;
        }
        // Output: 1 2 3 5
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;

        // Move `first` pointer `n + 1` steps ahead
        for (int i = 0; i < n + 1; i++) {
            first = first.next;
        }

        // Move `first` to the end, maintaining the gap
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        // `second` now points to the node before the one to be removed
        second.next = second.next.next;

        return dummy.next;
    }
}

