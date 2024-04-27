package sheet.strings;


public class S26StringMatchingWhereOneStringContainsWildCardChars {
    public static void main(String[] args) {
        S26StringMatchingWhereOneStringContainsWildCardChars wm = new S26StringMatchingWhereOneStringContainsWildCardChars();
        System.out.println(wm.isMatch("abcdef", "a*ef")); // true
        System.out.println(wm.isMatch("abcdef", "a*d?")); // false
    }

    public boolean isMatch(String text, String pattern) {
        return isMatchHelper(text, pattern, 0, 0);
    }

    private boolean isMatchHelper(String text, String pattern, int tIndex, int pIndex) {
        // If both indices reach the end of text and pattern respectively
        if (pIndex == pattern.length()) {
            return tIndex == text.length();
        }

        if (pattern.charAt(pIndex) == '*') {
            // Check with no character match or one character match and recurse
            return (tIndex < text.length() && isMatchHelper(text, pattern, tIndex + 1, pIndex)) ||
                    isMatchHelper(text, pattern, tIndex, pIndex + 1);
        } else {
            // Match current character in text and pattern (or '?') and move to next
            return tIndex < text.length() &&
                    (pattern.charAt(pIndex) == text.charAt(tIndex) || pattern.charAt(pIndex) == '?') &&
                    isMatchHelper(text, pattern, tIndex + 1, pIndex + 1);
        }
    }
}

