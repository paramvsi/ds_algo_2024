package sheet.trees.problems;


public class T16ConvertBTIntoSumTree {
    // Function to convert a given binary tree into a sum tree
    static int toSumTree(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // Store the old value
        int oldValue = node.value;

        // Recursively convert the left and right subtrees
        int leftSum = toSumTree(node.left);
        int rightSum = toSumTree(node.right);

        // Update the node's value to the sum of values of left and right subtrees
        node.value = leftSum + rightSum;

        // Return the sum of values under this subtree including the node's old value
        return node.value + oldValue;
    }

    // Helper function to print inorder traversal of the binary tree
    static void printInOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        printInOrder(node.left);
        System.out.print(node.value + " ");
        printInOrder(node.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(-2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(8);
        root.left.right = new TreeNode(-4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(5);

        System.out.println("Original tree (Inorder):");
        printInOrder(root);
        System.out.println();

        toSumTree(root);

        System.out.println("Sum tree (Inorder):");
        printInOrder(root);
    }

}

