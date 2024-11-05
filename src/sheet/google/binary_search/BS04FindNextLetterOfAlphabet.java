package sheet.google.binary_search;

// Similar problem to Ceil of a element
public class BS04FindNextLetterOfAlphabet {

    public static void main(String[] args) {
        char[] arr = {'a', 'b', 'f', 'l'};
        char c = 'g';

        System.out.println(findNextLetter(arr, c));
    }

    private static char findNextLetter(char[] arr, char c) {
        int start = 0;
        int end = arr.length - 1;

        // If the given character is larger than or equal to the last element,
        // wrap around to the first element in a cyclic manner.
        if (c >= arr[end]) {
            return arr[0];
        }

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] > c) {
                end = mid - 1;  // Look for a closer match on the left
            } else {
                start = mid + 1;  // Move right to find a larger element
            }
        }

        // At the end of the loop, 'start' is the index of the smallest character
        // that is greater than 'c' due to binary search properties.
        return arr[start];
    }


}
