package sheet.google.backtracking;


// Backtracking = controlled recursion + pass by reference

// Identify -> while dp says find something optimal, Backtracking says find every combination of such answers

import java.util.ArrayList;
import java.util.List;

public class B01Backtracking {
    public static void main(String[] args) {
        String str = "ABC";
        List<String> result = new ArrayList<>();
        permute(str, "", result);
        System.out.println(result);
    }

    public static void permute(String str, String current, List<String> result) {
        if (str.isEmpty()) {
            result.add(current);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            // Choose a character
            char ch = str.charAt(i);

            // Exclude the chosen character and get the remaining substring
            String remaining = str.substring(0, i) + str.substring(i + 1);

            // Recursive call with updated current and remaining string
            permute(remaining, current + ch, result);
        }
    }
}

