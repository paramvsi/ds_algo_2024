package sheet.google.months_6;
//  https://leetcode.com/problems/delete-nodes-and-return-forest


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class F05DeleteNodeAndReturnForest {
    public static void main(String[] args) {
        F05DeleteNodeAndReturnForest solution = new F05DeleteNodeAndReturnForest();

        // Create a sample tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        int[] to_delete = {3, 5};

        List<TreeNode> forest = solution.delNodes(root, to_delete);
        System.out.println("Roots of the resulting forest:");
        for (TreeNode tree : forest) {
            System.out.println(tree.val);
        }
    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> forest = new ArrayList<>();
        Set<Integer> toDeleteSet = new HashSet<>();

        // Add all nodes to delete into a set for quick lookup
        for (int val : to_delete) {
            toDeleteSet.add(val);
        }

        // Recursive helper function
        root = helper(root, toDeleteSet, forest);

        // If the root itself is not deleted, add it to the forest
        if (root != null) {
            forest.add(root);
        }

        return forest;
    }

    private TreeNode helper(TreeNode node, Set<Integer> toDeleteSet, List<TreeNode> forest) {
        if (node == null) {
            return null;
        }

        // Post-order traversal: process children first
        node.left = helper(node.left, toDeleteSet, forest);
        node.right = helper(node.right, toDeleteSet, forest);

        // If the current node needs to be deleted
        if (toDeleteSet.contains(node.val)) {
            // Add children to forest if they are not null
            if (node.left != null) {
                forest.add(node.left);
            }
            if (node.right != null) {
                forest.add(node.right);
            }
            return null; // Return null to delete this node
        }

        return node; // Return the node itself if it is not deleted
    }

    // Definition for a binary tree node
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
}

