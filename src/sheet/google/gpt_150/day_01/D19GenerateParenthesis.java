package sheet.google.gpt_150.day_01;

import java.util.ArrayList;
import java.util.List;

public class D19GenerateParenthesis {
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }

    private static void backtrack(List<String> result, String current, int open, int close, int max) {
        // Base condition: when the current string has reached the maximum length
        if (current.length() == max * 2) {
            result.add(current);
            return;
        }

        // Add an open parenthesis if the count of open is less than max
        if (open < max) {
            backtrack(result, current + "(", open + 1, close, max);
        }

        // Add a close parenthesis if the count of close is less than open
        if (close < open) {
            backtrack(result, current + ")", open, close + 1, max);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println("All combinations of well-formed parentheses for n = " + n + ":");
        System.out.println(generateParenthesis(n)); // Output: ["((()))","(()())","(())()","()(())","()()()"]
    }
}

