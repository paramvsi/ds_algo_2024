package sheet.linkedlist.problems;

public class P07AddTwoNumbersRepAsLL {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);  // Dummy node to simplify edge cases
        ListNode current = dummyHead;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;  // Start with the carry from the last iteration

            if (l1 != null) {
                sum += l1.val;  // Add value from l1
                l1 = l1.next;   // Move to the next node in l1
            }

            if (l2 != null) {
                sum += l2.val;  // Add value from l2
                l2 = l2.next;   // Move to the next node in l2
            }

            carry = sum / 10;  // Update carry for next position
            ListNode newNode = new ListNode(sum % 10);  // Create new node with the single digit
            current.next = newNode;  // Link new node to the list
            current = newNode;  // Move current pointer to new node
        }

        return dummyHead.next;  // The head of the resultant list is next to the dummy node
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
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        System.out.println("List 1:");
        printList(l1);
        System.out.println("List 2:");
        printList(l2);

        ListNode result = addTwoNumbers(l1, l2);

        System.out.println("Resultant List:");
        printList(result);
    }
}
