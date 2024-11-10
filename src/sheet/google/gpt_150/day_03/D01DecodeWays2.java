package sheet.google.gpt_150.day_03;


public class D01DecodeWays2 {

    private static final int MOD = 1000000007;

    public static void main(String[] args) {
        D01DecodeWays2 solution = new D01DecodeWays2();

        System.out.println(solution.numDecodings("*")); // Output: 9
        System.out.println(solution.numDecodings("1*")); // Output: 18
        System.out.println(solution.numDecodings("2*")); // Output: 15
    }

    public int numDecodings(String s) {
        int n = s.length();
        long[] dp = new long[n + 1];
        dp[0] = 1; // Base case: one way to decode an empty string

        // Single character decoding for the first character
        dp[1] = s.charAt(0) == '*' ? 9 : (s.charAt(0) != '0' ? 1 : 0);

        for (int i = 2; i <= n; i++) {
            char current = s.charAt(i - 1);
            char previous = s.charAt(i - 2);

            // Single character decoding
            if (current == '*') {
                dp[i] = (dp[i] + 9 * dp[i - 1]) % MOD;
            } else if (current != '0') {
                dp[i] = (dp[i] + dp[i - 1]) % MOD;
            }

            // Two-character decoding
            if (previous == '*') {
                if (current == '*') {
                    dp[i] = (dp[i] + 15 * dp[i - 2]) % MOD; // "**" can form 11-19 and 21-26
                } else if (current <= '6') {
                    dp[i] = (dp[i] + 2 * dp[i - 2]) % MOD; // "*1"-"*6" -> 11-16 and 21-26
                } else {
                    dp[i] = (dp[i] + dp[i - 2]) % MOD; // "*7"-"*9" -> 17-19 only
                }
            } else if (previous == '1') {
                if (current == '*') {
                    dp[i] = (dp[i] + 9 * dp[i - 2]) % MOD; // "1*" -> 11-19
                } else {
                    dp[i] = (dp[i] + dp[i - 2]) % MOD; // "1X" -> valid two-character decoding
                }
            } else if (previous == '2') {
                if (current == '*') {
                    dp[i] = (dp[i] + 6 * dp[i - 2]) % MOD; // "2*" -> 21-26
                } else if (current <= '6') {
                    dp[i] = (dp[i] + dp[i - 2]) % MOD; // "2X" where X <= 6 -> valid two-character decoding
                }
            }
        }

        return (int) dp[n];
    }
}

