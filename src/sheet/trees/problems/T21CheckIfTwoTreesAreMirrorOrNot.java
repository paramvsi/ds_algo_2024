package sheet.trees.problems;


public class T21CheckIfTwoTreesAreMirrorOrNot {

    // Function to check if two trees are mirrors of each other
    static boolean areMirrors(Node root1, Node root2) {
        // If both trees are empty, they are mirrors of each other
        if (root1 == null && root2 == null) {
            return true;
        }

        // If only one of the trees is empty, they are not mirrors of each other
        if (root1 == null || root2 == null) {
            return false;
        }

        // Check if the data of both roots is the same and
        // the left subtree of root1 is a mirror of the right subtree of root2
        // and the right subtree of root1 is a mirror of the left subtree of root2
        return (root1.data == root2.data) &&
                areMirrors(root1.left, root2.right) &&
                areMirrors(root1.right, root2.left);
    }

    public static void main(String[] args) {
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.left = new Node(4);
        root1.left.right = new Node(5);

        Node root2 = new Node(1);
        root2.left = new Node(3);
        root2.right = new Node(2);
        root2.right.left = new Node(5);
        root2.right.right = new Node(4);

        if (areMirrors(root1, root2)) {
            System.out.println("The two trees are mirrors of each other.");
        } else {
            System.out.println("The two trees are not mirrors of each other.");
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

