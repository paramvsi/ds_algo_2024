package sheet.trees.problems;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class T02ReverseLevelOrderTransversal {

    // Method to perform reverse level order traversal of the tree
    static void reverseLevelOrderTraversal(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> queue = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            stack.push(current);

            // Important: push right first so that left is on top in stack
            if (current.right != null) {
                queue.add(current.right);
            }
            if (current.left != null) {
                queue.add(current.left);
            }
        }

        // Print all elements in stack
        while (!stack.isEmpty()) {
            System.out.print(stack.pop().value + " ");
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

        System.out.println("Reverse Level Order Traversal of the tree:");
        reverseLevelOrderTraversal(root);
    }
}

