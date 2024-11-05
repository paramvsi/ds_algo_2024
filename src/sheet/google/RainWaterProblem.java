package sheet.google;


import static sheet.arrays.Problem16WaterTrapping.trap;

// iven n non-negative integers representing an elevation map,
// where the width of each bar is 1,
// compute how much water it can trap after raining.
public class RainWaterProblem {
    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println("Water trapped: " + trap(height)); // Expected output: 6
        System.out.println("Water trapped: " + trap2(height));
    }

    public static int trap2(int[] height) {
        int leftMax = 0;
        int rightMax = 0;
        int left = 0;
        int right = height.length - 1;

        int waterTrapped = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    waterTrapped = waterTrapped + leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    waterTrapped = waterTrapped + rightMax - height[right];
                }

                right--;
            }
        }

        return waterTrapped;
    }
}
