package sheet.google.gpt_150.day_01;


public class D25DecodeWays {
    public static int numDecodings(String s) {
        // Edge case: if the string starts with '0', it cannot be decoded
        if (s == null || s.isEmpty() || s.charAt(0) == '0') {
            return 0;
        }

        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1; // An empty string has one way to be decoded

        // Initialize the first character's decoding ways
        dp[1] = s.charAt(0) != '0' ? 1 : 0;

        for (int i = 2; i <= n; i++) {
            // Single digit decoding
            int oneDigit = Integer.parseInt(s.substring(i - 1, i));
            if (oneDigit >= 1 && oneDigit <= 9) {
                dp[i] += dp[i - 1];
            }

            // Two-digit decoding
            int twoDigit = Integer.parseInt(s.substring(i - 2, i));
            if (twoDigit >= 10 && twoDigit <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        String s1 = "12";
        System.out.println("Number of ways to decode \"" + s1 + "\": " + numDecodings(s1)); // Output: 2

        String s2 = "226";
        System.out.println("Number of ways to decode \"" + s2 + "\": " + numDecodings(s2)); // Output: 3

        String s3 = "0";
        System.out.println("Number of ways to decode \"" + s3 + "\": " + numDecodings(s3)); // Output: 0

        String s4 = "06";
        System.out.println("Number of ways to decode \"" + s4 + "\": " + numDecodings(s4)); // Output: 0
    }
}

