package sheet.linkedlist;


public class MergeTwoLinkedList {
    public static Node mergeTwoLists(Node l1, Node l2) {
        // Create a dummy node to start the merged list
        Node dummy = new Node(0);
        Node current = dummy;

        // Iterate through both lists
        while (l1 != null && l2 != null) {
            if (l1.data < l2.data) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        // Attach the remaining elements
        if (l1 != null) {
            current.next = l1;
        } else {
            current.next = l2;
        }

        // Return the merged list starting from the next of dummy node
        return dummy.next;
    }

    public static void main(String[] args) {
        // Create two sorted linked lists
        Node l1 = new Node(1);
        l1.next = new Node(3);
        l1.next.next = new Node(5);

        Node l2 = new Node(2);
        l2.next = new Node(4);
        l2.next.next = new Node(6);

        // Merge the lists
        Node mergedList = mergeTwoLists(l1, l2);

        // Print the merged list
        mergedList.printList();
    }
}

