package sheet.recursion;


public class R01PrintOneToN {
    public static void printNumbers(int current, int n) {
        if (current > n) {
            return; // Base case: stop the recursion when current exceeds n
        }
        System.out.println(current); // Print the current number
        printNumbers(current + 1, n); // Recursive call with the next number
    }

    public static void print(int n) {
        if (n == 1) {
            System.out.println(n);
            return; // Base case: stop the recursion when current exceeds n
        }

        print(n - 1); // Recursive call with the next number
        System.out.println(n);
    }

    public static void main(String[] args) {
        int N = 10; // You can change N to any positive integer
        printNumbers(1, N); // Start printing from 1 to N
        print(N);
    }
}


