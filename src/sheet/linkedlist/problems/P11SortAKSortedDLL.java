package sheet.linkedlist.problems;

import java.util.Comparator;
import java.util.PriorityQueue;

public class P11SortAKSortedDLL {

    public static DListNode sortKSortedDoublyList(DListNode head, int k) {
        if (head == null) return null;

        // Priority queue to hold list nodes based on their values
        PriorityQueue<DListNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));

        DListNode node = head;
        DListNode newHead = null, last = null;

        // Fill the priority queue initially with the first k+1 elements
        for (int i = 0; node != null && i <= k; i++) {
            minHeap.add(node);
            node = node.next;
        }

        // Process the list
        while (!minHeap.isEmpty()) {
            DListNode smallest = minHeap.poll();

            if (newHead == null) {
                newHead = smallest;
                newHead.prev = null;
                last = newHead;
            } else {
                last.next = smallest;
                smallest.prev = last;
                last = smallest;
            }

            if (node != null) {
                minHeap.add(node);
                node = node.next;
            }
        }

        // Ensure the last node points to null
        if (last != null) last.next = null;

        return newHead;
    }

    public static void printList(DListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DListNode head = new DListNode(3);
        head.next = new DListNode(6);
        head.next.prev = head;
        head.next.next = new DListNode(2);
        head.next.next.prev = head.next;
        head.next.next.next = new DListNode(12);
        head.next.next.next.prev = head.next.next;
        head.next.next.next.next = new DListNode(10);
        head.next.next.next.next.prev = head.next.next.next;
        head.next.next.next.next.next = new DListNode(11);
        head.next.next.next.next.next.prev = head.next.next.next.next;

        System.out.println("Original list:");
        printList(head);

        head = sortKSortedDoublyList(head, 2);

        System.out.println("Sorted list:");
        printList(head);
    }
}
