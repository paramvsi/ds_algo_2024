package sheet.searching_and_sorting;

public class S25ImplementMergeSortInPlace {

    // Main function that sorts arr[l..r] using temp[]
    static void mergeSort(int[] arr, int[] temp, int left, int right) {
        if (left < right) {
            // Find the middle point
            int mid = left + (right - left) / 2;

            // Sort first and second halves
            mergeSort(arr, temp, left, mid);
            mergeSort(arr, temp, mid + 1, right);

            // Merge the sorted halves
            merge(arr, temp, left, mid, right);
        }
    }

    // Merges two subarrays of arr[]
    static void merge(int[] arr, int[] temp, int left, int mid, int right) {
        // Copy data to temp arrays
        if (right + 1 - left >= 0) System.arraycopy(arr, left, temp, left, right + 1 - left);

        int i = left; // Initial index for left subarray
        int j = mid + 1; // Initial index for right subarray
        int k = left; // Initial index to be sorted

        // Merge temp arrays back into arr[l..r]
        while (i <= mid && j <= right) {
            if (temp[i] <= temp[j]) {
                arr[k] = temp[i];
                i++;
            } else {
                arr[k] = temp[j];
                j++;
            }
            k++;
        }

        // Copy the remaining elements of left subarray, if any
        while (i <= mid) {
            arr[k] = temp[i];
            i++;
            k++;
        }

        // No need to copy the right subarray because they are already in place
    }

    // Utility function to print the array
    static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Driver method
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        System.out.println("Given Array");
        printArray(arr);

        int[] temp = new int[arr.length]; // Create a temporary array
        mergeSort(arr, temp, 0, arr.length - 1);

        System.out.println("\nSorted array");
        printArray(arr);
    }
}

