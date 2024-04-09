package sheet.linkedlist;

public class FindMiddleInALinkedList {
    Node head;

    public static void main(String[] args) {
        FindMiddleInALinkedList list = new FindMiddleInALinkedList();
        list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(5);

        Node middle = list.findMiddle();
        if (middle != null) {
            System.out.println("The middle element is: " + middle.data);
        } else {
            System.out.println("The list is empty.");
        }
    }

    // Method to find the middle of the linked list
    public Node findMiddle() {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;          // Move slow pointer one step
            fast = fast.next.next;     // Move fast pointer two steps
        }

        // When the fast pointer reaches the end, the slow pointer will be at the middle
        return slow;
    }
}
