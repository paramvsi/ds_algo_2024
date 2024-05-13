package sheet.trees.problems;


import java.util.Stack;

public class T10ZigZagTransversalOfATree {
    // Method to perform zigzag (spiral) traversal of the binary tree
    static void zigzagTraversal(TreeNode root) {
        if (root == null) return;

        // Stacks to hold the levels
        Stack<TreeNode> currentLevel = new Stack<>();
        Stack<TreeNode> nextLevel = new Stack<>();

        // Push the root
        currentLevel.push(root);
        // Boolean variable to distinguish between left to right and right to left
        boolean leftToRight = true;

        while (!currentLevel.isEmpty()) {
            TreeNode node = currentLevel.pop();
            System.out.print(node.value + " ");

            // Store data according to current order.
            if (leftToRight) {
                if (node.left != null) {
                    nextLevel.push(node.left);
                }
                if (node.right != null) {
                    nextLevel.push(node.right);
                }
            } else {
                if (node.right != null) {
                    nextLevel.push(node.right);
                }
                if (node.left != null) {
                    nextLevel.push(node.left);
                }
            }

            if (currentLevel.isEmpty()) {
                leftToRight = !leftToRight;
                Stack<TreeNode> temp = currentLevel;
                currentLevel = nextLevel;
                nextLevel = temp;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println("Zigzag Traversal of the tree:");
        zigzagTraversal(root);
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

