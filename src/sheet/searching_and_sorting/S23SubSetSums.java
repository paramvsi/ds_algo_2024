package sheet.searching_and_sorting;

import java.util.ArrayList;
import java.util.List;

public class S23SubSetSums {

    public static void findAllSubsetSums(int[] arr, int index, int currentSum, List<Integer> sums) {
        if (index == arr.length) {
            // When we've considered all elements, add the current sum to the list
            sums.add(currentSum);
            return;
        }
        // Include the current element in the subset
        findAllSubsetSums(arr, index + 1, currentSum + arr[index], sums);
        // Exclude the current element from the subset
        findAllSubsetSums(arr, index + 1, currentSum, sums);
    }

    public static List<Integer> getSubsetSums(int[] arr) {
        List<Integer> sums = new ArrayList<>();
        findAllSubsetSums(arr, 0, 0, sums);
        return sums;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        List<Integer> result = getSubsetSums(arr);
        System.out.println("Subset sums are: " + result);
    }
}

