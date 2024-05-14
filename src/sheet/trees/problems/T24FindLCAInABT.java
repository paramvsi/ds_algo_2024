package sheet.trees.problems;


public class T24FindLCAInABT {

    // Function to find the LCA of two given nodes n1 and n2
    static Node findLCA(Node root, int n1, int n2) {
        // Base case: if root is null, return null
        if (root == null) {
            return null;
        }

        // If either n1 or n2 matches with root's key, report the presence by returning root
        if (root.data == n1 || root.data == n2) {
            return root;
        }

        // Look for keys in left and right subtrees
        Node leftLCA = findLCA(root.left, n1, n2);
        Node rightLCA = findLCA(root.right, n1, n2);

        // If both of the above calls return non-null, then one key is present in one subtree
        // and the other is present in the other, so this node is the LCA
        if (leftLCA != null && rightLCA != null) {
            return root;
        }

        // Otherwise, check if the LCA is in the left or right subtree
        return (leftLCA != null) ? leftLCA : rightLCA;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        int n1 = 4, n2 = 5;
        Node lca = findLCA(root, n1, n2);
        if (lca != null) {
            System.out.println("LCA of " + n1 + " and " + n2 + " is " + lca.data);
        } else {
            System.out.println("Keys are not present in the tree");
        }

        n2 = 10;
        lca = findLCA(root, n1, n2);
        if (lca != null) {
            System.out.println("LCA of " + n1 + " and " + n2 + " is " + lca.data);
        } else {
            System.out.println("Keys are not present in the tree");
        }
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
}

