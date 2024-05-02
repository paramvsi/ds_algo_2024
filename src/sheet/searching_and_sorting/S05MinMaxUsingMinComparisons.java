package sheet.searching_and_sorting;

public class S05MinMaxUsingMinComparisons {
    public static Pair getMinMax(int[] arr) {
        Pair minmax = new Pair();
        int i; // Index to keep track of current element

        // If array has even number of elements then initialize the first two elements as minimum and maximum
        if (arr.length % 2 == 0) {
            if (arr[0] > arr[1]) {
                minmax.max = arr[0];
                minmax.min = arr[1];
            } else {
                minmax.min = arr[0];
                minmax.max = arr[1];
            }
            i = 2; // Set i to the third element
        } else {
            minmax.min = minmax.max = arr[0]; // If odd number of elements, start with the first element
            i = 1; // Set i to the second element
        }

        // Traverse the array in pairs
        while (i < arr.length - 1) {
            if (arr[i] > arr[i + 1]) {
                minmax.max = Math.max(minmax.max, arr[i]);
                minmax.min = Math.min(minmax.min, arr[i + 1]);
            } else {
                minmax.max = Math.max(minmax.max, arr[i + 1]);
                minmax.min = Math.min(minmax.min, arr[i]);
            }
            i += 2; // Increase i by 2 as we are processing two elements at a time
        }

        return minmax;
    }

    public static void main(String[] args) {
        int[] arr = {1000, 11, 445, 1, 330, 3000};
        Pair minmax = getMinMax(arr);
        System.out.println("Minimum element is " + minmax.min);
        System.out.println("Maximum element is " + minmax.max);
    }

    static class Pair {
        int min;
        int max;
    }
}

