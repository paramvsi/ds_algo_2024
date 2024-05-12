package sheet.trees;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    /*A binary tree is a type of data structure where each node has at most two children,
    which are referred to as the left child and the right child.
    Here's a quick recap on how to implement a simple binary tree and perform basic operations.*/

    // insertion
    static void insert(BinaryTreeNode root, int value) {
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            BinaryTreeNode temp = queue.poll();

            if (temp.left == null) {
                temp.left = new BinaryTreeNode(value);
                break;
            } else {
                queue.add(temp.left);
            }

            if (temp.right == null) {
                temp.right = new BinaryTreeNode(value);
                break;
            } else {
                queue.add(temp.right);
            }
        }
    }

    static void delete(BinaryTreeNode root) {
        if (root == null) return;

        BinaryTreeNode toDelete = null;
        BinaryTreeNode lastNode = null;
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);

        // Traverse the tree to find the node to delete and the last node
        while (!queue.isEmpty()) {
            lastNode = queue.poll();

            if (lastNode.value == 3) {
                toDelete = lastNode;
            }

            if (lastNode.left != null) {
                queue.add(lastNode.left);
            }

            if (lastNode.right != null) {
                queue.add(lastNode.right);
            }
        }

        if (toDelete != null) {
            int lastValue = lastNode.value;
            deleteDeepest(root, lastNode);
            toDelete.value = lastValue;
        }
    }

    static void deleteDeepest(BinaryTreeNode root, BinaryTreeNode delNode) {
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);

        BinaryTreeNode temp;
        while (!queue.isEmpty()) {
            temp = queue.poll();

            if (temp == delNode) {
                return;
            }
            if (temp.right != null) {
                if (temp.right == delNode) {
                    temp.right = null;
                    return;
                } else {
                    queue.add(temp.right);
                }
            }
            if (temp.left != null) {
                if (temp.left == delNode) {
                    temp.left = null;
                    return;
                } else {
                    queue.add(temp.left);
                }
            }
        }
    }


    // Tree transversal in order
    static void inorderTraversal(BinaryTreeNode node) {
        if (node == null) return;

        inorderTraversal(node.left);
        System.out.print(node.value + " ");
        inorderTraversal(node.right);
    }

    // Pre order transversal
    static void preorderTraversal(BinaryTreeNode node) {
        if (node == null) return;

        System.out.print(node.value + " ");  // Visit the root node
        preorderTraversal(node.left);       // Recursively traverse the left subtree
        preorderTraversal(node.right);      // Recursively traverse the right subtree
    }

    // check if tree is symmetric
    static boolean isSymmetric(BinaryTreeNode root) {
        if (root == null) return true;
        return isSymmetricHelper(root.left, root.right);
    }

    static boolean isSymmetricHelper(BinaryTreeNode left, BinaryTreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.value != right.value) return false;
        return isSymmetricHelper(left.left, right.right) && isSymmetricHelper(left.right, right.left);
    }

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(1);
        insert(root, 2);
        insert(root, 2);
        insert(root, 3);
        insert(root, 4);
        insert(root, 4);
        insert(root, 3);

        System.out.println("Inorder Traversal of the tree:");
        inorderTraversal(root);
        System.out.println();  // Move to the next line

        System.out.println("Preorder Traversal of the tree:");
        preorderTraversal(root);
        System.out.println();  // Move to the next line

        boolean symmetric = isSymmetric(root);
        System.out.println("Is the tree symmetric? " + symmetric);

        delete(root);  // Deleting node with value 3

        System.out.println("Tree after deleting 3 (Inorder Traversal):");
        inorderTraversal(root);
        System.out.println();
    }
}
