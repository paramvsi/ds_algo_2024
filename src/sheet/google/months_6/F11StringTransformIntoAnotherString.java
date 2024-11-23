package sheet.google.months_6;

//  https://leetcode.com/problems/string-transforms-into-another-string


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class F11StringTransformIntoAnotherString {
    public static void main(String[] args) {
        F11StringTransformIntoAnotherString solution = new F11StringTransformIntoAnotherString();

        // Test cases
        System.out.println(solution.canTransform("aabcc", "ccdee")); // true
        System.out.println(solution.canTransform("leetcode", "codeleet")); // false
    }

    public boolean canTransform(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false; // Length mismatch
        }

        Map<Character, Character> map = new HashMap<>();
        Set<Character> usedChars = new HashSet<>();

        for (int i = 0; i < str1.length(); i++) {
            char c1 = str1.charAt(i);
            char c2 = str2.charAt(i);

            if (map.containsKey(c1)) {
                // If c1 is already mapped, check if it maps correctly
                if (map.get(c1) != c2) {
                    return false;
                }
            } else {
                // If c1 is not mapped, map it to c2
                if (usedChars.contains(c2)) {
                    return false; // c2 is already mapped to another character
                }
                map.put(c1, c2);
                usedChars.add(c2);
            }
        }

        // If str2 uses all 26 characters, there may be a cycle
        return usedChars.size() < 26 || map.size() <= 26;
    }
}

