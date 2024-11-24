package sheet.google.months_6._2;

//  https://leetcode.com/problems/stone-game-iii

import java.util.Arrays;

public class F18StoneGame3 {

    public static void main(String[] args) {
        F18StoneGame3 solution = new F18StoneGame3();

        // Test case 1
        int[] stoneValue1 = {1, 2, 3, 7};
        System.out.println(solution.stoneGameIII(stoneValue1)); // Output: "Bob"

        // Test case 2
        int[] stoneValue2 = {1, 2, 3, -9};
        System.out.println(solution.stoneGameIII(stoneValue2)); // Output: "Alice"

        // Test case 3
        int[] stoneValue3 = {1, 2, 3, 6};
        System.out.println(solution.stoneGameIII(stoneValue3)); // Output: "Tie"
    }

    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;

        // dp[i] represents the maximum score difference the current player can achieve starting at index i
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MIN_VALUE); // Initialize with a very small value
        dp[n] = 0; // Base case: no stones left

        // Iterate from the end of the array to the beginning
        for (int i = n - 1; i >= 0; i--) {
            int currentSum = 0;
            // Try taking 1, 2, or 3 stones
            for (int k = 0; k < 3 && i + k < n; k++) {
                currentSum += stoneValue[i + k];
                dp[i] = Math.max(dp[i], currentSum - dp[i + k + 1]);
            }
        }

        // Determine the result based on dp[0]
        if (dp[0] > 0) {
            return "Alice";
        } else if (dp[0] < 0) {
            return "Bob";
        } else {
            return "Tie";
        }
    }
}
