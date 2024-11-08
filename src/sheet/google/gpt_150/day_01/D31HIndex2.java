package sheet.google.gpt_150.day_01;


public class D31HIndex2 {
    public static int hIndex(int[] citations) {
        int n = citations.length;
        int left = 0, right = n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Calculate the potential h-index at this position
            int h = n - mid;

            if (citations[mid] == h) {
                return h;  // We've found the exact h-index
            } else if (citations[mid] < h) {
                left = mid + 1;  // Move right to find a higher h-index
            } else {
                right = mid - 1;  // Move left to find a smaller h-index
            }
        }

        // If not found exactly, left will be at the position where the condition holds
        return n - left;
    }

    public static void main(String[] args) {
        int[] citations1 = {0, 1, 3, 5, 6};
        System.out.println("H-Index: " + hIndex(citations1)); // Output: 3

        int[] citations2 = {1, 2, 100};
        System.out.println("H-Index: " + hIndex(citations2)); // Output: 2
    }
}

