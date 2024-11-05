package sheet.google.heap;


import java.util.PriorityQueue;

public class H03SortKSortedArray {

    public static void main(String[] args) {
        H03SortKSortedArray sorter = new H03SortKSortedArray();
        int[] arr = {6, 5, 3, 2, 8, 10, 9};
        int k = 3;

        sorter.sortKSortedArray(arr, k);

        System.out.print("Sorted array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public void sortKSortedArray(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        int index = 0;

        // Add first k+1 elements to the heap
        for (int i = 0; i <= k && i < arr.length; i++) {
            minHeap.offer(arr[i]);
        }

        // For each remaining element, add it to the heap and extract the smallest element
        for (int i = k + 1; i < arr.length; i++) {
            arr[index++] = minHeap.poll(); // Place the minimum element in its correct sorted position
            minHeap.offer(arr[i]);
        }

        // Extract remaining elements from the heap
        while (!minHeap.isEmpty()) {
            arr[index++] = minHeap.poll();
        }
    }
}

