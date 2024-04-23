package sheet.strings;

public class S09KMPAlgo {

    // Function to create the partial match table (prefix table)
    private static int[] computeKMPTable(String pattern) {
        int[] lps = new int[pattern.length()];
        int index = 0; // length of the previous longest prefix suffix
        for (int i = 1; i < pattern.length(); ) {
            if (pattern.charAt(i) == pattern.charAt(index)) {
                lps[i] = index + 1;
                index++;
                i++;
            } else {
                if (index != 0) {
                    index = lps[index - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    // KMP Search Algorithm
    public static void KMPSearch(String text, String pattern) {
        int[] lps = computeKMPTable(pattern);
        int i = 0; // index for text
        int j = 0; // index for pattern
        while (i < text.length()) {
            if (pattern.charAt(j) == text.charAt(i)) {
                i++;
                j++;
            }
            if (j == pattern.length()) {
                System.out.println("Found pattern at index " + (i - j));
                j = lps[j - 1];
            } else if (i < text.length() && pattern.charAt(j) != text.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i = i + 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        String text = "ABABDABACDABABCABAB";
        String pattern = "ABABCABAB";
        KMPSearch(text, pattern);
    }
}
