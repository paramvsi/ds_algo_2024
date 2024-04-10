package sheet.linkedlist;


public class SortLinkedList {

    // Function to merge two sorted linked lists
    private static Node merge(Node left, Node right) {
        Node dummy = new Node(0);
        Node current = dummy;

        while (left != null && right != null) {
            if (left.data < right.data) {
                current.next = left;
                left = left.next;
            } else {
                current.next = right;
                right = right.next;
            }
            current = current.next;
        }

        // Attach the remaining elements
        if (left != null) {
            current.next = left;
        } else if (right != null) {
            current.next = right;
        }

        return dummy.next;
    }

    // Function to split the linked list into two halves
    private static Node[] split(Node head) {
        Node slow = head;
        Node fast = head;
        Node prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        Node[] halves = new Node[2];
        halves[0] = head;
        halves[1] = slow;

        if (prev != null) {
            prev.next = null;  // Split the list into two halves
        }

        return halves;
    }

    // Function to perform merge sort on the linked list
    public static Node mergeSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node[] halves = split(head);
        Node left = mergeSort(halves[0]);
        Node right = mergeSort(halves[1]);

        return merge(left, right);
    }

    public static void main(String[] args) {
        // Create an unsorted linked list
        Node head = new Node(4);
        head.next = new Node(2);
        head.next.next = new Node(1);
        head.next.next.next = new Node(3);

        // Sort the list
        head = mergeSort(head);

        // Print the sorted list
        head.printList();
    }
}

