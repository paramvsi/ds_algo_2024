package sheet.google.practice.strings;


public class S07ValidPalindrome {
    public static boolean isPalindrome(String s) {
        // Convert to lower case and remove non-alphanumeric characters
        String cleaned = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();

        // Initialize pointers for the start and the end of the cleaned string
        int start = 0;
        int end = cleaned.length() - 1;

        // Use two pointers to check for palindrome
        while (start < end) {
            if (cleaned.charAt(start) != cleaned.charAt(end)) {
                return false; // If characters do not match, it's not a palindrome
            }
            start++; // Move start pointer forward
            end--;   // Move end pointer backward
        }

        return true; // If all characters match, it is a palindrome
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama"; // Example input
        System.out.println("Is palindrome: " + isPalindrome(s));
    }
}
