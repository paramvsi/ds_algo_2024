package sheet.trees.problems;

public class T28FindMinAndMaxInABST {
    // Method to find the minimum value in the BST
    static int findMin(TreeNode root) {
        if (root == null) {
            throw new IllegalStateException("The BST is empty.");
        }
        while (root.left != null) {
            root = root.left;
        }
        return root.value;
    }

    // Method to find the maximum value in the BST
    static int findMax(TreeNode root) {
        if (root == null) {
            throw new IllegalStateException("The BST is empty.");
        }
        while (root.right != null) {
            root = root.right;
        }
        return root.value;
    }

    public static void main(String[] args) {
        TreeNode root = null;
        root = insert(root, 20);
        root = insert(root, 10);
        root = insert(root, 30);
        root = insert(root, 5);
        root = insert(root, 15);
        root = insert(root, 25);
        root = insert(root, 35);

        System.out.println("Minimum value in the BST: " + findMin(root));
        System.out.println("Maximum value in the BST: " + findMax(root));
    }

    // Helper method to insert values in the BST
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
}
