package sheet.strings;


public class S28TransformUsingMinGivenOperation {

    public static int minTransformations(String s, String t) {
        if (s.length() != t.length()) {
            throw new IllegalArgumentException("Strings must be of the same length.");
        }

        int transformationsNeeded = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                transformationsNeeded++;
            }
        }
        return transformationsNeeded;
    }

    public static void main(String[] args) {
        String s = "abcde";
        String t = "abfge";
        System.out.println("Minimum transformations needed: " + minTransformations(s, t));
    }
}
