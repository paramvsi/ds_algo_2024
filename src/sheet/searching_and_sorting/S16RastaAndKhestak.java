package sheet.searching_and_sorting;


// The "Rasta and Kheshtak" problem usually involves finding the maximum number of
// consecutive elements in an array that sum up to a value less than or equal to a given threshold.
// This problem can be solved using a sliding window technique
public class S16RastaAndKhestak {

    public static int maxConsecutiveElements(int[] arr, int threshold) {
        int maxConsecutive = 0;
        int windowSum = 0;
        int left = 0;

        for (int right = 0; right < arr.length; right++) {
            windowSum += arr[right];

            // Shrink the window from the left until the sum is less than or equal to the threshold
            while (windowSum > threshold) {
                windowSum -= arr[left];
                left++;
            }

            // Update the maximum consecutive elements if the current window size is greater
            maxConsecutive = Math.max(maxConsecutive, right - left + 1);
        }

        return maxConsecutive;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int threshold = 9;
        System.out.println("Maximum consecutive elements with sum less than or equal to threshold: " +
                maxConsecutiveElements(arr, threshold));
    }
}
