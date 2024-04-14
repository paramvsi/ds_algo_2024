package sheet.linkedlist.problems;

public class P10FindPairInDLL {
    public static void findPair(DListNode head, int targetSum) {
        DListNode left = head;
        DListNode right = head;

        // Move right pointer to the end of the list
        while (right.next != null) {
            right = right.next;
        }

        // Two pointers approach to find the sum
        boolean found = false;
        while (left != null && right != null && left != right && right.next != left) {
            int sum = left.val + right.val;

            if (sum == targetSum) {
                System.out.println("Pair found: (" + left.val + ", " + right.val + ")");
                found = true;
                left = left.next;  // Move left pointer to the right
                right = right.prev;  // Move right pointer to the left
            } else if (sum < targetSum) {
                left = left.next;  // Need a larger sum
            } else {
                right = right.prev;  // Need a smaller sum
            }
        }

        if (!found) {
            System.out.println("No pair with sum " + targetSum + " found.");
        }
    }

    public static void main(String[] args) {
        DListNode head = new DListNode(1);
        head.next = new DListNode(2);
        head.next.prev = head;
        head.next.next = new DListNode(4);
        head.next.next.prev = head.next;
        head.next.next.next = new DListNode(5);
        head.next.next.next.prev = head.next.next;
        head.next.next.next.next = new DListNode(6);
        head.next.next.next.next.prev = head.next.next.next;

        int targetSum = 7;
        findPair(head, targetSum);
    }
}
