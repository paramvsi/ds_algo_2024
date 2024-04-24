package sheet.strings;

public class S14MinSwapsForBracketBalancing {

    public static int minSwapsToBalance(String brackets) {
        int open = 0;
        int close = 0;
        int swap = 0;
        int imbalance = 0;

        // Traverse through the bracket string
        for (int i = 0; i < brackets.length(); i++) {
            char ch = brackets.charAt(i);

            if (ch == '(') {
                open++; // Found an opening bracket
            } else {
                close++; // Found a closing bracket
            }

            // If close > open, there's an imbalance
            if (close > open) {
                imbalance = close - open;
                // A swap can fix the current imbalance
                swap += imbalance;
            }
        }

        // Total swaps needed is half of the total imbalances,
        // since each successful swap fixes two imbalances.
        return swap;
    }

    public static void main(String[] args) {
        String brackets = "()))((()";
        System.out.println("Minimum swaps needed: " + minSwapsToBalance(brackets));
    }
}

