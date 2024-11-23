package sheet.google.months_6;

// https://leetcode.com/problems/flip-equivalent-binary-trees/description/

public class F17FlipEquivalentTrees {

    public static void main(String[] args) {
        F17FlipEquivalentTrees solution = new F17FlipEquivalentTrees();

        // Example 1
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        root1.right.left = new TreeNode(6);
        root1.left.right.left = new TreeNode(7);
        root1.left.right.right = new TreeNode(8);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(3);
        root2.right = new TreeNode(2);
        root2.left.right = new TreeNode(6);
        root2.right.left = new TreeNode(4);
        root2.right.right = new TreeNode(5);
        root2.right.right.left = new TreeNode(8);
        root2.right.right.right = new TreeNode(7);

        System.out.println(solution.flipEquiv(root1, root2)); // Output: true
    }

    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        // Base cases
        if (root1 == null && root2 == null) {
            return true; // Both trees are null
        }
        if (root1 == null || root2 == null) {
            return false; // One tree is null, the other is not
        }
        if (root1.val != root2.val) {
            return false; // Root values are different
        }

        // Check both possibilities:
        // 1. Subtrees are equivalent without flipping
        // 2. Subtrees are equivalent with flipping
        boolean noFlip = flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right);
        boolean flip = flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left);

        return noFlip || flip;
    }

    // TreeNode definition
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
}
