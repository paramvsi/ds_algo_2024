package sheet.strings;

public class S24RecursivelyRemoveAllAdjacentDuplicates {

    public static String removeDuplicates(String s) {
        if (s == null || s.length() <= 1) return s;

        StringBuilder sb = new StringBuilder();
        int count = 0; // To check if any duplicates were removed

        char[] chars = s.toCharArray();
        int i = 0;
        while (i < chars.length) {
            // Check if the current character is part of a group of duplicates
            boolean isDuplicate = false;
            while (i < chars.length - 1 && chars[i] == chars[i + 1]) {
                isDuplicate = true;
                i++;
            }

            if (!isDuplicate) { // If no duplicate, just append current character
                sb.append(chars[i]);
            } else { // If duplicates were found, increment count
                count++;
            }
            i++;
        }

        // If duplicates were removed, call recursively
        String result = sb.toString();
        if (count > 0) {
            return removeDuplicates(result);
        } else {
            return result;
        }
    }

    public static String removeDuplicatesWithoutRecursion(String s) {
        char[] chars=s.toCharArray();
        int i = -1;
        for(char c : chars){
            if(i >= 0 && c == chars[i])
                i--;
            else
                chars[++i]= c;

        }
        return String.valueOf(chars, 0, ++i);
    }

    public static void main(String[] args) {
        String input = "aaaaaaaaa";
        System.out.println("Result after removing all adjacent duplicates: " + removeDuplicates(input));
        System.out.println("Result after removing all adjacent duplicates: " + removeDuplicatesWithoutRecursion(input));
    }
}
