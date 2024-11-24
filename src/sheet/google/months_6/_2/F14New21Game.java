package sheet.google.months_6._2;


public class F14New21Game {

    public static void main(String[] args) {
        F14New21Game solution = new F14New21Game();

        // Test cases
        System.out.println(solution.new21Game(10, 1, 10)); // Output: 1.0
        System.out.println(solution.new21Game(6, 1, 10));  // Output: 0.6
        System.out.println(solution.new21Game(21, 17, 10)); // Output: 0.73278
    }

    public double new21Game(int n, int k, int maxPts) {
        if (k == 0 || n >= k + maxPts) {
            return 1.0; // If Alice can stop before reaching k or the range exceeds n, she always wins.
        }

        double[] dp = new double[n + 1];
        dp[0] = 1.0;

        double windowSum = 1.0; // Running sum of the last maxPts probabilities
        double result = 0.0;

        for (int i = 1; i <= n; i++) {
            dp[i] = windowSum / maxPts;

            // If i is a valid stopping point (>= k), add to result
            if (i >= k) {
                result += dp[i];
            }

            // Update the sliding window
            if (i < k) {
                windowSum += dp[i];
            }
            if (i - maxPts >= 0) {
                windowSum -= dp[i - maxPts];
            }
        }

        return result;
    }
}

