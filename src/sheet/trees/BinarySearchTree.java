package sheet.trees;

public class BinarySearchTree {

    BinaryTreeNode root;

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);

        System.out.println("Original BST");
        inorderTraversal(bst.root);
        System.out.println();

        System.out.println("BST after deleting 20");
        bst.deleteKey(20);
        inorderTraversal(bst.root);
        System.out.println();

        System.out.println("BST after deleting 30");
        bst.deleteKey(30);
        inorderTraversal(bst.root);
        System.out.println();

        System.out.println("Searching for 40 in the BST:");
        System.out.println(bst.search(bst.root, 40) ? "Found" : "Not Found");
    }

    static void inorderTraversal(BinaryTreeNode node) {
        if (node == null) return;

        inorderTraversal(node.left);
        System.out.print(node.value + " ");
        inorderTraversal(node.right);
    }

    void insert(int value) {
        root = insertRec(root, value);
    }

    BinaryTreeNode insertRec(BinaryTreeNode root, int value) {
        if (root == null) {
            root = new BinaryTreeNode(value);
            return root;
        }

        if (value < root.value) {
            root.left = insertRec(root.left, value);
        } else if (value > root.value) {
            root.right = insertRec(root.right, value);
        }

        return root;
    }

    boolean search(BinaryTreeNode root, int value) {
        if (root == null) {
            return false;
        } else if (value == root.value) {
            return true;
        } else if (value < root.value) {
            return search(root.left, value);
        } else {
            return search(root.right, value);
        }
    }

    // Get min value

    void deleteKey(int key) {
        root = deleteRec(root, key);
    }

    BinaryTreeNode deleteRec(BinaryTreeNode root, int key) {
        if (root == null) return root;

        if (key < root.value) {
            root.left = deleteRec(root.left, key);
        } else if (key > root.value) {
            root.right = deleteRec(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            root.value = minValue(root.right);
            root.right = deleteRec(root.right, root.value);
        }
        return root;
    }

    int minValue(BinaryTreeNode root) {
        int minv = root.value;
        while (root.left != null) {
            minv = root.left.value;
            root = root.left;
        }
        return minv;
    }
}
