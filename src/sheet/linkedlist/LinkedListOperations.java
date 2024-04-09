package sheet.linkedlist;

public class LinkedListOperations {
    Node head;

    public static void main(String[] args) {
        LinkedListOperations list = new LinkedListOperations();
        list.append(1);
        list.append(2);
        list.append(3);
        System.out.println("Original list:");
        list.printList();

        list.delete(2);
        System.out.println("List after deleting 2:");
        list.printList();

        boolean found = list.search(3);
        System.out.println("Is 3 in the list? " + found);

        list.insertAfterValue(3, 4);
        System.out.println("List after inserting 3 after 2:");
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

    // Delete a node with the given data
    public void delete(int data) {
        if (head == null) {
            return;
        }
        if (head.data == data) {
            head = head.next;
            return;
        }
        Node current = head;
        while (current.next != null) {
            if (current.next.data == data) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    // Search for a node with the given data
    public boolean search(int data) {
        Node current = head;
        while (current != null) {
            if (current.data == data) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void insertAfterValue(int searchValue, int newData) {
        Node current = head;

        // Search for the node with the given value
        while (current != null && current.data != searchValue) {
            current = current.next;
        }

        // If the node is found, insert the new node after it
        if (current != null) {
            Node newNode = new Node(newData);
            newNode.next = current.next;
            current.next = newNode;
        } else {
            // If the node is not found, append the new node at the end
            append(newData);
        }
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