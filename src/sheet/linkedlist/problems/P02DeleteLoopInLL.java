package sheet.linkedlist.problems;

public class P02DeleteLoopInLL {
    public static void removeLoop(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode slow = head, fast = head;

        // Detect Loop
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                // Loop detected, now find the start of the loop
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }

                // Now move fast to the node before the start of the loop
                while (fast.next != slow) {
                    fast = fast.next;
                }

                // Remove the loop
                fast.next = null;
                return;
            }
        }
    }

    // Method to print the linked list
    public static void printList(ListNode head) {
        int count = 0; // To prevent infinite loop if there's a loop in the list
        while (head != null && count < 10) {
            System.out.print(head.val + " ->  ");
            head = head.next;
            count++;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // Creating a loop for demonstration
        head.next.next.next.next.next = head.next;

        System.out.println("List before removing the loop:");

        printList(head);

        // Remove the loop
        removeLoop(head);

        // Print the list after removing the loop
        System.out.println("List after removing the loop:");
        printList(head);
    }
}
