package sheet.google.gpt_150.day_02;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class D22BraceExpansion {

    public static void main(String[] args) {
        D22BraceExpansion solution = new D22BraceExpansion();

        String s1 = "{a,b}c{d,e}f";
        System.out.println("Expanded: " + Arrays.toString(solution.expand(s1))); // Output: ["acdf", "acef", "bcdf", "bcef"]

        String s2 = "abcd";
        System.out.println("Expanded: " + Arrays.toString(solution.expand(s2))); // Output: ["abcd"]
    }

    public String[] expand(String s) {
        List<List<String>> options = new ArrayList<>();

        // Parse the string and fill `options` with characters or choices
        for (int i = 0; i < s.length(); ) {
            List<String> option = new ArrayList<>();

            if (s.charAt(i) == '{') {
                int j = i;
                while (s.charAt(j) != '}') {
                    j++;
                }

                // Extract the choices within the braces and split by comma
                String[] choices = s.substring(i + 1, j).split(",");
                option.addAll(Arrays.asList(choices));
                Collections.sort(option); // Sort choices to ensure lexicographic order
                i = j + 1;
            } else {
                // Extract individual character as a single choice
                option.add(String.valueOf(s.charAt(i)));
                i++;
            }

            options.add(option);
        }

        // List to store all expanded results
        List<String> result = new ArrayList<>();

        // Start recursive expansion
        backtrack(options, 0, new StringBuilder(), result);

        // Convert list to array and return
        return result.toArray(new String[0]);
    }

    private void backtrack(List<List<String>> options, int index, StringBuilder current, List<String> result) {
        // Base case: if we've reached the end, add the current combination to the result
        if (index == options.size()) {
            result.add(current.toString());
            return;
        }

        // Recursively expand each option at the current index
        for (String choice : options.get(index)) {
            int lengthBeforeAppend = current.length();
            current.append(choice);  // Add current choice
            backtrack(options, index + 1, current, result);  // Recurse to next index
            current.setLength(lengthBeforeAppend);  // Backtrack to remove the added choice
        }
    }
}

