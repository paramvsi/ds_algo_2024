package sheet.google.months_6;


public class F10MaxPointYouCanObtainFromCards {
    public static void main(String[] args) {
        F10MaxPointYouCanObtainFromCards solution = new F10MaxPointYouCanObtainFromCards();

        // Test cases
        int[] cardPoints1 = {1, 2, 3, 4, 5, 6, 1};
        int k1 = 3;
        System.out.println(solution.maxScore(cardPoints1, k1)); // Output: 12

        int[] cardPoints2 = {2, 2, 2};
        int k2 = 2;
        System.out.println(solution.maxScore(cardPoints2, k2)); // Output: 4

        int[] cardPoints3 = {9, 7, 7, 9, 7, 7, 9};
        int k3 = 7;
        System.out.println(solution.maxScore(cardPoints3, k3)); // Output: 55
    }

    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int totalSum = 0;

        // Compute the total sum of the array
        for (int point : cardPoints) {
            totalSum += point;
        }

        // Size of the window to skip
        int windowSize = n - k;

        // Find the minimum sum of a subarray of size n-k
        int windowSum = 0;
        for (int i = 0; i < windowSize; i++) {
            windowSum += cardPoints[i];
        }

        int minWindowSum = windowSum;

        // Slide the window across the array
        for (int i = windowSize; i < n; i++) {
            windowSum += cardPoints[i] - cardPoints[i - windowSize];
            minWindowSum = Math.min(minWindowSum, windowSum);
        }

        // Maximum score is the total sum minus the minimum sum of skipped elements
        return totalSum - minWindowSum;
    }
}

