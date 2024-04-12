package sheet.linkedlist.problems;

public class P05RotateLLByOne {
    public static ListNode moveLastToFront(ListNode head) {
        if (head == null || head.next == null) {
            return head; // No need to move if the list is empty or has only one element
        }

        ListNode secondLast = null;
        ListNode last = head;

        // Finding the second last and last node
        while (last.next != null) {
            secondLast = last;
            last = last.next;
        }

        // Change the next of second last
        secondLast.next = null;

        // Move last to front
        last.next = head;
        return last;
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

        System.out.println("Original list:");
        printList(head);

        head = moveLastToFront(head);

        System.out.println("List after moving last to front:");
        printList(head);
    }
}
