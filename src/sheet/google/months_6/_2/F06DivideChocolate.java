package sheet.google.months_6._2;

//  https://leetcode.com/problems/divide-chocolate
public class F06DivideChocolate {

    public static void main(String[] args) {
        F06DivideChocolate solution = new F06DivideChocolate();

        // Test cases
        System.out.println(solution.maximizeSweetness(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 5)); // Output: 6
        System.out.println(solution.maximizeSweetness(new int[]{5, 6, 7, 8, 9, 1, 2, 3, 4}, 8)); // Output: 1
        System.out.println(solution.maximizeSweetness(new int[]{1, 2, 2, 1, 2, 2, 1, 2, 2}, 2)); // Output: 5
    }

    public int maximizeSweetness(int[] sweetness, int k) {
        int low = 1; // Minimum possible sweetness
        int high = 0; // Maximum possible sweetness
        for (int sweet : sweetness) {
            high += sweet;
        }

        // Binary search
        while (low < high) {
            int mid = (low + high + 1) / 2;

            // Check if it's possible to divide the chocolate with minimum sweetness = mid
            if (canDivide(sweetness, k + 1, mid)) {
                low = mid; // Try for a larger minimum sweetness
            } else {
                high = mid - 1; // Reduce the range
            }
        }

        return low;
    }

    private boolean canDivide(int[] sweetness, int parts, int target) {
        int currentSweetness = 0;
        int count = 0;

        for (int sweet : sweetness) {
            currentSweetness += sweet;

            // If the current sum is >= target, make a new part
            if (currentSweetness >= target) {
                count++;
                currentSweetness = 0;

                // If we have enough parts, return true
                if (count >= parts) {
                    return true;
                }
            }
        }

        return false; // Not enough parts can be made
    }
}

