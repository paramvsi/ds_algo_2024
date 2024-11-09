package sheet.google.gpt_150.day_02;


class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class D14OddEvenLL {
    public static void main(String[] args) {
        // Test case
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        D14OddEvenLL solution = new D14OddEvenLL();
        ListNode result = solution.oddEvenList(head);

        // Print result
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
        // Expected output: 1 3 5 2 4
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;

        // Initialize odd and even pointers
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        // Traverse and rearrange the list
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }

        // Attach even nodes after odd nodes
        odd.next = evenHead;

        return head;
    }
}

