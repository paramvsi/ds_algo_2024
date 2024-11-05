package sheet.google.binary_search;

public class BS01CountOfElementInSortedArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 10, 10, 10, 10, 12, 13, 15, 16};
        int target = 10;

        System.out.println("Count:: " + findCount(arr, target));
    }

    private static int findCount(int[] arr, int target) {

        int firstOccurrence = findFirstOccurrence(arr, target);
        int lastOccurrence = findLastOccurrence(arr, target);

        return lastOccurrence - firstOccurrence + 1;
    }

    private static int findLastOccurrence(int[] arr, int target) {
        int res = -1;

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                res = mid;
                start = mid + 1;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return res;

    }

    private static int findFirstOccurrence(int[] arr, int target) {
        int res = -1;

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                res = mid;
                end = mid - 1;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return res;

    }
}
