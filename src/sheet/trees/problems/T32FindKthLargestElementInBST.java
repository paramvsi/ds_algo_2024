package sheet.trees.problems;


public class T32FindKthLargestElementInBST {


    // Method to find the kth largest element in the BST
    static Integer findKthLargest(TreeNode root, int k) {
        Counter c = new Counter(); // Counter to keep track of the number of nodes processed
        return findKthLargestUtil(root, k, c);
    }

    // Utility function to perform reverse in-order traversal and find the kth largest
    static Integer findKthLargestUtil(TreeNode node, int k, Counter c) {
        // Base case
        if (node == null) {
            return null;
        }

        // Search in right subtree
        Integer result = findKthLargestUtil(node.right, k, c);
        if (result != null) {
            return result;
        }

        // Increase count of visited nodes
        c.count++;

        // If c becomes k, this is the kth largest
        if (c.count == k) {
            return node.value;
        }

        // Otherwise, continue to left subtree
        return findKthLargestUtil(node.left, k, c);
    }

    // Helper method to insert values in the BST
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

    public static void main(String[] args) {
        TreeNode root = null;
        root = insert(root, 20);
        root = insert(root, 8);
        root = insert(root, 22);
        root = insert(root, 4);
        root = insert(root, 12);
        root = insert(root, 10);
        root = insert(root, 14);

        int k = 3;
        Integer kthLargest = findKthLargest(root, k);
        if (kthLargest != null) {
            System.out.println(k + "th largest element is " + kthLargest);
        } else {
            System.out.println("Not enough elements in the tree");
        }
    }

    static class Counter {
        int count;
    }
}
