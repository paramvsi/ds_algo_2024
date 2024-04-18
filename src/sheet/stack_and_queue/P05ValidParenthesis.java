package sheet.stack_and_queue;


import java.util.Stack;

public class P05ValidParenthesis {
    public static boolean isValid(String s) {
        // Stack to hold opening brackets
        Stack<Character> stack = new Stack<>();

        // Iterate over each character in the string
        for (char c : s.toCharArray()) {
            // If the character is an opening bracket, push its corresponding closing bracket
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else {
                // If the stack is empty or the top of the stack is not the character, return false
                if (stack.isEmpty() || stack.pop() != c) {
                    return false;
                }
            }
        }

        // If the stack is empty, then all brackets were matched correctly
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String expression = "{[(())]}";
        System.out.println("The expression " + expression + " has valid parentheses: " + isValid(expression));

        String expression2 = "{[([())}]}";
        System.out.println("The expression " + expression2 + " has valid parentheses: " + isValid(expression2));
    }
}

