package sheet.arrays;


// Given an array of positive integers. We need to make the given array a ‘Palindrome’.
// The only allowed operation is”merging” (of two adjacent elements). Merging two adjacent elements means replacing
// them with their sum. The task is to find the minimum number of merge operations required to make the
// given array a ‘Palindrome’.
//
// To make any array a palindrome, we can simply apply merge operation n-1
// times when n is the size of the array (because a single-element array is always palindromic,
// similar to single-character string).
// In that case, the size of array will be reduced to 1.
// But in this problem, we are asked to do it in the minimum number of operations.
public class Problem20MinOperationsToMakeArrayPalindrome {

    public static void main(String[] args) {
       int[] arr = {1, 4, 5, 9, 1};

        System.out.println(minOperationsRequired(arr));
    }

    private static int minOperationsRequired(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        int mergeCount = 0;

        while (start < end) {
            if (arr[start] == arr[end]) {
                start++;
                end--;
            } else if (arr[start] < arr[end]) {
                start++;
                arr[start] += arr[start - 1];
                mergeCount++;
            } else {
                end--;
                arr[end] += arr[end + 1];
                mergeCount++;
            }
        }

        return mergeCount;
    }
}
