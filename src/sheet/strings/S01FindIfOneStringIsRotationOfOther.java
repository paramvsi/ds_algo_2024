package sheet.strings;


public class S01FindIfOneStringIsRotationOfOther {
    public static boolean isRotation(String s1, String s2) {
        // Check if both strings are of equal length and not empty
        if (s1.length() != s2.length() || s1.isEmpty()) {
            return false;
        }
        String s1s1 = s1 + s1; // Concatenate s1 with itself
        return s1s1.contains(s2); // Check if s2 is a substring of the concatenated string
    }

    public static void main(String[] args) {
        String s1 = "waterbottle";
        String s2 = "erbottlewat";
        boolean result = isRotation(s1, s2);
        System.out.println("Is \"" + s2 + "\" a rotation of \"" + s1 + "\"? " + result);
    }
}
