package sheet.stack_and_queue;

import java.util.Stack;

public class P09EvaluateArithmeticExpression {

    // Function to convert infix expression to postfix
    public static String infixToPostfix(String exp) {
        StringBuilder output = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char c : exp.toCharArray()) {
            if (Character.isDigit(c)) {
                output.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(')
                    output.append(stack.pop());
                stack.pop();
            } else { // Operator encountered
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    output.append(stack.pop());
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            output.append(stack.pop());
        }

        return output.toString();
    }

    // Function to evaluate the postfix expression
    public static int evaluatePostfix(String postfix) {
        Stack<Integer> stack = new Stack<>();

        for (char c : postfix.toCharArray()) {
            if (Character.isDigit(c)) {
                stack.push(c - '0'); // Convert char to integer
            } else {
                int b = stack.pop(); // Second operand
                int a = stack.pop(); // First operand
                switch (c) {
                    case '+':
                        stack.push(a + b);
                        break;
                    case '-':
                        stack.push(a - b);
                        break;
                    case '*':
                        stack.push(a * b);
                        break;
                    case '/':
                        stack.push(a / b);
                        break;
                }
            }
        }

        return stack.pop();
    }

    // Helper function to return precedence of operators
    private static int precedence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
        }
        return -1;
    }

    public static void main(String[] args) {
        String exp = "3+(2*4)-9/(1+2)";
        String postfix = infixToPostfix(exp);
        System.out.println("Postfix Expression: " + postfix);
        System.out.println("Result: " + evaluatePostfix(postfix));
    }
}

