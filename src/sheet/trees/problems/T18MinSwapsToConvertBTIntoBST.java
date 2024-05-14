package sheet.trees.problems;

import java.util.ArrayList;
import java.util.Comparator;

public class T18MinSwapsToConvertBTIntoBST {

    // Function to perform inorder traversal and store the result
    static void inorderTraversal(Node root, ArrayList<Integer> inorder) {
        if (root == null) return;
        inorderTraversal(root.left, inorder);
        inorder.add(root.data);
        inorderTraversal(root.right, inorder);
    }

    // Function to calculate minimum swaps to sort the array
    static int minSwaps(ArrayList<Integer> arr) {
        int n = arr.size();
        ArrayList<Pair> arrPos = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arrPos.add(new Pair(arr.get(i), i));
        }
        arrPos.sort(Comparator.comparingInt(o -> o.value));

        boolean[] visited = new boolean[n];

        int swaps = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i] || arrPos.get(i).index == i) {
                continue;
            }

            int cycleSize = 0;
            int j = i;
            while (!visited[j]) {
                visited[j] = true;
                j = arrPos.get(j).index;
                cycleSize++;
            }

            if (cycleSize > 0) {
                swaps += (cycleSize - 1);
            }
        }
        return swaps;
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(6);
        root.right = new Node(7);
        root.left.left = new Node(8);
        root.left.right = new Node(9);
        root.right.left = new Node(10);

        ArrayList<Integer> inorder = new ArrayList<>();
        inorderTraversal(root, inorder);

        int swaps = minSwaps(inorder);
        System.out.println("Minimum swaps to convert the binary tree into a BST: " + swaps);
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

    // Helper class to store value and original index
    static class Pair {
        int value, index;

        Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}
