package sheet.trees.problems;

public class T34FindMedianInBST {

    // Helper method to insert nodes into the BST
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

    // Method to count nodes in the BST
    static int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    // Method to find the median of the BST
    static double findMedian(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int count = countNodes(root);
        MedianFinder medianFinder = new MedianFinder(count);
        inorder(root, medianFinder);
        return medianFinder.getMedian();
    }

    // Inorder traversal to compute median
    static void inorder(TreeNode root, MedianFinder medianFinder) {
        if (root != null) {
            inorder(root.left, medianFinder);
            medianFinder.visit(root.value);
            inorder(root.right, medianFinder);
        }
    }

    public static void main(String[] args) {
        TreeNode root = null;
        root = insert(root, 12);
        root = insert(root, 3);
        root = insert(root, 5);
        root = insert(root, 7);
        root = insert(root, 1);
        root = insert(root, 9);
        root = insert(root, 15);

        System.out.println("Median of BST is: " + findMedian(root));
    }

    // Utility class to handle median finding logic
    static class MedianFinder {
        int totalNodes;
        double median = 0;
        int prevValue = 0;
        int nodesVisited = 0;

        MedianFinder(int totalNodes) {
            this.totalNodes = totalNodes;
        }

        void visit(int value) {
            if (totalNodes % 2 == 1) { // odd, one median
                if (nodesVisited == totalNodes / 2) {
                    median = value;
                }
            } else { // even, average of two medians
                if (nodesVisited == totalNodes / 2 - 1) {
                    prevValue = value;
                } else if (nodesVisited == totalNodes / 2) {
                    median = (prevValue + value) / 2.0;
                }
            }
            nodesVisited++;
        }

        double getMedian() {
            return median;
        }
    }
}

