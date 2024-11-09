package sheet.google.gpt_150.day_02;

/*
You are given a linked list where each node contains an additional random pointer,
which could point to any node in the list or be null. Construct a deep copy of the list,
where each new node in the copied list has the same values and connections as the nodes in the original list.
The deep copy should include both the next and random pointers.
*/


class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class D02CopyListWithRandomPointer {
    public static void main(String[] args) {
        Node head = new Node(7);
        head.next = new Node(13);
        head.next.random = head; // second node's random points to the first node
        head.next.next = new Node(11);
        head.next.next.next = new Node(10);
        head.next.next.next.next = new Node(1);

        D02CopyListWithRandomPointer solution = new D02CopyListWithRandomPointer();
        Node copiedListHead = solution.copyRandomList(head);

        // Output the copied list to verify correctness
        Node current = copiedListHead;
        while (current != null) {
            System.out.println("Node val: " + current.val +
                    ", Random points to: " + (current.random != null ? current.random.val : "null"));
            current = current.next;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) return null;

        // Step 1: Create new nodes and interleave them with the original nodes
        Node current = head;
        while (current != null) {
            Node copy = new Node(current.val);
            copy.next = current.next;
            current.next = copy;
            current = copy.next;
        }

        // Step 2: Assign random pointers for the copied nodes
        current = head;
        while (current != null) {
            if (current.random != null) {
                current.next.random = current.random.next;
            }
            current = current.next.next;
        }

        // Step 3: Separate the interleaved lists
        Node original = head;
        Node copyHead = head.next;
        Node copy = copyHead;

        while (original != null) {
            original.next = original.next.next;
            if (copy.next != null) {
                copy.next = copy.next.next;
            }
            original = original.next;
            copy = copy.next;
        }

        return copyHead;
    }
}
