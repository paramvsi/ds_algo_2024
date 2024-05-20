package sheet.recursion;


public class R13PermutationWithCaseChange {

    // Function to generate permutations with case changes
    public static void permutationWithCaseChanger(String input) {
        char[] result = new char[input.length()];
        generatePermutations(input.toCharArray(), result, 0);
    }

    // Utility function for recursive permutation generation
    private static void generatePermutations(char[] input, char[] result, int index) {
        // If we reach the end of the input string, print the result
        if (index == input.length) {
            System.out.println(String.valueOf(result));
            return;
        }

        // Include the next character as it is (lowercase)
        result[index] = Character.toLowerCase(input[index]);
        generatePermutations(input, result, index + 1);

        // Include the next character as uppercase (if it is a letter)
        if (Character.isLetter(input[index])) {
            result[index] = Character.toUpperCase(input[index]);
            generatePermutations(input, result, index + 1);
        }
    }

    public static void main(String[] args) {
        String input = "a1b2";
        permutationWithCaseChanger(input);
    }
}

