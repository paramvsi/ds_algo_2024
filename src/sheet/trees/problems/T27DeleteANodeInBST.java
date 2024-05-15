package sheet.trees.problems;

public class T27DeleteANodeInBST {
    // Method to insert values in the BST
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

    // Method to delete a node from the BST
    static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return root;
        }

        if (key < root.value) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.value) {
            root.right = deleteNode(root.right, key);
        } else {
            // This is the node to be deleted
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Node with two children, get the inorder successor (smallest in the right subtree)
            root.value = minValue(root.right);

            // Delete the inorder successor
            root.right = deleteNode(root.right, root.value);
        }
        return root;
    }

    // Helper method to find minimum value in a tree
    static int minValue(TreeNode root) {
        int minv = root.value;
        while (root.left != null) {
            minv = root.left.value;
            root = root.left;
        }
        return minv;
    }

    // Helper method to do inorder traversal of the BST
    static void inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.value + " ");
            inorderTraversal(root.right);
        }
    }

    public static void main(String[] args) {
        TreeNode root = null;
        root = insert(root, 50);
        root = insert(root, 30);
        root = insert(root, 20);
        root = insert(root, 40);
        root = insert(root, 70);
        root = insert(root, 60);
        root = insert(root, 80);

        System.out.println("Inorder traversal of the original BST:");
        inorderTraversal(root);
        System.out.println();

        root = deleteNode(root, 20);
        System.out.println("Inorder traversal after deleting 20:");
        inorderTraversal(root);
        System.out.println();

        root = deleteNode(root, 30);
        System.out.println("Inorder traversal after deleting 30:");
        inorderTraversal(root);
        System.out.println();

        root = deleteNode(root, 50);
        System.out.println("Inorder traversal after deleting 50:");
        inorderTraversal(root);
        System.out.println();
    }
}

