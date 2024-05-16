package sheet.trees.problems;


public class T29PopulateInorderSuccessorOfAllNodes {
    static TreeNode previous = null;  // This will keep track of the previous node in inorder traversal

    // Function to populate inorder successor of all nodes
    static void populateInorderSuccessor(TreeNode root) {
        if (root == null) {
            return;
        }

        // Traverse the right subtree first (reverse inorder)
        populateInorderSuccessor(root.right);

        // Set the next of the current node to the previous node in the traversal
        root.next = previous;

        // Update previous to the current node
        previous = root;

        // Traverse the left subtree
        populateInorderSuccessor(root.left);
    }

    // Helper function to print the tree nodes and their successors
    static void printInorderSuccessors(TreeNode root) {
        if (root != null) {
            printInorderSuccessors(root.left);

            System.out.print(root.value + " -> ");
            if (root.next != null) {
                System.out.println(root.next.value);
            } else {
                System.out.println("null");
            }

            printInorderSuccessors(root.right);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(8);
        root.right = new TreeNode(12);
        root.left.left = new TreeNode(3);

        populateInorderSuccessor(root);
        System.out.println("Inorder Successor of each node:");
        printInorderSuccessors(root);
    }

    static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;
        TreeNode next;  // This will point to the inorder successor

        TreeNode(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
            this.next = null;  // Initialize the next pointer to null
        }
    }
}
