package sheet.searching_and_sorting;

import java.util.Arrays;

// To find the minimum number of swaps required to sort an array, you can use a modified version
// of the selection sort algorithm. Here's a Java implementation
public class S12MinSwapsToSortAnArray {

    public static int minSwaps(int[] arr) {
        int n = arr.length;
        int swaps = 0;

        // Create an array of pairs to store the element and its original index
        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; i++) {
            pairs[i] = new Pair(arr[i], i);
        }

        // Sort the array of pairs based on the element value
        Arrays.sort(pairs);

        // Initialize a boolean array to keep track of visited elements
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            // If the current element is already in its correct position or visited, skip it
            if (visited[i] || pairs[i].index == i) {
                continue;
            }

            int cycleSize = 0;
            int j = i;

            // Count the size of the cycle starting from the current element
            while (!visited[j]) {
                visited[j] = true;
                j = pairs[j].index;
                cycleSize++;
            }

            // Add the number of swaps required to move the elements within the cycle to their correct positions
            swaps += (cycleSize - 1);
        }

        return swaps;
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 1};
        System.out.println("Minimum swaps required: " + minSwaps(arr));
    }

    // Inner class to represent a pair of element and its index
    static class Pair implements Comparable<Pair> {
        int value;
        int index;

        Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }

        @Override
        public int compareTo(Pair other) {
            return Integer.compare(this.value, other.value);
        }
    }
}

