package sheet.trees.problems;

public class T36ReplaceEveryElemWithLeastGreaterElemOnRight {
    // Method to insert a new value into the BST. It updates the result array to contain the next greater element.
    static TreeNode insert(TreeNode root, int value, int[] result, int i) {
        if (root == null) {
            root = new TreeNode(value);
            return root;
        }

        // If value is less than the root value, it must go to the left subtree
        if (value < root.value) {
            root.left = insert(root.left, value, result, i);
            // Since the current root value is greater and on the right, it can be a candidate.
            // We take the minimum of the current root value or an already found greater value in result[i].
            result[i] = Math.min(result[i], root.value);
        } else {
            // If value is greater, it goes to the right subtree
            root.right = insert(root.right, value, result, i);
        }

        return root;
    }

    // Function to replace every element with the next greater element
    static void replaceWithLeastGreater(int[] arr) {
        TreeNode root = null;
        int n = arr.length;
        int[] result = new int[n];
        java.util.Arrays.fill(result, Integer.MAX_VALUE); // Initialize result array with MAX_VALUE

        // Process each element from right to left
        for (int i = n - 1; i >= 0; i--) {
            root = insert(root, arr[i], result, i);
        }

        // Replace elements in original array with result
        for (int i = 0; i < n; i++) {
            arr[i] = result[i] == Integer.MAX_VALUE ? -1 : result[i]; // Replace MAX_VALUE with -1 if no greater element found
        }
    }

    public static void main(String[] args) {
        int[] arr = {8, 58, 71, 18, 31, 32, 63, 92, 43, 3, 91, 93, 25, 80, 28};
        System.out.println("Original Array: " + java.util.Arrays.toString(arr));
        replaceWithLeastGreater(arr);
        System.out.println("Modified Array: " + java.util.Arrays.toString(arr));
    }
}

