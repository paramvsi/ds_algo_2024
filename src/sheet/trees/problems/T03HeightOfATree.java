package sheet.trees.problems;

public class T03HeightOfATree {

    // Method to calculate the height of a binary tree
    static int height(TreeNode node) {
        if (node == null) {
            // Base case: the height of an empty tree is -1
            return -1;
        } else {
            // Recursive case: 1 + the greater height between the left child and the right child
            return 1 + Math.max(height(node.left), height(node.right));
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.left.left.left = new TreeNode(7);

        System.out.println("Height of the tree:");
        System.out.println(height(root)); // Outputs the height of the tree
    }
}

