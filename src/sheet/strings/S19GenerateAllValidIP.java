package sheet.strings;

import java.util.ArrayList;
import java.util.List;

public class S19GenerateAllValidIP {

    public static List<String> restoreIpAddresses(String s) {
        List<String> validIPs = new ArrayList<>();
        int n = s.length();

        // The first loop for the first part of IP
        for (int i = 1; i < 4 && i < n - 2; i++) {
            // The second loop for the second part of IP
            for (int j = i + 1; j < i + 4 && j < n - 1; j++) {
                // The third loop for the third part of IP
                for (int k = j + 1; k < j + 4 && k < n; k++) {
                    // The fourth part of IP
                    String part1 = s.substring(0, i);
                    String part2 = s.substring(i, j);
                    String part3 = s.substring(j, k);
                    String part4 = s.substring(k);
                    // Check if all parts are valid
                    if (isValid(part1) && isValid(part2) && isValid(part3) && isValid(part4)) {
                        validIPs.add(part1 + "." + part2 + "." + part3 + "." + part4);
                    }
                }
            }
        }
        return validIPs;
    }

    // Helper function to check if a part is a valid IP segment
    private static boolean isValid(String s) {
        return s.length() <= 3 && !s.isEmpty() && (s.charAt(0) != '0' || s.length() == 1) && Integer.parseInt(s) <= 255;
    }

    public static void main(String[] args) {
        String input = "25525511135";
        List<String> ipAddresses = restoreIpAddresses(input);
        System.out.println("Valid IP addresses:");
        for (String ip : ipAddresses) {
            System.out.println(ip);
        }
    }
}

