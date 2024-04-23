package sheet.strings;


// Check if String is valid shuffle of two strings or not.

public class S02IsValidShuffle {

    // Method to check if result is a valid shuffle of s1 and s2
    public static boolean isValidShuffle(String s1, String s2, String result) {
        // If the sum of lengths of s1 and s2 is not equal to the length of result, it can't be a valid shuffle
        if (s1.length() + s2.length() != result.length()) {
            return false;
        }

        int i = 0, j = 0, k = 0; // Pointers for s1, s2, and result

        // Traverse the result string
        while (k < result.length()) {
            // Check if next character of result matches with current character of s1
            if (i < s1.length() && result.charAt(k) == s1.charAt(i)) {
                i++;
            }
            // Check if next character of result matches with current character of s2
            else if (j < s2.length() && result.charAt(k) == s2.charAt(j)) {
                j++;
            }
            // If the character doesn't match with either s1 or s2, then it is not a valid shuffle
            else {
                return false;
            }
            // Move to the next character in the result
            k++;
        }

        // All characters in result must match the characters in s1 and s2 in the given order
        return true;
    }

    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "def";
        String result = "dabecf";
        if (isValidShuffle(s1, s2, result)) {
            System.out.println(result + " is a valid shuffle of " + s1 + " and " + s2);
        } else {
            System.out.println(result + " is not a valid shuffle of " + s1 + " and " + s2);
        }
    }
}

