package sheet.google.practice.arrays;

import java.util.HashSet;

public class A05ContainsDuplicate {
    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();

        for (int n : nums) {
            if (hashSet.contains(n)) {
                return true;  // Return true immediately if a duplicate is found
            }
            hashSet.add(n);  // Add the current number to the set
        }

        return false; // Return false if no duplicates are found
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1}; // Example input
        System.out.println("Contains duplicate: " + containsDuplicate(nums));
    }
}

