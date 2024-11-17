package sheet.google.practice.linked_list;

public class L03LinkedListCycle {
    public static void main(String[] args) {
        // Example to create a linked list with a cycle
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = second; // Create a cycle here

        // Check if the linked list has a cycle
        boolean result = hasCycle(head);
        System.out.println("Does the linked list have a cycle? " + result);
    }

    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode slow = head;       // Slow pointer moves one step at a time
        ListNode fast = head.next;  // Fast pointer moves two steps at a time

        while (fast != null && fast.next != null) {
            if (slow == fast) {    // If slow and fast meet, there's a cycle
                return true;
            }
            slow = slow.next;      // Move slow pointer by one
            fast = fast.next.next; // Move fast pointer by two
        }

        return false; // If fast reaches the end, there is no cycle
    }
}

