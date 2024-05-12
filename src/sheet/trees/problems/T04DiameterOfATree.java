package sheet.trees.problems;

public class T04DiameterOfATree {
    static int maxDiameter = 0;  // This will hold the maximum diameter at any point

    // Method to calculate the diameter of the binary tree
    static int diameter(TreeNode root) {
        maxDepth(root);
        return maxDiameter;
    }

    // A utility method to calculate the depth of the tree while updating the diameter
    static int maxDepth(TreeNode node) {
        if (node == null) return 0;

        int leftHeight = maxDepth(node.left);       // height of left subtree
        int rightHeight = maxDepth(node.right);     // height of right subtree

        // Update the maximum diameter if the path through the current node is larger
        maxDiameter = Math.max(maxDiameter, leftHeight + rightHeight);

        return 1 + Math.max(leftHeight, rightHeight);  // return the height of the current node
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.left.left.left = new TreeNode(7);

        System.out.println("Diameter of the tree:");
        System.out.println(diameter(root));  // Outputs the diameter of the tree
    }
}

