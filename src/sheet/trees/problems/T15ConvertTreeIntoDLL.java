package sheet.trees.problems;

public class T15ConvertTreeIntoDLL {
    // Helper method to print the DLL
    static void printDLL(TreeNode head) {
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.right;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Constructing a binary tree
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(12);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(25);
        root.left.right = new TreeNode(30);
        root.right.left = new TreeNode(36);

        ConvertToDLL converter = new ConvertToDLL();
        converter.convert(root);

        System.out.println("Doubly Linked List is:");
        printDLL(converter.head);
    }


    static class ConvertToDLL {
        TreeNode head = null; // Head of the DLL
        TreeNode prev = null; // Previous node in DLL

        void convert(TreeNode root) {
            if (root == null) {
                return;
            }

            // Recursively convert the left subtree
            convert(root.left);

            // If this is the first node, set it as head of the DLL
            if (prev == null) {
                head = root;
            } else {
                // Modify pointers
                root.left = prev;
                prev.right = root;
            }

            // Update previous node
            prev = root;

            // Recursively convert the right subtree
            convert(root.right);
        }
    }
}

