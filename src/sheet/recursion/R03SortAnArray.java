package sheet.recursion;

public class R03SortAnArray {
    // Function to sort array using QuickSort
    public static void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int partitionIndex = partition(arr, start, end); // Get the partition index
            quickSort(arr, start, partitionIndex - 1); // Sort the left subarray
            quickSort(arr, partitionIndex + 1, end); // Sort the right subarray
        }
    }

    // Function to partition the array
    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[end]; // Choose the last element as pivot
        int i = (start - 1); // Index of smaller element

        for (int j = start; j < end; j++) {
            // If current element is smaller than or equal to pivot
            if (arr[j] <= pivot) {
                i++;
                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap arr[i+1] and arr[end] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = temp;

        return i + 1;
    }

    // Main method to test the quickSort method
    public static void main(String[] args) {
        int[] array = {10, 7, 8, 9, 1, 5};
        quickSort(array, 0, array.length - 1);
        System.out.println("Sorted array: ");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}
