package sheet.google.gpt_150.day_01;


import java.util.Deque;
import java.util.LinkedList;

public class D30RemoveKDigits {
    public static String removeKdigits(String num, int k) {
        // Edge case: If k is equal to the length of num, return "0"
        if (k == num.length()) {
            return "0";
        }

        // Use a deque (stack) to store the resulting digits
        Deque<Character> stack = new LinkedList<>();

        for (char digit : num.toCharArray()) {
            // Remove the top element from the stack if:
            // 1. There are digits left to remove (k > 0)
            // 2. The stack is not empty
            // 3. The top element in the stack is greater than the current digit
            while (k > 0 && !stack.isEmpty() && stack.peekLast() > digit) {
                stack.removeLast();
                k--;
            }
            stack.addLast(digit);
        }

        // If k is still greater than 0, remove the last k elements
        while (k > 0) {
            stack.removeLast();
            k--;
        }

        // Build the final result while skipping any leading zeros
        StringBuilder result = new StringBuilder();
        boolean leadingZero = true;

        for (char digit : stack) {
            if (leadingZero && digit == '0') {
                continue;
            }
            leadingZero = false;
            result.append(digit);
        }

        // Return the result or "0" if result is empty
        return result.isEmpty() ? "0" : result.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeKdigits("1432219", 3)); // Output: "1219"
        System.out.println(removeKdigits("10200", 1));   // Output: "200"
        System.out.println(removeKdigits("10", 2));      // Output: "0"
    }
}

