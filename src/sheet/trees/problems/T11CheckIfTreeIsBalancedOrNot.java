package sheet.trees.problems;

public class T11CheckIfTreeIsBalancedOrNot {
    // Helper method to check if the tree is balanced and return the height
    static int isBalancedHelper(TreeNode node) {
        if (node == null) {
            return 0; // Height of an empty tree is 0 and it is balanced
        }

        int leftHeight = isBalancedHelper(node.left);
        if (leftHeight == -1) return -1; // Left subtree is not balanced

        int rightHeight = isBalancedHelper(node.right);
        if (rightHeight == -1) return -1; // Right subtree is not balanced

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1; // Current node is not balanced
        }

        return Math.max(leftHeight, rightHeight) + 1; // Return height of the current node
    }

    // Public method to check if the tree is balanced
    static boolean isBalanced(TreeNode root) {
        return isBalancedHelper(root) != -1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(5); // Adding extra depth to make it unbalanced

        System.out.println("Is the tree balanced? " + isBalanced(root));
    }

    static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        TreeNode(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
}

