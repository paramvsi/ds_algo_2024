package sheet.google.months_6._2;

//  https://leetcode.com/problems/24-game
import java.util.ArrayList;
import java.util.List;

public class F04Game24 {

    public static void main(String[] args) {
        F04Game24 game24 = new F04Game24();

        // Test cases
        System.out.println(game24.judgePoint24(new int[]{8, 1, 6, 6})); // Output: true
        System.out.println(game24.judgePoint24(new int[]{1, 2, 1, 2})); // Output: false
    }

    public boolean judgePoint24(int[] nums) {
        // Convert the input array to a list of doubles
        List<Double> numbers = new ArrayList<>();
        for (int num : nums) {
            numbers.add((double) num);
        }

        return backtrack(numbers);
    }

    private boolean backtrack(List<Double> numbers) {
        // Base case: If only one number is left, check if it equals 24
        if (numbers.size() == 1) {
            return Math.abs(numbers.get(0) - 24) < 1e-6; // Use a tolerance for floating-point precision
        }

        // Try all pairs of numbers
        for (int i = 0; i < numbers.size(); i++) {
            for (int j = 0; j < numbers.size(); j++) {
                if (i == j) continue; // Skip using the same number twice

                List<Double> nextNumbers = new ArrayList<>();
                for (int k = 0; k < numbers.size(); k++) {
                    if (k != i && k != j) {
                        nextNumbers.add(numbers.get(k)); // Add the unused numbers to the list
                    }
                }

                // Try all four operations
                for (double result : compute(numbers.get(i), numbers.get(j))) {
                    nextNumbers.add(result); // Add the result of the operation
                    if (backtrack(nextNumbers)) {
                        return true;
                    }
                    nextNumbers.remove(nextNumbers.size() - 1); // Backtrack
                }
            }
        }

        return false; // If no valid operation sequence leads to 24
    }

    private List<Double> compute(double a, double b) {
        List<Double> results = new ArrayList<>();
        results.add(a + b); // Addition
        results.add(a - b); // Subtraction
        results.add(b - a); // Reverse Subtraction
        results.add(a * b); // Multiplication
        if (Math.abs(b) > 1e-6) results.add(a / b); // Division (avoid division by zero)
        if (Math.abs(a) > 1e-6) results.add(b / a); // Reverse Division
        return results;
    }
}

