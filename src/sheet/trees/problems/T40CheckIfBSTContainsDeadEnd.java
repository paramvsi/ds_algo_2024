package sheet.trees.problems;


public class T40CheckIfBSTContainsDeadEnd {
    // Helper method to insert values into the BST
    static TreeNode insert(TreeNode root, int value) {
        if (root == null) {
            return new TreeNode(value);
        }
        if (value < root.value) {
            root.left = insert(root.left, value);
        } else {
            root.right = insert(root.right, value);
        }
        return root;
    }

    // Method to check for dead ends in the BST
    static boolean checkDeadEnd(TreeNode root) {
        return checkDeadEndUtil(root, 1, Integer.MAX_VALUE);
    }

    // Utility method to perform the dead end check recursively
    static boolean checkDeadEndUtil(TreeNode node, int min, int max) {
        if (node == null) {
            return false;
        }
        // If this node is a dead end
        if (min == max) {
            return true;
        }
        // Recursively check the left and right subtrees
        return checkDeadEndUtil(node.left, min, node.value - 1) ||
                checkDeadEndUtil(node.right, node.value + 1, max);
    }

    public static void main(String[] args) {
        TreeNode root = null;
        root = insert(root, 8);
        root = insert(root, 5);
        root = insert(root, 2);
        root = insert(root, 3);
        root = insert(root, 7);
        root = insert(root, 11);
        root = insert(root, 4);

        if (checkDeadEnd(root)) {
            System.out.println("The BST contains a dead end.");
        } else {
            System.out.println("The BST does not contain any dead ends.");
        }
    }
}

