package sheet.google.months_6;

//  https://leetcode.com/problems/divide-array-in-sets-of-k-consecutive-numbers

import java.util.Map;
import java.util.TreeMap;

public class F14DivideArrayIntoKConsecutiveNumbers {
    public static void main(String[] args) {
        F14DivideArrayIntoKConsecutiveNumbers solution = new F14DivideArrayIntoKConsecutiveNumbers();

        // Test cases
        System.out.println(solution.isPossibleDivide(new int[]{1, 2, 3, 3, 4, 4, 5, 6}, 4)); // Output: true
        System.out.println(solution.isPossibleDivide(new int[]{3, 3, 2, 2, 1, 1}, 3)); // Output: true
        System.out.println(solution.isPossibleDivide(new int[]{1, 2, 3, 4}, 3)); // Output: false
    }

    public boolean isPossibleDivide(int[] nums, int k) {
        if (nums.length % k != 0) {
            return false; // Array size must be a multiple of k
        }

        // Frequency map
        Map<Integer, Integer> freqMap = new TreeMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Iterate through the numbers in sorted order
        for (int num : freqMap.keySet()) {
            int count = freqMap.get(num);
            if (count > 0) { // Form groups starting from 'num'
                for (int i = 0; i < k; i++) {
                    int nextNum = num + i;
                    if (freqMap.getOrDefault(nextNum, 0) < count) {
                        return false; // Not enough numbers to form the group
                    }
                    freqMap.put(nextNum, freqMap.get(nextNum) - count);
                }
            }
        }

        return true; // Successfully divided into groups
    }
}

