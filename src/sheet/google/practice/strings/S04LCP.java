package sheet.google.practice.strings;


public class S04LCP {
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) { // Check if current prefix is a starting substring of strs[i]
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return ""; // If no common prefix, return empty string
            }
        }

        return prefix; // Return the longest common prefix
    }


    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"}; // Example input
        System.out.println("Longest common prefix: " + longestCommonPrefix(strs));
    }
}

