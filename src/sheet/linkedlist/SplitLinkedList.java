package sheet.linkedlist;

public class SplitLinkedList {
    public static void splitList(Node head, Node[] lists) {
        if (head == null) {
            return;
        }

        Node odd = head;
        Node even = head.next;

        lists[0] = odd;
        lists[1] = even;

        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }

        if (odd != null) {
            odd.next = null;
        }
    }

    public static void main(String[] args) {
        // Create a sample linked list
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        // Array to hold the two lists after splitting
        Node[] lists = new Node[2];

        // Split the list
        splitList(head, lists);

        // Print the two lists
        System.out.println("First List:");
        lists[0].printList();

        System.out.println("Second List:");
        if (lists[1] != null) {
            lists[1].printList();
        } else {
            System.out.println("null");
        }
    }
}

