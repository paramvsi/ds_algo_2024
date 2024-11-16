package sheet.google.practice.arrays;

public class A06PlusOne {
    public static int[] plusOne(int[] digits) {
        int n = digits.length;

        for (int i = n - 1; i >= 0; i--) {
            // Add one to the last digit and check for carry
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0; // Reset current digit to 0 (e.g., from 9 to 0)
        }

        // If all digits are 9, e.g., 999 -> 1000
        int[] newDigits = new int[n + 1];
        newDigits[0] = 1; // The only '1' at the beginning
        // No need to set other elements to 0 because int arrays are initialized to 0 in Java

        return newDigits; // Return the new array with the incremented value
    }


    public static void main(String[] args) {
        int[] digits = {1, 2, 3}; // Example input
        System.out.println("Array after adding one: ");
        int[] result = plusOne(digits);
        for (int digit : result) {
            System.out.print(digit + " ");
        }
    }
}

