package sheet.linkedlist.problems;

import java.util.HashSet;

public class Problem04RemoveDuplicatesInUnsortedLL {
    public static void removeDuplicates(ListNode head) {
        HashSet<Integer> seen = new HashSet<>();
        ListNode current = head;
        ListNode prev = null;

        while (current != null) {
            if (seen.contains(current.val)) {
                // Duplicate found, remove it
                prev.next = current.next;
            } else {
                // Add value to the HashSet and move the prev pointer
                seen.add(current.val);
                prev = current;
            }
            current = current.next;
        }
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(2);

        System.out.println("Original list:");
        printList(head);

        removeDuplicates(head);

        System.out.println("List after removing duplicates:");
        printList(head);
    }
}
