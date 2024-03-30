package sheet.arrays;

import java.util.HashSet;

// Given an array of integers, find the length of the longest sub-sequence such that elements in
// the subsequence are consecutive integers,
// the consecutive numbers can be in any order.
public class Problem13LongestConsecutiveSubsequence {
    public static void main(String[] args) {
        int[] arr = {1, 9, 3, 10, 4, 20, 2};

        System.out.println("Length of longest consecutive subsequence is "+getLength(arr));
    }

    private static int getLength(int[] arr) {
        HashSet<Integer> S = new HashSet<>();
        int ans = 0;

        // Hash all the array elements
        for (int k : arr) S.add(k);

        // check each possible sequence from the start
        // then update optimal length
        for (int k : arr) {
            // if current element is the starting
            // element of a sequence
            if (!S.contains(k - 1)) {
                // Then check for next elements
                // in the sequence
                int j = k;
                while (S.contains(j))
                    j++;

                // update  optimal length if this
                // length is more
                if (ans < j - k)
                    ans = j - k;
            }
        }
        return ans;
    }
}
