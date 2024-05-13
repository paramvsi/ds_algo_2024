package sheet.trees.problems;


public class T13BoundaryTraversalOfATree {


    // Method to perform boundary traversal of the binary tree
    static void boundaryTraversal(TreeNode root) {
        if (root == null) return;

        System.out.print(root.value + " "); // Print the root node

        // Print the left boundary
        printLeftBoundary(root.left);

        // Print the leaf nodes
        printLeaves(root.left);
        printLeaves(root.right);

        // Print the right boundary
        printRightBoundary(root.right);
    }

    static void printLeftBoundary(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            // to ensure top down order, print the node before calling itself for left subtree
            System.out.print(node.value + " ");
            printLeftBoundary(node.left);
        } else if (node.right != null) {
            System.out.print(node.value + " ");
            printLeftBoundary(node.right);
        }
        // do nothing if it is a leaf node, this way we avoid duplicates in output
    }

    static void printLeaves(TreeNode node) {
        if (node == null) {
            return;
        }
        printLeaves(node.left);
        // Print it if it is a leaf node
        if (node.left == null && node.right == null) {
            System.out.print(node.value + " ");
        }
        printLeaves(node.right);
    }

    static void printRightBoundary(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.right != null) {
            // to ensure bottom up order, first call for right subtree, then print this node
            printRightBoundary(node.right);
            System.out.print(node.value + " ");
        } else if (node.left != null) {
            printRightBoundary(node.left);
            System.out.print(node.value + " ");
        }
        // do nothing if it is a leaf node, this way we avoid duplicates in output
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.right = new TreeNode(22);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(12);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);
        root.right.right = new TreeNode(25);

        System.out.println("Boundary Traversal of the tree:");
        boundaryTraversal(root);
    }
}

