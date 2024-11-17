package sheet.google.practice.strings;


public class S03PalindromicSubstrings {
    public static int countSubstrings(String s) {
        // Implement your logic here
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            count += expandAroundCenter(s, i, i);

            count += expandAroundCenter(s, i, i + 1);
        }

        return count; // Placeholder for the count of palindromic substrings
    }

    public static void main(String[] args) {
        String s = "abc"; // Example input
        System.out.println("Number of palindromic substrings: " + countSubstrings(s));
    }

    private static int expandAroundCenter(String s, int i, int j) {

        int count = 0;

        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            count++;
            i--;
            j++;
        }

        return count;
    }
}

