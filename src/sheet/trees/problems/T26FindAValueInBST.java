package sheet.trees.problems;

public class T26FindAValueInBST {
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

    // Method to find a value in the BST
    static boolean findValue(TreeNode root, int value) {
        while (root != null) {
            if (value < root.value) {
                root = root.left;
            } else if (value > root.value) {
                root = root.right;
            } else {
                // Value found
                return true;
            }
        }
        // Value not found
        return false;
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

        int searchValue = 15;
        if (findValue(root, searchValue)) {
            System.out.println("Value " + searchValue + " found in the BST.");
        } else {
            System.out.println("Value " + searchValue + " not found in the BST.");
        }
    }
}

