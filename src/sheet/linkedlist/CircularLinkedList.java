package sheet.linkedlist;

public class CircularLinkedList {
    Node head;

    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();
        list.append(1);
        list.append(2);
        list.append(3);
        list.printList();
    }

    // Add a new node at the end of the list
    public void append(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            newNode.next = head; // Pointing back to the head to form a circle
            return;
        }
        Node current = head;
        // Traverse the list to find the last node
        while (current.next != head) {
            current = current.next;
        }
        // Insert the new node and update the next pointers
        current.next = newNode;
        newNode.next = head;
    }

    // Print the circular linked list
    public void printList() {
        if (head == null) {
            return;
        }
        Node current = head;
        do {
            System.out.print(current.data + " -> ");
            current = current.next;
        } while (current != head);
        System.out.println("(head)");
    }
}

