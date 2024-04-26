package sheet.strings;

import java.util.HashMap;
import java.util.Map;

public class S25SmallestWindowContainingAllCharsOfAnotherString {

    public static String minWindow(String s, String t) {
        if (s.isEmpty() || t.isEmpty()) {
            return "";
        }

        // Dictionary to keep a count of all the unique characters in t
        Map<Character, Integer> dictT = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            dictT.put(c, dictT.getOrDefault(c, 0) + 1);
        }

        // Number of unique characters in t, which need to be present in the desired window
        int required = dictT.size();

        // Left and Right pointer
        int l = 0, r = 0;

        // Formed is used to keep track of how many unique characters in t are present in the current window in its desired frequency
        int formed = 0;

        // Dictionary to keep a count of all the unique characters in the current window
        Map<Character, Integer> windowCounts = new HashMap<>();

        // ans list of the form (window length, left, right)
        int[] ans = {-1, 0, 0};

        while (r < s.length()) {
            // Add one character from the right to the window
            char c = s.charAt(r);
            int count = windowCounts.getOrDefault(c, 0);
            windowCounts.put(c, count + 1);

            // If the frequency of the current character added equals to the desired count in t then increment the formed count
            if (dictT.containsKey(c) && windowCounts.get(c).intValue() == dictT.get(c).intValue()) {
                formed++;
            }

            // Try and contract the window till the point it ceases to be 'desirable'
            while (l <= r && formed == required) {
                c = s.charAt(l);
                // Save the smallest window until now
                if (ans[0] == -1 || r - l + 1 < ans[0]) {
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r;
                }

                // The character at the position pointed by the `Left` pointer is no longer a part of the window
                windowCounts.put(c, windowCounts.get(c) - 1);
                if (dictT.containsKey(c) && windowCounts.get(c) < dictT.get(c)) {
                    formed--;
                }

                // Move the left pointer ahead, this would help to look for a new window
                l++;
            }

            // Keep expanding the window once we are done contracting
            r++;
        }

        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println("Smallest window containing all characters: " + minWindow(s, t));
    }
}

