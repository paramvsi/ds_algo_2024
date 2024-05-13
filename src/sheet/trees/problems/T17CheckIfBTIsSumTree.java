package sheet.trees.problems;


public class T17CheckIfBTIsSumTree {
    // Utility function to check if a given tree is a sum tree and to return the sum of values of its nodes
    static int isSumTree(TreeNode node) {
        // Base case: an empty tree is considered a sum tree
        if (node == null) return 0;

        // If a node is a leaf node, return its value
        if (node.left == null && node.right == null) return node.value;

        // Recursively get the sum of nodes in left and right subtrees
        int leftSum = isSumTree(node.left);
        int rightSum = isSumTree(node.right);

        // If the node's value is not equal to the sum of left and right subtree sums,
        // return an invalid marker (-1)
        if (node.value != leftSum + rightSum || leftSum == -1 || rightSum == -1) {
            return -1;
        }

        // Return the total sum including this node's value
        return node.value + leftSum + rightSum;
    }

    // Wrapper function to check if the binary tree is a sum tree
    static boolean checkSumTree(TreeNode root) {
        return isSumTree(root) != -1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(26);
        root.left = new TreeNode(10);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(6);
        root.right.right = new TreeNode(3);

        if (checkSumTree(root)) {
            System.out.println("The given tree is a sum tree.");
        } else {
            System.out.println("The given tree is not a sum tree.");
        }
    }

    static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        TreeNode(int value) {
            this.value = value;
        }
    }
}

