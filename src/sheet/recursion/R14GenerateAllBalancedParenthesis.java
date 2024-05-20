package sheet.recursion;

import java.util.ArrayList;
import java.util.List;

public class R14GenerateAllBalancedParenthesis {

    // Function to generate all balanced parentheses
    public static List<String> generateParentheses(int n) {
        List<String> result = new ArrayList<>();
        generateAllCombinations(result, "", 0, 0, n);
        return result;
    }

    // Utility function for recursive generation
    private static void generateAllCombinations(List<String> result, String current, int open, int close, int max) {
        // If the current string is a valid combination, add it to the result list
        if (current.length() == max * 2) {
            result.add(current);
            return;
        }

        // If we can add an open parenthesis, do so
        if (open < max) {
            generateAllCombinations(result, current + "(", open + 1, close, max);
        }

        // If we can add a close parenthesis, do so
        if (close < open) {
            generateAllCombinations(result, current + ")", open, close + 1, max);
        }
    }

    public static void main(String[] args) {
        int n = 3; // Number of pairs of parentheses
        List<String> balancedParentheses = generateParentheses(n);
        for (String s : balancedParentheses) {
            System.out.println(s);
        }
    }
}
