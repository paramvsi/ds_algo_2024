package sheet.google.months_6._2;

//  https://leetcode.com/problems/student-attendance-record-ii
public class F08StudentRecord2 {
    private static final int MOD = 1_000_000_007;

    public static void main(String[] args) {
        F08StudentRecord2 solution = new F08StudentRecord2();

        // Test cases
        System.out.println(solution.checkRecord(2)); // Output: 8
        System.out.println(solution.checkRecord(1)); // Output: 3
        System.out.println(solution.checkRecord(3)); // Output: 19
    }

    public int checkRecord(int n) {
        // dp[i][A][L]: number of valid records of length i with A 'A's and L consecutive 'L's
        int[][][] dp = new int[n + 1][2][3];

        // Base case: An empty record is valid
        dp[0][0][0] = 1;

        // Fill the dp table
        for (int i = 0; i < n; i++) {
            for (int A = 0; A <= 1; A++) {
                for (int L = 0; L <= 2; L++) {
                    // Add 'P': Reset L to 0
                    dp[i + 1][A][0] = (dp[i + 1][A][0] + dp[i][A][L]) % MOD;

                    // Add 'L': Increment L by 1 (only if L < 2)
                    if (L < 2) {
                        dp[i + 1][A][L + 1] = (dp[i + 1][A][L + 1] + dp[i][A][L]) % MOD;
                    }

                    // Add 'A': Increment A by 1 (only if A < 1)
                    if (A < 1) {
                        dp[i + 1][A + 1][0] = (dp[i + 1][A + 1][0] + dp[i][A][L]) % MOD;
                    }
                }
            }
        }

        // Sum all valid records of length n
        int result = 0;
        for (int A = 0; A <= 1; A++) {
            for (int L = 0; L <= 2; L++) {
                result = (result + dp[n][A][L]) % MOD;
            }
        }

        return result;
    }
}

