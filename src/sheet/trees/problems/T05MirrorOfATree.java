package sheet.trees.problems;


public class T05MirrorOfATree {
    // Method to mirror the tree
    static void mirror(TreeNode node) {
        if (node == null) return;

        // Swap the left and right children
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;

        // Recursively mirror the left and right subtrees
        mirror(node.left);
        mirror(node.right);
    }

    // Method for inorder traversal of the tree
    static void inorderTraversal(TreeNode node) {
        if (node == null) return;
        inorderTraversal(node.left);
        System.out.print(node.value + " ");
        inorderTraversal(node.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println("Original tree (Inorder Traversal):");
        inorderTraversal(root);
        System.out.println();

        mirror(root);

        System.out.println("Mirror of the tree (Inorder Traversal):");
        inorderTraversal(root);
    }
}

