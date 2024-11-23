package sheet.google.months_6;

//  https://leetcode.com/problems/minimum-window-subsequence
public class F06MinWindowSubsequence {
    public static void main(String[] args) {
        F06MinWindowSubsequence solution = new F06MinWindowSubsequence();

        String S = "abcdebdde";
        String T = "bde";
        System.out.println(solution.minWindow(S, T)); // Output: "bcde"
    }

    public String minWindow(String S, String T) {
        int minLength = Integer.MAX_VALUE; // Length of the smallest window
        int startIndex = -1; // Starting index of the smallest window

        int sLen = S.length(), tLen = T.length();
        int sIndex = 0, tIndex = 0;

        while (sIndex < sLen) {
            // Forward pass: Find the end of a matching window
            if (S.charAt(sIndex) == T.charAt(tIndex)) {
                tIndex++;
                if (tIndex == tLen) { // T is fully matched
                    // Backward pass: Minimize the window
                    int end = sIndex;
                    tIndex--; // Move back to the last character of T
                    while (tIndex >= 0) {
                        if (S.charAt(sIndex) == T.charAt(tIndex)) {
                            tIndex--;
                        }
                        sIndex--;
                    }
                    sIndex++; // Move to the first character of the valid window

                    // Update the minimum window
                    if (end - sIndex + 1 < minLength) {
                        minLength = end - sIndex + 1;
                        startIndex = sIndex;
                    }

                    // Reset tIndex for the next match
                    tIndex = 0;
                }
            }
            sIndex++;
        }

        return startIndex == -1 ? "" : S.substring(startIndex, startIndex + minLength);
    }
}

