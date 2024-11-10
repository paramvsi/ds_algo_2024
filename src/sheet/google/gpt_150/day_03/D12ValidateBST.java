package sheet.google.gpt_150.day_03;


public class D12ValidateBST {

    public static void main(String[] args) {
        D12ValidateBST solution = new D12ValidateBST();

        TreeNode root1 = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        System.out.println("Is valid BST? " + solution.isValidBST(root1)); // Output: true

        TreeNode root2 = new TreeNode(5, new TreeNode(1), new TreeNode(4, new TreeNode(3), new TreeNode(6)));
        System.out.println("Is valid BST? " + solution.isValidBST(root2)); // Output: false
    }

    public boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }

    private boolean validate(TreeNode node, Integer lower, Integer upper) {
        if (node == null) {
            return true;
        }

        int val = node.val;
        // Check if the current node's value violates the BST properties
        if (lower != null && val <= lower) return false;
        if (upper != null && val >= upper) return false;

        // Recursively validate the left and right subtrees
        if (!validate(node.right, val, upper)) return false;
        if (!validate(node.left, lower, val)) return false;

        return true;
    }

    // Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

