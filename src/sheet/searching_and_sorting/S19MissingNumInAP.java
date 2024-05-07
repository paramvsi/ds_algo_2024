package sheet.searching_and_sorting;

// To find the missing number in an arithmetic progression (AP), you can use the formula for the sum of an AP and then find the difference between the
// expected sum and the actual sum of the given sequence.
public class S19MissingNumInAP {

    public static int findMissingNumber(int[] arr) {
        int n = arr.length + 1; // Total number of elements including the missing one
        int sum = (n * (arr[0] + arr[n - 2])) / 2; // Sum of first and last elements
        int actualSum = 0;

        for (int num : arr) {
            actualSum += num; // Calculate the actual sum of the given sequence
        }

        return sum - actualSum; // Return the missing number
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 10}; // Example input array
        System.out.println("Missing number in the arithmetic progression: " + findMissingNumber(arr));
    }
}

