package sheet.linkedlist.problems;

public class P08CheckIfLLIsPalindrome {
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        // Step 1: Find the middle
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half
        ListNode secondHalf = reverse(slow.next);

        // Step 3: Compare the two halves
        ListNode p1 = head;
        ListNode p2 = secondHalf;
        boolean isPalindrome = true;
        while (p2 != null) {
            if (p1.val != p2.val) {
                isPalindrome = false;
                break;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        // Optional: Restore the list (reverse the second half again)
        slow.next = reverse(secondHalf);

        return isPalindrome;
    }

    private static ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    // Method to print the linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            if (head.next != null) System.out.print("-> ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        System.out.println("Original list:");
        printList(head);

        boolean result = isPalindrome(head);
        System.out.println("Is palindrome: " + result);

        System.out.println("Restored list:");
        printList(head);
    }
}
