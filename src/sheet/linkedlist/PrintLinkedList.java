package sheet.linkedlist;

// How to create a linked list
public class PrintLinkedList {
    Node head;

    public void append(int data) {
        if (head == null) {
            head = new Node(data);
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node(data);
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        PrintLinkedList list = new PrintLinkedList();
        list.append(1);
        list.append(2);
        list.append(3);
        list.printList();
    }
}
