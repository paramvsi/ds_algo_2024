package sheet.trees.problems;


import java.util.LinkedList;
import java.util.Queue;

public class T07RightViewOfATree {
    // Method to print the right view of the binary tree
    static void rightView(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            // number of nodes at current level
            int levelSize = queue.size();

            // Traverse all nodes of current level
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();

                // Print the last node of each level
                if (i == levelSize - 1) {
                    assert node != null;
                    System.out.print(node.value + " ");
                }

                // Add left node to queue
                assert node != null;
                if (node.left != null) {
                    queue.add(node.left);
                }

                // Add right node to queue
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
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

        System.out.println("Right View of the tree:");
        rightView(root);
    }

    static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        TreeNode(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
}
