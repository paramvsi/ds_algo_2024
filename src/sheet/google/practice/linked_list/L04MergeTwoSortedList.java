package sheet.google.practice.linked_list;


public class L04MergeTwoSortedList {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1); // Create a dummy node to form the base of the new list
        ListNode tail = dummy; // This will be the end of the new list where new nodes are added

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next; // Move the tail forward
        }

        // Exactly one of list1 and list2 can be non-null at this point, so connect
        // the non-null list to the end of the merged list.
        tail.next = (list1 != null) ? list1 : list2;

        return dummy.next; // The dummy node's next pointer points to the head of the merged list
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        ListNode mergedList = mergeTwoLists(list1, list2);
        System.out.print("Merged List: ");
        while (mergedList != null) {
            System.out.print(mergedList.val + " -> ");
            mergedList = mergedList.next;
        }
        System.out.println("null");
    }
}

