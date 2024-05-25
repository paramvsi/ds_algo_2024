package sheet.recursion;

public class R15JosephusProblem {
    // Function to find the position of the last person standing
    public static int josephus(int n, int k) {
        int survivor = 0;  // The position of the survivor (0-indexed)
        for (int i = 1; i <= n; i++) {
            survivor = (survivor + k) % i;
        }
        return survivor + 1;  // Convert to 1-indexed position
    }

    public static void main(String[] args) {
        int n = 14;  // Number of people
        int k = 2;   // Every second person will be killed
        System.out.println("The position of the survivor is: " + josephus(n, k));
    }
}
