package sheet.trees.problems;


import java.util.LinkedList;
import java.util.Queue;

public class T19CheckIfAllLeafNodeAreAtSameLevel {

    // Function to check if all leaf nodes are at the same level
    static boolean areAllLeafNodesAtSameLevel(Node root) {
        if (root == null) {
            return true;
        }

        Queue<NodeLevel> queue = new LinkedList<>();
        queue.add(new NodeLevel(root, 0));

        Integer leafLevel = null;

        while (!queue.isEmpty()) {
            NodeLevel nodeLevel = queue.poll();
            Node node = nodeLevel.node;
            int level = nodeLevel.level;

            if (node.left == null && node.right == null) { // It's a leaf node
                if (leafLevel == null) {
                    leafLevel = level; // Set the level of the first leaf node
                } else if (leafLevel != level) {
                    return false; // Found a leaf node at a different level
                }
            }

            if (node.left != null) {
                queue.add(new NodeLevel(node.left, level + 1));
            }

            if (node.right != null) {
                queue.add(new NodeLevel(node.right, level + 1));
            }
        }

        return true; // All leaf nodes are at the same level
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(7);
        root.right.right = new Node(6);

        if (areAllLeafNodesAtSameLevel(root)) {
            System.out.println("All leaf nodes are at the same level.");
        } else {
            System.out.println("All leaf nodes are not at the same level.");
        }
    }

    // Class to represent a node in the tree
    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    // Helper class to store a node and its level
    static class NodeLevel {
        Node node;
        int level;

        NodeLevel(Node node, int level) {
            this.node = node;
            this.level = level;
        }
    }
}

