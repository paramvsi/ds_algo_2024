package sheet.searching_and_sorting;

public class S04SquareRootOfAnInteger {
    public static int sqrt(int x) {
        if (x < 2) return x;  // Handle cases 0 and 1 separately

        long left = 1, right = x / 2;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long squared = mid * mid;
            if (squared == x) {
                return (int) mid;
            } else if (squared < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return (int) right;  // 'right' is the largest integer whose square is <= x
    }

    public static void main(String[] args) {
        int number = 10;
        System.out.println("The integer square root of " + number + " is " + sqrt(number));
    }
}
