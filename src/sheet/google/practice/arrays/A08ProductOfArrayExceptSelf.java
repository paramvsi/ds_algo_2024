package sheet.google.practice.arrays;

public class A08ProductOfArrayExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        // Initialize the first element of result array
        result[0] = 1;

        // Fill result with the products of all elements to the left of each index
        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        // Variable to store the product of all elements to the right of each index
        int product = 1;

        // Update result by multiplying with the products of all elements to the right of each index
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] = result[i] * product;
            product *= nums[i];
        }

        return result; // Return the updated array
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4}; // Example input
        int[] result = productExceptSelf(nums);
        System.out.print("Output array: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}

