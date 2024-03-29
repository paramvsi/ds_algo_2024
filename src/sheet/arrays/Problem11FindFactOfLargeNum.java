package sheet.arrays;

class Node {
    public int data;
    public Node prev;

    public Node(int n) {
        data = n;
        prev = null;
    }
}

public class Problem11FindFactOfLargeNum {
    public static void main(String[] args) {
        int num = 100;

        Node head = new Node(1);

        for (int i = 2; i <= num; i++)
            multiply(head, i);

        System.out.println("Factorial of 100 is");
        print(head);
    }

    public static void print(Node head) {
        if (head == null)
            return;
        print(head.prev);
        System.out.print(head.data); // Print linked list in reverse order
    }

    private static void multiply(Node head, int i) {
        Node temp = head;
        Node prevPtr = head; // Temp variable for keeping head
        int carry = 0;

        //* Perform operation until temp becomes null
        while (temp != null) {
            int prod = temp.data * i + carry;
            temp.data = prod % 10; //* Stores the last digit
            carry = prod / 10;
            prevPtr = temp; //* Change Links
            temp = temp.prev; //* Moving temp to next node
        }

        //* If carry is greater than 0 then we create new nodes
        //* to store remaining digits.
        while (carry != 0) {
            prevPtr.prev = new Node((carry % 10));
            carry /= 10;
            prevPtr = prevPtr.prev;
        }
    }

}
