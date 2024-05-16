package sheet.trees.problems;


public class T30FindLCAOf2NodesInBST {
    // Method to insert values in the BST
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

    // Function to find LCA of n1 and n2. The function assumes that both n1 and n2 are present in the BST
    static TreeNode findLCA(TreeNode root, int n1, int n2) {
        while (root != null) {
            // If both n1 and n2 are smaller than root, then LCA lies in left
            if (root.value > n1 && root.value > n2) {
                root = root.left;
            }
            // If both n1 and n2 are greater than root, then LCA lies in right
            else if (root.value < n1 && root.value < n2) {
                root = root.right;
            } else {
                break; // This is the LCA
            }
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

        int n1 = 10, n2 = 14;
        TreeNode lca = findLCA(root, n1, n2);
        if (lca != null) {
            System.out.println("LCA of " + n1 + " and " + n2 + " is " + lca.value);
        } else {
            System.out.println("Keys are not present in the BST");
        }
    }
}

