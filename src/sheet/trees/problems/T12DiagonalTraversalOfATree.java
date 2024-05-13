package sheet.trees.problems;


import java.util.*;

public class T12DiagonalTraversalOfATree {
    // Method to perform diagonal traversal of the binary tree
    static void diagonalTraversal(TreeNode root) {
        if (root == null) return;

        class NodeDetails {
            final TreeNode node;
            final int diagonal;

            NodeDetails(TreeNode node, int diagonal) {
                this.node = node;
                this.diagonal = diagonal;
            }
        }

        // Map to hold the nodes at each diagonal level
        Map<Integer, List<Integer>> diagonalMap = new HashMap<>();
        Queue<NodeDetails> queue = new LinkedList<>();


        // Initialize the queue with the root node at diagonal 0
        queue.add(new NodeDetails(root, 0));

        while (!queue.isEmpty()) {
            NodeDetails temp = queue.poll();
            TreeNode node = temp.node;
            int d = temp.diagonal;

            // Add the node to the corresponding diagonal in the map
            diagonalMap.computeIfAbsent(d, k -> new ArrayList<>()).add(node.value);

            // Left child goes to the next diagonal
            if (node.left != null) {
                queue.add(new NodeDetails(node.left, d + 1));
            }

            // Right child stays on the same diagonal
            if (node.right != null) {
                queue.add(new NodeDetails(node.right, d));
            }
        }

        // Output the diagonal traversal
        for (int key : new TreeSet<>(diagonalMap.keySet())) {
            System.out.println("Diagonal " + key + ": " + diagonalMap.get(key));
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(3);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(6);
        root.right.right = new TreeNode(14);
        root.left.right.left = new TreeNode(4);
        root.left.right.right = new TreeNode(7);
        root.right.right.left = new TreeNode(13);

        System.out.println("Diagonal Traversal of the tree:");
        diagonalTraversal(root);
    }
}

