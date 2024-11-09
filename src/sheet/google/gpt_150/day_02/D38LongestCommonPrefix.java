package sheet.google.gpt_150.day_02;


public class D38LongestCommonPrefix {

    public static void main(String[] args) {
        D38LongestCommonPrefix solution = new D38LongestCommonPrefix();

        String[] strs1 = {"flower", "flow", "flight"};
        System.out.println("Longest common prefix: " + solution.longestCommonPrefix(strs1)); // Output: "fl"

        String[] strs2 = {"dog", "racecar", "car"};
        System.out.println("Longest common prefix: " + solution.longestCommonPrefix(strs2)); // Output: ""
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        // Take the first string as a starting reference for the prefix
        String prefix = strs[0];

        // Check each string in the array
        for (int i = 1; i < strs.length; i++) {
            // Reduce the prefix character by character until it matches the beginning of strs[i]
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }

        return prefix;
    }
}

