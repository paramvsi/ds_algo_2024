package sheet.google.months_6._2;

//  https://leetcode.com/problems/remove-comments


import java.util.ArrayList;
import java.util.List;

public class F19RemoveComments {

    public static void main(String[] args) {
        F19RemoveComments solution = new F19RemoveComments();

        // Test case 1
        String[] source1 = {
                "/*Test program */",
                "int main() {",
                "  // variable declaration ",
                "  int a, b, c;",
                "  /* This is a",
                "     multi-line comment for",
                "     testing */",
                "  a = b + c;",
                "}"
        };
        System.out.println(solution.removeComments(source1));
        // Output: ["int main() {", "  int a, b, c;", "  a = b + c;", "}"]

        // Test case 2
        String[] source2 = {
                "a/*comment", "line", "more_comment*/b"
        };
        System.out.println(solution.removeComments(source2));
        // Output: ["ab"]
    }

    public List<String> removeComments(String[] source) {
        List<String> result = new ArrayList<>();
        StringBuilder newLine = new StringBuilder();
        boolean inBlock = false;

        for (String line : source) {
            int i = 0;
            char[] chars = line.toCharArray();
            if (!inBlock) {
                newLine = new StringBuilder(); // Start a new line
            }
            while (i < chars.length) {
                if (!inBlock && i + 1 < chars.length && chars[i] == '/' && chars[i + 1] == '*') {
                    // Start of a block comment
                    inBlock = true;
                    i += 2; // Skip "/*"
                } else if (inBlock && i + 1 < chars.length && chars[i] == '*' && chars[i + 1] == '/') {
                    // End of a block comment
                    inBlock = false;
                    i += 2; // Skip "*/"
                } else if (!inBlock && i + 1 < chars.length && chars[i] == '/' && chars[i + 1] == '/') {
                    // Line comment
                    break; // Ignore the rest of the line
                } else if (!inBlock) {
                    // Add non-comment characters
                    newLine.append(chars[i]);
                    i++;
                } else {
                    i++; // Skip characters inside a block comment
                }
            }
            // If we're not in a block comment and there's content, add it to the result
            if (!inBlock && newLine.length() > 0) {
                result.add(newLine.toString());
            }
        }

        return result;
    }
}

