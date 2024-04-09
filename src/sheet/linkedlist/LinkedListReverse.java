package sheet.linkedlist;


public class LinkedListReverse {
    Node head;

    public static void main(String[] args) {
        LinkedListReverse list = new LinkedListReverse();
        list.append(1);
        list.append(2);
        list.append(3);
        System.out.println("Original list:");
        list.printList();

        list.reverse();
        System.out.println("Reversed list:");
        list.printList();

        list.reverseR();
        System.out.println("Reversed list:");
        list.printList();
    }

    // Insert a new node at the end of the list
    public void append(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    // Reverse the linked list
    public void reverse() {
        Node prev = null;
        Node current = head;
        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    public Node reverseRecursive(Node node) {
        if (node == null || node.next == null) {
            return node;
        }
        Node newHead = reverseRecursive(node.next);
        node.next.next = node;
        node.next = null;
        return newHead;
    }

    public void reverseR() {
        head = reverseRecursive(head);
    }

    // Print the linked list
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

