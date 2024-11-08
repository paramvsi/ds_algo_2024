package sheet.google.gpt_150.day_01;


public class D28MergeTwoSortedList {

    public static ListNode2 mergeTwoLists(ListNode2 list1, ListNode2 list2) {
        // Create a dummy node to simplify the merge process
        ListNode2 dummy = new ListNode2(0);
        ListNode2 current = dummy;

        // Traverse both lists and add the smaller node to the merged list
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        // Attach any remaining nodes in either list1 or list2
        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }

        // Return the merged list starting from dummy.next
        return dummy.next;
    }

    public static void main(String[] args) {
        // Example usage
        ListNode2 list1 = new ListNode2(1);
        list1.next = new ListNode2(2);
        list1.next.next = new ListNode2(4);

        ListNode2 list2 = new ListNode2(1);
        list2.next = new ListNode2(3);
        list2.next.next = new ListNode2(4);

        ListNode2 mergedHead = mergeTwoLists(list1, list2);

        // Print the merged list
        ListNode2 current = mergedHead;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        // Expected Output: 1 1 2 3 4 4
    }


}

class ListNode2 {
    int val;
    ListNode2 next;

    ListNode2(int x) {
        val = x;
    }
}
