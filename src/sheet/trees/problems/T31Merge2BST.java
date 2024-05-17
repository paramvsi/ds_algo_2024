package sheet.trees.problems;

import java.util.ArrayList;
import java.util.List;

public class T31Merge2BST {
    // Method to perform in-order traversal and store results in a list
    static void inorderTraversal(TreeNode node, List<Integer> list) {
        if (node != null) {
            inorderTraversal(node.left, list);
            list.add(node.value);
            inorderTraversal(node.right, list);
        }
    }

    // Method to merge two sorted lists into one
    static List<Integer> mergeLists(List<Integer> list1, List<Integer> list2) {
        List<Integer> merged = new ArrayList<>();
        int i = 0, j = 0;
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) < list2.get(j)) {
                merged.add(list1.get(i++));
            } else {
                merged.add(list2.get(j++));
            }
        }
        while (i < list1.size()) {
            merged.add(list1.get(i++));
        }
        while (j < list2.size()) {
            merged.add(list2.get(j++));
        }
        return merged;
    }

    // Method to construct a balanced BST from a sorted list
    static TreeNode sortedListToBST(List<Integer> list, int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(list.get(mid));
        node.left = sortedListToBST(list, start, mid - 1);
        node.right = sortedListToBST(list, mid + 1, end);
        return node;
    }

    // Utility method to print the BST in order
    static void printInOrder(TreeNode node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.print(node.value + " ");
            printInOrder(node.right);
        }
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(4);

        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(6);

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        inorderTraversal(root1, list1);
        inorderTraversal(root2, list2);

        List<Integer> mergedList = mergeLists(list1, list2);
        TreeNode mergedTree = sortedListToBST(mergedList, 0, mergedList.size() - 1);

        System.out.println("Merged BST (In-order):");
        printInOrder(mergedTree);
    }
}

