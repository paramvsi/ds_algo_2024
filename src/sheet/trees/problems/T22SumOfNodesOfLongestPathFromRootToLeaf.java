package sheet.trees.problems;


public class T22SumOfNodesOfLongestPathFromRootToLeaf {

    // Function to find the sum of nodes on the longest path from root to a leaf
    static void findLongestPathSum(Node node, int currentSum, int currentLength, Result result) {
        if (node == null) {
            // If we reach a leaf node, check if this path is longer or has the same length with a greater sum
            if (currentLength > result.maxLength) {
                result.maxLength = currentLength;
                result.maxSum = currentSum;
            } else if (currentLength == result.maxLength) {
                result.maxSum = Math.max(result.maxSum, currentSum);
            }
            return;
        }

        // Recur for left and right subtrees
        findLongestPathSum(node.left, currentSum + node.data, currentLength + 1, result);
        findLongestPathSum(node.right, currentSum + node.data, currentLength + 1, result);
    }

    public static int sumOfLongestPathFromRootToLeaf(Node root) {
        if (root == null) {
            return 0;
        }

        Result result = new Result();
        findLongestPathSum(root, 0, 0, result);
        return result.maxSum;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println("Sum of nodes on the longest path from root to leaf: " + sumOfLongestPathFromRootToLeaf(root));
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

    // Helper class to store the result
    static class Result {
        int maxSum;
        int maxLength;

        Result() {
            maxSum = 0;
            maxLength = 0;
        }
    }
}

