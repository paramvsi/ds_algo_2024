package sheet.trees.problems;


public class T35CountNodesWhichLieInAGivenRange {
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

    // Method to count nodes within a given range
    static int countRange(TreeNode root, int L, int R) {
        if (root == null) {
            return 0;
        }

        // Current node's value is within the range
        if (root.value >= L && root.value <= R) {
            return 1 + countRange(root.left, L, R) + countRange(root.right, L, R);
        }
        // Current node's value is less than the lower bound of the range
        else if (root.value < L) {
            return countRange(root.right, L, R);
        }
        // Current node's value is greater than the upper bound of the range
        else {
            return countRange(root.left, L, R);
        }
    }

    public static void main(String[] args) {
        TreeNode root = null;
        root = insert(root, 20);
        root = insert(root, 8);
        root = insert(root, 22);
        root = insert(root, 4);
        root = insert(root, 12);
        root = insert(root, 10);
        root = insert(root, 14);

        int L = 10;
        int R = 22;
        System.out.println("Count of nodes within range [" + L + ", " + R + "]: " + countRange(root, L, R));
    }
}

