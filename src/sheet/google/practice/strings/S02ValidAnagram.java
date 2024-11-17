package sheet.google.practice.strings;


public class S02ValidAnagram {
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false; // Quick check to save time if lengths differ

        int[] freq = new int[26];

        for (int c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        for (int c : t.toCharArray()) {
            freq[c - 'a']--;
            if (freq[c - 'a'] < 0) {
                return false; // Early exit if t has more of a char than s
            }
        }

        return true; // All characters matched correctly
    }


    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println("Is t an anagram of s? " + isAnagram(s, t));
    }
}

