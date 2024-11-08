package sheet.google.gpt_150.day_01;
/*
A conveyor belt has packages that need to be shipped in a certain order.
You are given an integer array weights where weights[i] is the weight of the i-th package on the conveyor belt.
Each day, you can load packages onto the ship according to the given order (you must ship the packages in order).
You can’t load more weight than the ship's capacity. Given an integer days, return the minimum capacity of
the ship required to ship all the packages within days.*/


public class D32CapacityToShipPackagesInDDays {

    public static int shipWithinDays(int[] weights, int days) {
        // Define the bounds for binary search
        int left = 0, right = 0;

        // Calculate the left (max weight) and right (sum of all weights) bounds
        for (int weight : weights) {
            left = Math.max(left, weight); // left is the heaviest single package
            right += weight; // right is the sum of all package weights
        }

        // Binary search for the minimum capacity needed to ship within `days`
        while (left < right) {
            int mid = left + (right - left) / 2;

            // Check if `mid` capacity can ship all packages within `days`
            if (canShipInDays(weights, days, mid)) {
                right = mid; // Try a smaller capacity
            } else {
                left = mid + 1; // Increase capacity
            }
        }

        return left; // `left` is now the minimum capacity to ship within `days`
    }

    // Helper function to determine if we can ship all packages within `days` given `capacity`
    private static boolean canShipInDays(int[] weights, int days, int capacity) {
        int dayCount = 1; // Start with the first day
        int currentWeight = 0;

        for (int weight : weights) {
            // Check if adding the current weight exceeds the capacity
            if (currentWeight + weight > capacity) {
                dayCount++; // Use a new day for this package
                currentWeight = weight; // Reset the current weight to the new day's load
                if (dayCount > days) {
                    return false; // If we exceed `days`, return false
                }
            } else {
                currentWeight += weight; // Add the weight to the current day's load
            }
        }

        return true; // All packages can be shipped within `days`
    }

    public static void main(String[] args) {
        int[] weights1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int days1 = 5;
        System.out.println("Minimum Capacity for Test Case 1: " + shipWithinDays(weights1, days1)); // Expected output: 15

        int[] weights2 = {3, 2, 2, 4, 1, 4};
        int days2 = 3;
        System.out.println("Minimum Capacity for Test Case 2: " + shipWithinDays(weights2, days2)); // Expected output: 6

        int[] weights3 = {1, 2, 3, 1, 1};
        int days3 = 4;
        System.out.println("Minimum Capacity for Test Case 3: " + shipWithinDays(weights3, days3)); // Expected output: 3
    }
}


