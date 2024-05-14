package sheet.trees.problems;


import java.util.HashMap;
import java.util.Map;

public class T20CheckIfBTContainsDuplicateSubtreesofSize2OrMore {

    // Class to represent a node in the tree
    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    // Function to serialize the subtree rooted at the given node
    static String serialize(Node node, Map<String, Integer> subtreeMap) {
        if (node == null) {
            return "#"; // Use '#' to represent null nodes
        }

        String left = serialize(node.left, subtreeMap);
        String right = serialize(node.right, subtreeMap);

        // Serialize the current subtree
        String subtree = node.data + "," + left + "," + right;

        // Add the serialized subtree to the map or update its count
        subtreeMap.put(subtree, subtreeMap.getOrDefault(subtree, 0) + 1);

        return subtree;
    }

    // Function to check if the binary tree contains duplicate subtrees of size 2 or more
    static boolean hasDuplicateSubtree(Node root) {
        Map<String, Integer> subtreeMap = new HashMap<>();
        serialize(root, subtreeMap);

        // Check the map for any subtree that appears more than once
        for (Map.Entry<String, Integer> entry : subtreeMap.entrySet()) {
            if (entry.getValue() > 1 && entry.getKey().length() > 3) { // Check size > 3 to ensure size 2 or more
                return true;
            }
        }
        return false;
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

        if (hasDuplicateSubtree(root)) {
            System.out.println("The binary tree contains duplicate subtrees of size 2 or more.");
        } else {
            System.out.println("The binary tree does not contain duplicate subtrees of size 2 or more.");
        }
    }
}
