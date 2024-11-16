package sheet.google.practice.arrays;


public class A03MoveZeroes {
    public static void moveZeroes(int[] nums) {
        int i = 0; // Initialize pointer for the position of the next non-zero element

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                if (i != j) { // Check if there's a need to swap to avoid unnecessary operations
                    nums[i] = nums[j];
                    nums[j] = 0;
                }
                i++; // Move i to the next position
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12}; // Example input
        moveZeroes(nums);
        System.out.println("Array after moving zeroes: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}

