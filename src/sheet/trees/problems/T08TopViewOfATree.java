package sheet.trees.problems;


import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class T08TopViewOfATree {
    // Method to print the top view of the binary tree
    static void topView(TreeNode root) {
        if (root == null) return;

        Map<Integer, Integer> topViewMap = new TreeMap<>();
        Queue<NodeDetails> queue = new LinkedList<>();

        queue.add(new NodeDetails(root, 0));

        while (!queue.isEmpty()) {
            NodeDetails temp = queue.poll();
            int hd = temp.horizontalDistance;
            TreeNode node = temp.node;

            // Put the node value for a horizontal distance in map if not already present
            if (!topViewMap.containsKey(hd)) {
                topViewMap.put(hd, node.value);
            }

            // Add left child
            if (node.left != null) {
                queue.add(new NodeDetails(node.left, hd - 1));
            }

            // Add right child
            if (node.right != null) {
                queue.add(new NodeDetails(node.right, hd + 1));
            }
        }

        // Printing the top view
        for (Map.Entry<Integer, Integer> entry : topViewMap.entrySet()) {
            System.out.print(entry.getValue() + " ");
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.right.right = new TreeNode(5);
        root.left.right.right.right = new TreeNode(6);

        System.out.println("Top View of the tree:");
        topView(root);
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

    static class NodeDetails {
        TreeNode node;
        int horizontalDistance;

        NodeDetails(TreeNode node, int horizontalDistance) {
            this.node = node;
            this.horizontalDistance = horizontalDistance;
        }
    }
}
