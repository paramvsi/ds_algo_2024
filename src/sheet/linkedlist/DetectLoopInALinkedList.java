package sheet.linkedlist;

public class DetectLoopInALinkedList {


    Node head;

    public static void main(String[] args) {
        DetectLoopInALinkedList list = new DetectLoopInALinkedList();
        list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(5);

        // Create a loop for testing
        list.createLoop(2); // Create a loop at node with value 3

        if (list.hasLoop()) {
            System.out.println("Loop detected");
        } else {
            System.out.println("No loop detected");
        }
    }

    // Method to detect a loop in the linked list
    public boolean hasLoop() {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;         // Move slow pointer one step
            fast = fast.next.next;    // Move fast pointer two steps

            // If slow and fast pointers meet, there is a loop
            if (slow == fast) {
                return true;
            }
        }

        // No loop found
        return false;
    }

    // Helper method to create a loop in the linked list for testing
    public void createLoop(int position) {
        if (position <= 0) return;

        Node loopNode = head;
        Node tail = head;

        // Find the node at the specified position and the last node
        while (tail.next != null) {
            if (position-- > 0) {
                loopNode = loopNode.next;
            }
            tail = tail.next;
        }

        // Create a loop by pointing the last node to the node at the specified position
        tail.next = loopNode;
    }


}
