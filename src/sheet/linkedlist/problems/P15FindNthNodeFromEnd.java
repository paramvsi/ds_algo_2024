package sheet.linkedlist.problems;

public class P15FindNthNodeFromEnd {
    public static ListNode findNthFromEnd(ListNode head, int n) {
        if (head == null || n <= 0) {
            return null;  // Invalid input case
        }

        ListNode mainPtr = head;
        ListNode refPtr = head;

        // Move refPtr n nodes ahead
        int count = 0;
        while (count < n) {
            if (refPtr == null) {
                return null;  // n is greater than the number of nodes in the list
            }
            refPtr = refPtr.next;
            count++;
        }

        // Move both pointers at the same speed
        while (refPtr != null) {
            mainPtr = mainPtr.next;
            refPtr = refPtr.next;
        }

        return mainPtr;
    }

    // Method to print the node value
    public static void printNode(ListNode node) {
        if (node != null) {
            System.out.println("The node is: " + node.val);
        } else {
            System.out.println("No such node exists.");
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int n = 2;  // Example: Find the 2nd node from the end
        ListNode nthNode = findNthFromEnd(head, n);

        System.out.println("Nth node from the end where N is " + n + ":");
        printNode(nthNode);
    }
}
