package sheet.google.gpt_150.day_03;


import java.util.HashMap;
import java.util.Map;

public class D15FirstUniqueCharInAString {

    public static void main(String[] args) {
        D15FirstUniqueCharInAString solution = new D15FirstUniqueCharInAString();

        String s1 = "leetcode";
        System.out.println("First unique character index: " + solution.firstUniqChar(s1)); // Output: 0

        String s2 = "loveleetcode";
        System.out.println("First unique character index: " + solution.firstUniqChar(s2)); // Output: 2

        String s3 = "aabb";
        System.out.println("First unique character index: " + solution.firstUniqChar(s3)); // Output: -1
    }

    public int firstUniqChar(String s) {
        Map<Character, Integer> frequencyMap = new HashMap<>();

        // First pass: count the frequency of each character
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        // Second pass: find the first unique character
        for (int i = 0; i < s.length(); i++) {
            if (frequencyMap.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        // No unique character found
        return -1;
    }
}

