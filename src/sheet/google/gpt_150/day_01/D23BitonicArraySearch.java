package sheet.google.gpt_150.day_01;


public class D23BitonicArraySearch {

    public static int searchInBitonicArray(int[] arr, int target) {
        int peak = findPeak(arr);

        // Search in the increasing part
        int index = binarySearch(arr, target, 0, peak, true);
        if (index != -1) {
            return index;
        }

        // If not found, search in the decreasing part
        return binarySearch(arr, target, peak + 1, arr.length - 1, false);
    }

    // Helper function to find the peak element in the bitonic array
    private static int findPeak(int[] arr) {
        int left = 0, right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > arr[mid + 1]) {
                right = mid; // The peak is in the left part
            } else {
                left = mid + 1; // The peak is in the right part
            }
        }

        return left; // `left` is now at the peak element
    }

    // Helper function to perform binary search
    // `isAscending` indicates if the search should be in ascending or descending order
    private static int binarySearch(int[] arr, int target, int left, int right, boolean isAscending) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            }

            if (isAscending) {
                if (arr[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (arr[mid] < target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }

        return -1; // Target not found
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 8, 12, 4, 2};
        int target = 4;
        System.out.println("Index of target: " + searchInBitonicArray(arr, target)); // Output: 4

        int target2 = 6;
        System.out.println("Index of target: " + searchInBitonicArray(arr, target2)); // Output: -1
    }
}


