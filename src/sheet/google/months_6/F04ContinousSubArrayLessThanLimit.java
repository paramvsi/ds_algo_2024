package sheet.google.months_6;

//  https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit


import java.util.Deque;
import java.util.LinkedList;

public class F04ContinousSubArrayLessThanLimit {
    public static void main(String[] args) {
        F04ContinousSubArrayLessThanLimit solution = new F04ContinousSubArrayLessThanLimit();
        int[] nums = {8, 2, 4, 7};
        int limit = 4;
        System.out.println(solution.longestSubarray(nums, limit)); // Output: 2
    }

    public int longestSubarray(int[] nums, int limit) {
        // Deques to maintain max and min in the current window
        Deque<Integer> maxDeque = new LinkedList<>();
        Deque<Integer> minDeque = new LinkedList<>();

        int l = 0, maxLength = 0;

        // Iterate through the array with the right pointer
        for (int r = 0; r < nums.length; r++) {
            // Update maxDeque and minDeque
            while (!maxDeque.isEmpty() && maxDeque.peekLast() < nums[r]) {
                maxDeque.pollLast();
            }
            maxDeque.addLast(nums[r]);

            while (!minDeque.isEmpty() && minDeque.peekLast() > nums[r]) {
                minDeque.pollLast();
            }
            minDeque.addLast(nums[r]);

            // Check if the current window is valid
            while (maxDeque.peekFirst() - minDeque.peekFirst() > limit) {
                // Shrink the window from the left
                if (maxDeque.peekFirst() == nums[l]) {
                    maxDeque.pollFirst();
                }
                if (minDeque.peekFirst() == nums[l]) {
                    minDeque.pollFirst();
                }
                l++; // Move the left pointer
            }

            // Update the maximum length of the valid window
            maxLength = Math.max(maxLength, r - l + 1);
        }

        return maxLength;
    }
}

