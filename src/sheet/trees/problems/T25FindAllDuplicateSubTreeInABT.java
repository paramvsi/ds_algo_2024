package sheet.trees.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T25FindAllDuplicateSubTreeInABT {

    // Helper function to serialize the subtree and find duplicates
    static String serialize(Node node, Map<String, Integer> subtreeMap, List<Node> duplicates) {
        if (node == null) {
            return "#"; // Use '#' to represent null nodes
        }

        String left = serialize(node.left, subtreeMap, duplicates);
        String right = serialize(node.right, subtreeMap, duplicates);

        // Serialize the current subtree
        String subtree = node.data + "," + left + "," + right;

        // Add the serialized subtree to the map or update its count
        subtreeMap.put(subtree, subtreeMap.getOrDefault(subtree, 0) + 1);

        // If the count becomes 2, add this node to duplicates list (only add once)
        if (subtreeMap.get(subtree) == 2) {
            duplicates.add(node);
        }

        return subtree;
    }

    // Function to find all duplicate subtrees
    static List<Node> findDuplicateSubtrees(Node root) {
        List<Node> duplicates = new ArrayList<>();
        Map<String, Integer> subtreeMap = new HashMap<>();
        serialize(root, subtreeMap, duplicates);
        return duplicates;
    }

    // Helper function to print the tree in inorder traversal
    static void printInorder(Node node) {
        if (node == null) {
            return;
        }
        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(2);
        root.right.left.left = new Node(4);
        root.right.left.right = new Node(5);
        root.right.right = new Node(4);

        List<Node> duplicates = findDuplicateSubtrees(root);

        System.out.println("Duplicate Subtrees:");
        for (Node duplicate : duplicates) {
            printInorder(duplicate);
            System.out.println();
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
}

