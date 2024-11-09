package sheet.google.gpt_150.day_02;


import java.util.PriorityQueue;


public class D15MergeKSortedList {
    public static void main(String[] args) {
        // Example lists
        ListNode[] lists = new ListNode[3];
        lists[0] = new ListNode(1);
        lists[0].next = new ListNode(4);
        lists[0].next.next = new ListNode(5);

        lists[1] = new ListNode(1);
        lists[1].next = new ListNode(3);
        lists[1].next.next = new ListNode(4);

        lists[2] = new ListNode(2);
        lists[2].next = new ListNode(6);

        D15MergeKSortedList solution = new D15MergeKSortedList();
        ListNode mergedHead = solution.mergeKLists(lists);

        // Print merged list
        ListNode current = mergedHead;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        // Expected output: 1 1 2 3 4 4 5 6
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        // Min-heap to keep track of the smallest element among the heads of the lists
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        // Add the head of each list to the min-heap
        for (ListNode head : lists) {
            if (head != null) {
                minHeap.offer(head);
            }
        }

        // Dummy node to simplify the result list construction
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // Extract the smallest node from the heap and add it to the result list
        while (!minHeap.isEmpty()) {
            ListNode smallest = minHeap.poll();
            current.next = smallest;
            current = current.next;

            // If there’s a next node in the extracted list, add it to the heap
            if (smallest.next != null) {
                minHeap.offer(smallest.next);
            }
        }

        return dummy.next;
    }
}

