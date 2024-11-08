package sheet.google.backtracking;


import java.util.ArrayList;
import java.util.List;

public class B03NDigitsNumberWithIncreasingOrder {
    public static void main(String[] args) {
        int n = 3; // Number of digits
        List<String> result = new ArrayList<>();
        generateIncreasingNumbers(n, 1, "", result);
        System.out.println(result);
    }

    // Function to generate all N-digit numbers in increasing order
    public static void generateIncreasingNumbers(int n, int startDigit, String currentNumber, List<String> result) {
        // Base case: if the current number has N digits, add it to the result
        if (currentNumber.length() == n) {
            result.add(currentNumber);
            return;
        }

        // Try each possible digit from the startDigit to 9
        for (int digit = startDigit; digit <= 9; digit++) {
            // Recurse with the next digit, building the number in increasing order
            generateIncreasingNumbers(n, digit + 1, currentNumber + digit, result);
        }
    }
}
