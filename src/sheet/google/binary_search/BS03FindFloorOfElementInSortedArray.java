package sheet.google.binary_search;

public class BS03FindFloorOfElementInSortedArray {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 5, 7, 8, 10};
        int element = 6;

        System.out.println(findFloor(arr, element));
        System.out.println(findCeiling(arr, element));
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
