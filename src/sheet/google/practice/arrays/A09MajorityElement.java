package sheet.google.practice.arrays;

public class A09MajorityElement {
    public static int majorityElement(int[] nums) {
        // Implement your logic here
        int candidate = nums[0];
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == candidate) {
                count++;
            } else {
                count--;
            }

            if (count == 0) {
                candidate = nums[i];
                count = 1;
            }
        }


        return candidate; // Placeholder for the majority element
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 3}; // Example input
        System.out.println("Majority element: " + majorityElement(nums));
    }
}

