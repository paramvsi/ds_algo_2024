package sheet.strings;

import java.util.HashMap;
import java.util.Map;

public class S29CheckIfTwoStringAreIsomorphic {

    public static boolean areIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> sToTMapping = new HashMap<>();
        Map<Character, Character> tToSMapping = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            if (sToTMapping.containsKey(sChar)) {
                if (sToTMapping.get(sChar) != tChar) {
                    return false; // Conflicting mapping
                }
            } else {
                sToTMapping.put(sChar, tChar);
            }

            if (tToSMapping.containsKey(tChar)) {
                if (tToSMapping.get(tChar) != sChar) {
                    return false; // Conflicting reverse mapping
                }
            } else {
                tToSMapping.put(tChar, sChar);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "egg";
        String t = "add";
        System.out.println("Are strings \"" + s + "\" and \"" + t + "\" isomorphic? " + areIsomorphic(s, t));

        String s2 = "foo";
        String t2 = "bar";
        System.out.println("Are strings \"" + s2 + "\" and \"" + t2 + "\" isomorphic? " + areIsomorphic(s2, t2));
    }
}

