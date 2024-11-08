package sheet.google.backtracking;


public class B02FindLargestNumberWithKSteps {
    static String maxNumber = "";

    public static void main(String[] args) {
        String number = "2737"; // Example input
        int k = 2; // Number of swaps allowed
        maxNumber = number; // Initialize with the original number
        findMaximum(number.toCharArray(), k);
        System.out.println("Largest number possible: " + maxNumber);

        // optimize with greedy
        String number2 = "4577";
        maxNumber = number2;
        findMaximum2(number2.toCharArray(), k);
        System.out.println("Largest number possible: " + maxNumber);
    }

    // Recursive function to find the largest number by making k swaps
    public static void findMaximum(char[] number, int k) {
        // Base case: if no swaps left
        if (k == 0) {
            return;
        }

        // Check current number against maxNumber
        String currentNumber = new String(number);
        if (currentNumber.compareTo(maxNumber) > 0) {
            maxNumber = currentNumber;
        }

        // Perform all possible swaps of pairs and recurse
        for (int i = 0; i < number.length - 1; i++) {
            for (int j = i + 1; j < number.length; j++) {
                // Swap if the second digit is greater or to explore all swaps
                if (number[i] < number[j]) {
                    swap(number, i, j);

                    // Recurse with reduced swap count
                    findMaximum(number, k - 1);

                    // Backtrack (revert the swap)
                    swap(number, i, j);
                }
            }
        }
    }

    // Helper function to swap two characters in a char array
    public static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void findMaximum2(char[] number, int k) {
        if (k == 0) {
            return;
        }

        String currentNumber = new String(number);
        if (currentNumber.compareTo(maxNumber) > 0) {
            maxNumber = currentNumber;
        }

        int n = number.length;

        // Identify the largest digit from the remaining unsorted section
        for (int i = 0; i < n - 1; i++) {
            char maxChar = number[i];
            int maxPos = i;

            // Find the largest digit to swap with number[i]
            for (int j = i + 1; j < n; j++) {
                if (number[j] >= maxChar) { // Prioritize rightmost occurrence
                    maxChar = number[j];
                    maxPos = j;
                }
            }

            // Only swap if it increases the value
            if (maxPos != i && number[i] < maxChar) {
                swap(number, i, maxPos);
                findMaximum(number, k - 1); // Recurse with reduced k
                swap(number, i, maxPos);    // Backtrack
            }
        }
    }
}
