package sheet.recursion;


class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    TreeNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}


public class R02HeightOfABinaryTree {
    public static int getHeight(TreeNode root) {
        if (root == null) {
            return 0; // Base case: if the tree is empty, height is 0
        }
        int leftHeight = getHeight(root.left); // Recursively find the height of the left subtree
        int rightHeight = getHeight(root.right); // Recursively find the height of the right subtree
        return Math.max(leftHeight, rightHeight) + 1; // Return the greater height plus one for the current node
    }

    public static void main(String[] args) {
        // Example to create a simple binary tree
        //        1
        //       / \
        //      2   3
        //     /   / \
        //    4   5   6
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);

        System.out.println("Height of the tree is: " + getHeight(root));
    }
}

