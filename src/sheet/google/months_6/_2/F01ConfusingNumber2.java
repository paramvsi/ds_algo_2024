package sheet.google.months_6._2;

import java.util.Map;

public class F01ConfusingNumber2 {
    private final Map<Integer, Integer> rotationMap = Map.of(
            0, 0,
            1, 1,
            6, 9,
            8, 8,
            9, 6
    );
    private int count = 0;

    public static void main(String[] args) {
        F01ConfusingNumber2 solution = new F01ConfusingNumber2();

        // Test cases
        System.out.println(solution.confusingNumberII(20)); // Output: 6
        System.out.println(solution.confusingNumberII(100)); // Output: 19
    }

    public int confusingNumberII(int n) {
        // Start backtracking
        backtrack(0, n);
        return count;
    }

    private void backtrack(long current, int n) {
        // Base case: If the current number exceeds n, stop
        if (current > n) return;

        // Check if the current number is confusing (skip 0)
        if (current > 0 && isConfusingNumber(current)) {
            count++;
        }

        // Recursively generate the next numbers
        for (int digit : rotationMap.keySet()) {
            long next = current * 10 + digit;
            if (next == 0) continue; // Skip leading zeros
            backtrack(next, n);
        }
    }

    private boolean isConfusingNumber(long num) {
        long original = num;
        long rotated = 0;

        // Generate the rotated number
        while (num > 0) {
            int digit = (int) (num % 10);
            rotated = rotated * 10 + rotationMap.get(digit);
            num /= 10;
        }

        return rotated != original;
    }
}

