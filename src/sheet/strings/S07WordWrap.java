package sheet.strings;


public class S07WordWrap {

    // Function to find the minimum cost of wrapping words
    public static int wrapWords(String[] words, int maxWidth) {
        int n = words.length;
        int[] dp = new int[n + 1];
        int[] spaceLeft = new int[n + 1]; // Extra spaces on each line starting from word i

        // Base case: No cost for the last word going to the end
        dp[n] = 0;

        // Calculate from the end to the start
        for (int i = n - 1; i >= 0; i--) {
            spaceLeft[i] = maxWidth - words[i].length();
            dp[i] = Integer.MAX_VALUE;
            for (int j = i + 1; j <= n; j++) {
                if (spaceLeft[i] < 0) {
                    break;
                }
                int cost = (j == n) ? 0 : (spaceLeft[i] * spaceLeft[i]); // No cost for the last line
                if (dp[j] != Integer.MAX_VALUE && (dp[i] > cost + dp[j])) {
                    dp[i] = cost + dp[j];
                }
                if (j < n) {
                    spaceLeft[i] -= (words[j].length() + 1); // Update space left including one space between words
                }
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;
        System.out.println("Minimum cost of word wrapping: " + wrapWords(words, maxWidth));
    }
}

