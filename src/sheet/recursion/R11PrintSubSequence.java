package sheet.recursion;

public class R11PrintSubSequence {
    // Function to print all subsequences of a given string
    public static void printSubsequences(String input, String current, int index) {
        // When the index equals the length of the input string, print the current subsequence
        if (index == input.length()) {
            System.out.println(current);
            return;
        }

        // Include the current character in the subsequence
        printSubsequences(input, current + input.charAt(index), index + 1);

        // Do not include the current character in the subsequence
        printSubsequences(input, current, index + 1);
    }

    public static void main(String[] args) {
        String str = "abc";
        printSubsequences(str, "", 0);  // Start with an empty current string and index 0
    }
}

