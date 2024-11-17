package sheet.google.practice.strings;


public class S05ReverseString {
    public static void reverseString(char[] s) {
        // Implement your logic here
        int start = 0;
        int end = s.length - 1;

        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;

            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        reverseString(s);
        System.out.println("Reversed string: " + new String(s));
    }
}

