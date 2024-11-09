package sheet.google.gpt_150.day_03;


import java.util.*;

public class D09RemoveInvalidParenthesis {

    public static void main(String[] args) {
        D09RemoveInvalidParenthesis solution = new D09RemoveInvalidParenthesis();

        String s1 = "()())()";
        System.out.println("Valid combinations for '" + s1 + "': " + solution.removeInvalidParentheses(s1));
        // Expected Output: ["(())()", "()()()"]

        String s2 = "(a)())()";
        System.out.println("Valid combinations for '" + s2 + "': " + solution.removeInvalidParentheses(s2));
        // Expected Output: ["(a())()", "(a)()()"]
    }

    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        if (s == null) return result;

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.add(s);
        visited.add(s);
        boolean foundValid = false;

        while (!queue.isEmpty()) {
            String current = queue.poll();

            // If current string is valid, add it to the result
            if (isValid(current)) {
                result.add(current);
                foundValid = true;
            }

            // If a valid expression has been found, skip further processing at this level
            if (foundValid) continue;

            // Generate all possible states by removing one parenthesis
            for (int i = 0; i < current.length(); i++) {
                // Skip non-parenthesis characters
                if (current.charAt(i) != '(' && current.charAt(i) != ')') continue;

                // Create a new string by removing the character at index i
                String next = current.substring(0, i) + current.substring(i + 1);

                // Add to queue if it hasn't been visited
                if (!visited.contains(next)) {
                    queue.add(next);
                    visited.add(next);
                }
            }
        }

        return result;
    }

    // Helper function to check if a string is valid
    private boolean isValid(String s) {
        int balance = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') balance++;
            else if (c == ')') {
                balance--;
                if (balance < 0) return false; // More ')' than '('
            }
        }
        return balance == 0; // Balanced if equal '(' and ')'
    }
}

