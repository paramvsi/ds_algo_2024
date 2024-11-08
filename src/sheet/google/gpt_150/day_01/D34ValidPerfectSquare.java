package sheet.google.gpt_150.day_01;


public class D34ValidPerfectSquare {
    public static boolean isPerfectSquare(int num) {
        if (num < 1) return false;

        long left = 1, right = num;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            long square = mid * mid;

            if (square == num) {
                return true;
            } else if (square < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int num1 = 16;
        System.out.println("Is " + num1 + " a perfect square? " + isPerfectSquare(num1)); // Output: true

        int num2 = 14;
        System.out.println("Is " + num2 + " a perfect square? " + isPerfectSquare(num2)); // Output: false
    }
}

