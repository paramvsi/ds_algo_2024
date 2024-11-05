package sheet.google.binary_search;

public class BS05FindMinDifferenceElementInASortedArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 8, 9, 10, 11, 12};
        int key = 5;

        System.out.println(findMinDifferenceElementInSortedArray(arr, key));
    }

    public static int findMinDifferenceElementInSortedArray(int[] arr, int key) {
        int floor = findFloor(arr, key);
        int ceil = findCeiling(arr, key);

        return Math.min(key - floor, ceil - key);
    }

    public static int findFloor(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        int floorIndex = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return arr[mid]; // Exact match, so it's the floor itself
            } else if (arr[mid] < target) {
                floorIndex = mid; // Potential floor, look on the right side for a closer match
                start = mid + 1;
            } else {
                end = mid - 1; // Look on the left side
            }
        }

        return floorIndex == -1 ? -1 : arr[floorIndex]; // Return floor value or -1 if no floor found
    }

    public static int findCeiling(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        int ceilingIndex = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return arr[mid]; // Exact match, so it's the ceiling itself
            } else if (arr[mid] < target) {
                start = mid + 1; // Move right to find a larger element
            } else {
                ceilingIndex = mid; // Potential ceiling, look on the left for a closer match
                end = mid - 1;
            }
        }

        return ceilingIndex == -1 ? -1 : arr[ceilingIndex]; // Return ceiling value or -1 if no ceiling found
    }
}
