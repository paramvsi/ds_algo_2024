package sheet.google.practice.strings;


public class S06ReverseWordInString {

    public static String reverseWords(String s) {
        // Trim the input to remove leading and trailing spaces
        s = s.trim();
        // Split the words in the string; regex "\\s+" handles multiple spaces between words
        String[] words = s.split("\\s+");
        // StringBuilder for efficient string concatenation
        StringBuilder reversed = new StringBuilder();

        // Reverse the order of words
        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]);
            if (i > 0) {  // Append a space if it's not the last word
                reversed.append(" ");
            }
        }

        return reversed.toString(); // Return the reversed string
    }


    public static void main(String[] args) {
        String s = "  hello world  "; // Example input
        System.out.println("Reversed words: " + reverseWords(s));
    }
}

