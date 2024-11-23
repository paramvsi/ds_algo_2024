package sheet.google.months_6;

//  https://leetcode.com/problems/expressive-words
public class F02ExpressiveWords {
    public static void main(String[] args) {
        F02ExpressiveWords solution = new F02ExpressiveWords();
        String S = "heeellooo";
        String[] words = {"hello", "hi", "helo"};
        System.out.println(solution.expressiveWords(S, words)); // Output: 1
    }

    public int expressiveWords(String S, String[] words) {
        int count = 0;

        for (String word : words) {
            if (isStretchy(S, word)) {
                count++;
            }
        }

        return count;
    }

    private boolean isStretchy(String S, String word) {
        int i = 0, j = 0;

        while (i < S.length() && j < word.length()) {
            if (S.charAt(i) != word.charAt(j)) {
                return false; // Mismatched characters
            }

            // Count consecutive characters in S
            int lenS = getRepeatedLength(S, i);
            // Count consecutive characters in word
            int lenW = getRepeatedLength(word, j);

            // Stretchy conditions
            if (lenS < lenW || (lenS < 3 && lenS != lenW)) {
                return false;
            }

            // Move pointers by the length of the groups
            i += lenS;
            j += lenW;
        }

        // Both strings must be fully matched
        return i == S.length() && j == word.length();
    }

    private int getRepeatedLength(String str, int index) {
        int start = index;
        while (index < str.length() && str.charAt(index) == str.charAt(start)) {
            index++;
        }
        return index - start;
    }
}
