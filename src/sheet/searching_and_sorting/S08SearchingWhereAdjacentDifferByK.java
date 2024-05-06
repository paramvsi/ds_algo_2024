package sheet.searching_and_sorting;


public class S08SearchingWhereAdjacentDifferByK {

    public static int search(int[] arr, int x, int k) {
        int n = arr.length;
        int i = 0;
        while (i < n) {
            if (arr[i] == x)
                return i;

            // Calculate the absolute difference between the current element and x
            int diff = Math.abs(arr[i] - x);

            // Move to next element based on the value of k and the calculated difference
            i = i + Math.max(1, diff / k);
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 7, 9, 10, 11, 13, 15};
        int x = 9;
        int k = 3;
        int index = search(arr, x, k);
        if (index != -1) {
            System.out.println("Element " + x + " found at index " + index);
        } else {
            System.out.println("Element " + x + " not found in the array");
        }
    }
}

