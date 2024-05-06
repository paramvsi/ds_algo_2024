package sheet.searching_and_sorting;


import java.util.*;

public class S11PrintAllSubArrayWith0Sum {

    public static void printAllSubArrays(int[] arr) {
        // Create a hashmap to store the prefix sum and its index
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == 0) {
                // If the current prefix sum is 0, it means the subArray from the beginning to the current index has a sum of 0
                result.add(Arrays.asList(0, i));
            }
            if (map.containsKey(sum)) {
                // If the same prefix sum is found again, it means the subArray between the previous occurrence and the current index has a sum of 0
                List<Integer> list = map.get(sum);
                for (int index : list) {
                    result.add(Arrays.asList(index + 1, i));
                }
            }
            // Update the prefix sum and its corresponding index in the map
            if (!map.containsKey(sum)) {
                map.put(sum, new ArrayList<>());
            }
            map.get(sum).add(i);
        }

        // Print all subArrays with a sum of 0
        for (List<Integer> subArray : result) {
            System.out.println("subArray with sum 0 found from index " + subArray.get(0) + " to " + subArray.get(1));
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, -3, 1, 6, -3, -7, 8};
        printAllSubArrays(arr);
    }
}

