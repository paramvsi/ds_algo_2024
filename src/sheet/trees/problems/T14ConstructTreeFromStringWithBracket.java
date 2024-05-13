package sheet.trees.problems;

public class T14ConstructTreeFromStringWithBracket {
    // Method to construct tree from string
    static TreeNode constructTree(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        return constructTreeRec(str, new int[]{0});
    }

    // Recursive function to construct the tree
    static TreeNode constructTreeRec(String str, int[] index) {
        if (index[0] >= str.length()) {
            return null;
        }

        // Parse the number for the current node
        boolean neg = false;
        if (str.charAt(index[0]) == '-') {
            neg = true;
            index[0]++;
        }
        int num = 0;
        while (index[0] < str.length() && Character.isDigit(str.charAt(index[0]))) {
            num = num * 10 + (str.charAt(index[0]) - '0');
            index[0]++;
        }
        if (neg) {
            num = -num;
        }

        // Create the current node
        TreeNode root = new TreeNode(num);

        // If the next character is '(', parse its left subtree
        if (index[0] < str.length() && str.charAt(index[0]) == '(') {
            index[0]++; // skip '('
            root.left = constructTreeRec(str, index);
            index[0]++; // skip ')'
        }

        // If the next character is '(', parse its right subtree
        if (index[0] < str.length() && str.charAt(index[0]) == ')') {
            index[0]++; // skip '('
            root.right = constructTreeRec(str, index);
            index[0]++; // skip ')'
        }

        return root;
    }

    // Helper method to print inorder traversal of the tree
    static void printInOrder(TreeNode node) {
        if (node == null) return;
        printInOrder(node.left);
        System.out.print(node.value + " ");
        printInOrder(node.right);
    }

    public static void main(String[] args) {
        String data = "4(2(3)(1))(6(5))";
        TreeNode root = constructTree(data);
        System.out.println("Inorder traversal of the constructed tree:");
        printInOrder(root);
    }
}

