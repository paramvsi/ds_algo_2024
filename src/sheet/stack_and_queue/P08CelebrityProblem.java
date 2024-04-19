package sheet.stack_and_queue;


import java.util.Stack;

public class P08CelebrityProblem {

    private static final boolean[][] matrix = {
            {false, true, false, false},   // Person 0 knows Person 1
            {false, false, false, false},  // Person 1 knows no one
            {true, true, false, true},     // Person 2 knows Person 0, 1, and 3
            {false, true, false, false}   // Person 3 knows no one
    };

    // Example method to determine if a person a knows person b.
    // This should be implemented according to the problem's requirements.
    private static boolean knows(int a, int b) {
        // Implementation specific to your setup
        return matrix[a][b]; // Placeholder return
    }

    public static int findCelebrity(int n) {
        Stack<Integer> stack = new Stack<>();

        // Push everybody onto stack
        for (int i = 0; i < n; i++) {
            stack.push(i);
        }

        while (stack.size() > 1) {
            int a = stack.pop();
            int b = stack.pop();

            // If a knows b, then a can't be the celebrity, but b might be
            if (knows(a, b)) {
                stack.push(b);
            } else { // If a doesn't know b, then b can't be the celebrity, but a might be
                stack.push(a);
            }
        }

        int candidate = stack.pop();

        // Verify candidate is a celebrity
        for (int i = 0; i < n; i++) {
            if (i != candidate && (knows(candidate, i) || !knows(i, candidate))) {
                return -1; // No celebrity
            }
        }

        return candidate;
    }

    public static void main(String[] args) {
        int n = 4; // Number of people
        int celebrity = findCelebrity(n);
        System.out.println("Celebrity ID: " + celebrity);
    }
}


