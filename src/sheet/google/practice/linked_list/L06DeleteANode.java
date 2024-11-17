package sheet.google.practice.linked_list;


public class L06DeleteANode {
    public static void main(String[] args) {
        // Setting up the linked list: 4 -> 5 -> 1 -> 9
        ListNode head = new ListNode(4);
        head.next = new ListNode(5);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(9);

        // The node we will delete is the one with value 5
        ListNode nodeToDelete = head.next;

        // Print original list
        System.out.print("Original List: ");
        printList(head);

        // Create an instance of Solution and use it to delete the node
        L06DeleteANode solution = new L06DeleteANode();
        solution.deleteNode(nodeToDelete);

        // Print modified list
        System.out.print("Modified List: ");
        printList(head);
    }

    // Helper method to print the list
    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.println("null");
    }

    // Method to delete a node in a linked list given access only to that node
    public void deleteNode(ListNode node) {
        node.val = node.next.val;   // Copy the value from the next node to the current node
        node.next = node.next.next; // Remove the next node from the list
    }
}

