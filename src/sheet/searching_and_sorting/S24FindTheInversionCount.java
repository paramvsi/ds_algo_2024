package sheet.searching_and_sorting;

public class S24FindTheInversionCount {

    // Helper function to merge two halves and count inversions
    private static int mergeAndCount(int[] arr, int[] temp, int left, int mid, int right) {
        int i = left; // Initial index for left subarray
        int j = mid + 1; // Initial index for right subarray
        int k = left; // Initial index to be sorted
        int inv_count = 0;

        // Conditions are checked to ensure that i doesn't exceed mid and j doesn't exceed right
        while ((i <= mid) && (j <= right)) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                inv_count += (mid + 1) - i; // The number of inversions
            }
        }

        // Copy the remaining elements of left subarray, if any
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        // Copy the remaining elements of right subarray, if any
        while (j <= right) {
            temp[k++] = arr[j++];
        }

        // Copy the sorted subarray into Original array
        for (i = left; i <= right; i++) {
            arr[i] = temp[i];
        }

        return inv_count;
    }

    // Function to use mergeSort and count inversions
    private static int mergeSortAndCount(int[] arr, int[] temp, int left, int right) {
        int mid, inv_count = 0;
        if (right > left) {
            mid = (right + left) / 2;

            inv_count += mergeSortAndCount(arr, temp, left, mid);
            inv_count += mergeSortAndCount(arr, temp, mid + 1, right);

            inv_count += mergeAndCount(arr, temp, left, mid, right);
        }
        return inv_count;
    }

    public static void main(String[] args) {
        int[] arr = {1, 20, 6, 4, 5};
        int[] temp = new int[arr.length];
        System.out.println("Number of inversions are: " + mergeSortAndCount(arr, temp, 0, arr.length - 1));
    }
}
