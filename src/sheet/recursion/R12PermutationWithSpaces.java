package sheet.recursion;

public class R12PermutationWithSpaces {

    // Function to generate permutations with spaces
    public static void permutationWithSpaces(String input) {
        // Start the recursive process with the first character of the input string
        char[] result = new char[2 * input.length() - 1];
        result[0] = input.charAt(0);
        permuteUtil(input, result, 1, 1);
    }

    // Utility function for recursive permutation generation
    private static void permuteUtil(String input, char[] result, int inputIndex, int resultIndex) {
        // If we reach the end of the input string, print the result
        if (inputIndex == input.length()) {
            System.out.println(String.valueOf(result, 0, resultIndex));
            return;
        }

        // Include the next character without space
        result[resultIndex] = input.charAt(inputIndex);
        permuteUtil(input, result, inputIndex + 1, resultIndex + 1);

        // Include the next character with a space
        result[resultIndex] = ' ';
        result[resultIndex + 1] = input.charAt(inputIndex);
        permuteUtil(input, result, inputIndex + 1, resultIndex + 2);
    }

    public static void main(String[] args) {
        String input = "ABCD";
        permutationWithSpaces(input);
    }
}

