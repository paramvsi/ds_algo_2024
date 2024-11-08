package sheet.google.gpt_150.day_01;
/*
Given the head of a singly linked list, reorder the list to follow a specific pattern:

Given a list L0 → L1 → … → Ln-1 → Ln, reorder it to L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → …
You must do this in-place without altering the node values and using
*/


class ListNode {
    int val;
    ListNode2 next;

    ListNode(int x) {
        val = x;
    }
}

public class D21ReorderList {
    public static void main(String[] args) {
        ListNode2 head = new ListNode2(1);
        head.next = new ListNode2(2);
        head.next.next = new ListNode2(3);
        head.next.next.next = new ListNode2(4);
        head.next.next.next.next = new ListNode2(5);

        new D21ReorderList().reorderList(head);

        ListNode2 current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        // Output: 1 5 2 4 3
    }

    public void reorderList(ListNode2 head) {
        if (head == null || head.next == null) {
            return;
        }

        // Step 1: Find the middle of the linked list
        ListNode2 slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half of the list
        ListNode2 secondHalf = reverseList(slow.next);
        slow.next = null; // Split the list into two halves

        // Step 3: Merge the two halves
        ListNode2 firstHalf = head;
        while (secondHalf != null) {
            ListNode2 temp1 = firstHalf.next;
            ListNode2 temp2 = secondHalf.next;

            firstHalf.next = secondHalf;
            secondHalf.next = temp1;

            firstHalf = temp1;
            secondHalf = temp2;
        }
    }

    private ListNode2 reverseList(ListNode2 head) {
        ListNode2 prev = null, curr = head;
        while (curr != null) {
            ListNode2 nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }
}

