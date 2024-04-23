package sheet.strings;


public class S03CountAndSay {
    public static String countAndSay(int n) {
        if (n <= 0) return "";

        String result = "1";
        while (n > 1) {
            StringBuilder current = new StringBuilder();
            for (int i = 0; i < result.length(); i++) {
                int count = 1; // start counting from 1
                // Check the number of occurrences of the same digit
                while (i + 1 < result.length() && result.charAt(i) == result.charAt(i + 1)) {
                    i++;
                    count++;
                }
                // Append count and digit
                current.append(count).append(result.charAt(i));
            }
            result = current.toString();
            n--;
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println("The " + n + "th term of the 'Count and Say' sequence is: " + countAndSay(n));
    }
}
