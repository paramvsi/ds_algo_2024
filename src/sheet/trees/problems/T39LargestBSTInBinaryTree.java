package sheet.trees.problems;


public class T39LargestBSTInBinaryTree {

    // Helper function to find the largest BST
    static SubtreeData findLargestBST(TreeNode node) {
        if (node == null) {
            return new SubtreeData(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        SubtreeData left = findLargestBST(node.left);
        SubtreeData right = findLargestBST(node.right);

        if (left.isBST && right.isBST && node.value > left.max && node.value < right.min) {
            // Current node is a root of a BST
            return new SubtreeData(true, left.size + right.size + 1,
                    Math.min(node.value, left.min),
                    Math.max(node.value, right.max));
        }

        // If not a BST, return the size of the largest BST that exists in its subtrees
        return new SubtreeData(false, Math.max(left.size, right.size), 0, 0);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(8);
        root.right.right = new TreeNode(7);  // Violates BST, should be more than 15

        SubtreeData result = findLargestBST(root);
        System.out.println("Size of the largest BST is: " + result.size);
    }

    static class SubtreeData {
        boolean isBST;
        int size;
        int min;
        int max;

        SubtreeData(boolean isBST, int size, int min, int max) {
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }
}

