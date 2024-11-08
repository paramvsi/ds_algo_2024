package sheet.google.gpt_150.day_01;

public class D07ContainerWithMaxWater {

    private static int maxWater(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int max = 0;

        while (left < right) {
            // Calculate the area formed by the current left and right pointers
            int width = right - left;
            int height = Math.min(heights[left], heights[right]);
            max = Math.max(max, width * height);

            // Move the pointer with the smaller height
            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] heights1 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int[] heights2 = {1, 1};
        int[] heights3 = {4, 3, 2, 1, 4};
        int[] heights4 = {1, 2, 1};

        System.out.println("Test Case 1: Expected 49, Actual: " + maxWater(heights1));
        System.out.println("Test Case 2: Expected 1, Actual: " + maxWater(heights2));
        System.out.println("Test Case 3: Expected 16, Actual: " + maxWater(heights3));
        System.out.println("Test Case 4: Expected 2, Actual: " + maxWater(heights4));
    }

}
