package sheet.arrays;

public class Problem12MaxProductSubArray {
    public static void main(String[] args) {
        int[] arr = { 6, -3, -10, 0, 2 };

        System.out.println("Max product is "+getMaxProduct(arr));
    }

    private static int getMaxProduct(int[] nums) {
        int maxResult = nums[0];

        int left = 0;
        int right = 0;

        for(int i =0; i <nums.length; i++){
            left = left == 0 ? 1 : left;
            right = right == 0 ? 1: right;

            left = left * nums[i];
            right = right * nums[nums.length - 1 - i];

            maxResult = Math.max(maxResult, Math.max(left, right));
        }

        return maxResult;
    }
}
