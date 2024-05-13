package sheet.trees.problems;


import java.util.LinkedList;
import java.util.Queue;

public class T06LeftViewOfATree {
    // Method to print the left view of the binary tree
    static void leftView(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            // number of nodes at current level
            int levelSize = queue.size();

            // Traverse all nodes of current level
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();

                // Print the first node of each level
                if (i == 0) {
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

        System.out.println("Left View of the tree:");
        leftView(root);
    }

}

