package sheet.arrays;

import java.util.HashSet;
import java.util.Set;

// Find whether an array is subset of another array
public class Problem15FindIfAIsSubsetOfB {
    public static void main(String[] args) {
        int[] arr1 = {11, 1, 13, 21, 3, 7};
        int[] arr2 = {11, 3, 7, 1};

        System.out.println("Arr 2 is subset of Arr 1? : "+checkIfSubset(arr1, arr2));
    }

    private static boolean checkIfSubset(int[] arr1, int[] arr2) {

        Set<Integer> s = new HashSet<>();
        for (int j : arr1) {
            s.add(j);
        }
        int p = s.size();
        for (int j : arr2) {
            s.add(j);
        }

        return s.size() == p;
    }


}
