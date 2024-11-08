package sheet.google.gpt_150.day_01;


import java.util.ArrayList;
import java.util.List;

public class D27RestoreIPAddress {
    public static List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();

        // Early return if the length of s is not feasible for an IP address
        if (s.length() < 4 || s.length() > 12) {
            return result;
        }

        backtrack(result, s, "", 0, 0);
        return result;
    }

    private static void backtrack(List<String> result, String s, String current, int start, int segment) {
        // Base case: If we have four segments and we've used all characters in s
        if (segment == 4 && start == s.length()) {
            result.add(current);
            return;
        }

        // If there are too many segments or not enough characters left, stop
        if (segment == 4 || start == s.length()) {
            return;
        }

        // Try segments of length 1, 2, and 3
        for (int length = 1; length <= 3; length++) {
            // If remaining characters are not enough for the remaining segments, break
            if (start + length > s.length()) break;

            String part = s.substring(start, start + length);

            // Check if the segment is valid
            if (isValidSegment(part)) {
                // Add the segment to current IP address string
                String next = segment == 0 ? part : current + "." + part;

                // Recurse with the next part of the string
                backtrack(result, s, next, start + length, segment + 1);
            }
        }
    }

    // Helper function to check if a segment is valid
    private static boolean isValidSegment(String part) {
        // Check if part is "0" or if it does not have leading zero and is <= 255
        if (part.length() > 1 && part.startsWith("0")) return false;
        int value = Integer.parseInt(part);
        return value >= 0 && value <= 255;
    }

    public static void main(String[] args) {
        String s1 = "25525511135";
        System.out.println("Valid IP addresses for " + s1 + ": " + restoreIpAddresses(s1));
        // Output: ["255.255.11.135", "255.255.111.35"]

        String s2 = "0000";
        System.out.println("Valid IP addresses for " + s2 + ": " + restoreIpAddresses(s2));
        // Output: ["0.0.0.0"]

        String s3 = "101023";
        System.out.println("Valid IP addresses for " + s3 + ": " + restoreIpAddresses(s3));
        // Output: ["1.0.10.23", "1.0.102.3", "10.1.0.23", "10.10.2.3", "101.0.2.3"]
    }
}

