package sheet.google.binary_search;

import java.util.Arrays;

public class BS02FindHowManyTimesArrayIsRotated {
    public static void main(String[] args) {
        int[] arr = {11, 12, 13, 14, 2, 3, 5, 6};

        System.out.println(findHowManyTimes(arr));

        System.out.println(findAnElementInSameArray(arr, 12));
    }

    private static int findAnElementInSameArray(int[] arr, int target) {
        int minElemIndex = findHowManyTimes(arr);


        return Math.max(
                Arrays.binarySearch(arr, 0, minElemIndex - 1, target),
                Arrays.binarySearch(arr, minElemIndex, arr.length - 1, target)
        );

    }

    // if we find the index of min element that is the count
    private static int findHowManyTimes(int[] arr) {
        int start = 0, end = arr.length - 1;

        // If the array is already sorted and not rotated
        if (arr[start] <= arr[end]) {
            return 0;
        }

        while (start <= end) {
            int mid = start + (end - start) / 2;

            // Check if the mid element is the minimum element
            if (mid > 0 && arr[mid] < arr[mid - 1]) {
                return mid;
            }
            if (mid < arr.length - 1 && arr[mid] > arr[mid + 1]) {
                return mid + 1;
            }

            // Adjust the search range based on the sorted part
            if (arr[mid] >= arr[start]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return 0; // Default case, should not reach here
    }
}
