package sheet.trees.problems;


import java.util.HashSet;
import java.util.Set;

public class T33CountTwoValuesWhoseSumIsEqualToX {

    // Method to insert values into the BST
    static TreeNode insert(TreeNode root, int value) {
        if (root == null) {
            return new TreeNode(value);
        }
        if (value < root.value) {
            root.left = insert(root.left, value);
        } else {
            root.right = insert(root.right, value);
        }
        return root;
    }

    // Method to find count of pairs with given sum
    static int countPairs(TreeNode root, int sum) {
        Set<Integer> set = new HashSet<>();
        return countPairsUtil(root, sum, set);
    }

    // Utility method to perform inorder traversal and count pairs
    static int countPairsUtil(TreeNode node, int sum, Set<Integer> set) {
        if (node == null) {
            return 0;
        }

        // Count pairs in left subtree
        int count = countPairsUtil(node.left, sum, set);

        // Check if there's a complement in the set which adds up to sum
        if (set.contains(sum - node.value)) {
            count++;
        }

        // Add current node's value to the set
        set.add(node.value);

        // Count pairs in right subtree
        count += countPairsUtil(node.right, sum, set);

        return count;
    }

    public static void main(String[] args) {
        TreeNode root = null;
        root = insert(root, 3);
        root = insert(root, 10);
        root = insert(root, 20);
        root = insert(root, 8);
        root = insert(root, 12);
        root = insert(root, 18);
        root = insert(root, 25);

        int sum = 28;
        System.out.println("Count of pairs is " + countPairs(root, sum));
    }
}

