package sheet.linkedlist.problems;

public class P06AddOneToLL {
    public static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode next;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public static ListNode addOne(ListNode head) {
        // Reverse the linked list
        head = reverse(head);

        ListNode current = head;
        int carry = 1; // Start with adding 1

        // Traverse the reversed list and add one
        while (current != null && carry > 0) {
            int sum = current.val + carry;
            carry = sum / 10; // Update carry for next iteration
            current.val = sum % 10; // Update the current node's value

            // Move to the next node
            if (current.next == null) {
                break;
            }
            current = current.next;
        }

        // If carry is still left after the last node
        if (carry > 0) {
            assert current != null;
            current.next = new ListNode(carry);
        }

        // Reverse the list again to restore the original order
        return reverse(head);
    }

    // Method to print the linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(9);
        head.next = new ListNode(9);
        head.next.next = new ListNode(9);

        System.out.println("Original list:");
        printList(head);

        head = addOne(head);

        System.out.println("List after adding one:");
        printList(head);
    }
}
