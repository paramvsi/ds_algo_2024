package sheet.google.practice.linked_list;

public class L05IntersectionOfTwoList {
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode a = headA, b = headB;

        // Continue until the two pointers either hit null or meet each other
        while (a != b) {
            // If reaching the end of one list, start at the beginning of the other
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }

        // Either both pointers are null (no intersection) or both point to the intersection node
        return a;
    }


    public static void main(String[] args) {
        // Example to create intersecting linked lists (for demonstration purposes)
        ListNode common = new ListNode(8, new ListNode(4, new ListNode(5)));

        ListNode headA = new ListNode(4, new ListNode(1, common));
        ListNode headB = new ListNode(5, new ListNode(6, new ListNode(1, common)));

        ListNode intersect = getIntersectionNode(headA, headB);
        if (intersect != null) {
            System.out.println("Intersected at node with value: " + intersect.val);
        } else {
            System.out.println("No intersection found.");
        }
    }
}

