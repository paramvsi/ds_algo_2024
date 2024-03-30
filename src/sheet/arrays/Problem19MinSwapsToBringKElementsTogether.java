package sheet.arrays;

public class Problem19MinSwapsToBringKElementsTogether {
    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 6, 3};
        int k = 3;

        System.out.println(minSwapsRequired(arr, k));
    }

    private static int minSwapsRequired(int[] arr, int k) {

        int windowSize = 0;
        int badValue = 0;
        for (int num : arr) {
            if (num <= k) {
                windowSize++;
            }
        }

        for (int i = 0; i < windowSize; i++) {
            if (arr[i] > k) {
                badValue++;
            }
        }

        int ans = badValue;
        int i = 0;
        int j = windowSize;

        while (j < arr.length) {
            if (arr[i] > k) {
                badValue--;
            }

            if (arr[j] > k) {
                badValue++;
            }

            ans = Math.min(ans, badValue);
            i++;
            j++;
        }

        return ans;
    }
}
